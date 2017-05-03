package com.rxqp.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.rxqp.annotation.ServiceExporter;
import com.rxqp.netty.handler.DnOutServerHandler;
import com.rxqp.netty.handler.DnServerHandler;
import com.rxqp.netty.handler.OutHandler;
import com.rxqp.netty.message.MessageProtobufDecode;
import com.rxqp.netty.message.MessageProtobufEncode;

@Component
public class NettyServer implements ApplicationContextAware {
	private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

	 private Channel channel;
	 private EventLoopGroup bossGroup;
	 private EventLoopGroup workerGroup;

	 private Map<String, Object> exportServiceMap = new HashMap<String, Object>();

	 @Value("${rpcServer.host:127.0.0.1}")
	 String host;

	 @Value("${rpcServer.ioThreadNum:5}")
	 int ioThreadNum;
	//内核为此套接口排队的最大连接个数，对于给定的监听套接口，内核要维护两个队列，未链接队列和已连接队列大小总和最大值

	 @Value("${rpcServer.backlog:1024}")
	 int backlog;

	 @Value("${rpcServer.port:9090}")
	 int port;

	/**
	 * 启动
	 * @throws InterruptedException
	*/
	 @PostConstruct
	 public void start() throws InterruptedException {
	 logger.info("begin to start rpc server");
	 bossGroup = new NioEventLoopGroup();
	 workerGroup = new NioEventLoopGroup(ioThreadNum);

	 ServerBootstrap serverBootstrap = new ServerBootstrap();
	 serverBootstrap.group(bossGroup, workerGroup)
	 .channel(NioServerSocketChannel.class)
	 .option(ChannelOption.SO_BACKLOG, backlog)
	 .handler(new LoggingHandler(LogLevel.INFO))
	 .handler(new OutHandler())
	 //注意是childOption
	 .childOption(ChannelOption.SO_KEEPALIVE, true)
	 .childOption(ChannelOption.TCP_NODELAY, true)
	 .childHandler(new ChannelInitializer<SocketChannel>() {
	@Override
	 protected void initChannel(SocketChannel socketChannel) throws Exception {
//	socketChannel.pipeline()
	//真实数据最大字节数为Integer.MAX_VALUE，解码时自动去掉前面四个字节
	 //io.netty.handler.codec.DecoderException: java.lang.IndexOutOfBoundsException: readerIndex(900) + length(176) exceeds writerIndex(1024): UnpooledUnsafeDirectByteBuf(ridx: 900, widx: 1024, cap: 1024)
//	 .addLast("decoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4))
//	 .addLast("encoder", new LengthFieldPrepender(4, false))
//	 .addLast(new RpcDecoder(RpcRequest.class))
//	 .addLast(new RpcEncoder(RpcResponse.class))
//	 .addLast(new ServerRpcHandler(exportServiceMap));
		socketChannel.pipeline().addLast(new MessageProtobufDecode());
		socketChannel.pipeline().addLast(new MessageProtobufEncode());
		socketChannel.pipeline().addLast(new DnOutServerHandler());
		socketChannel.pipeline().addLast(new DnServerHandler());
	}
	});

	 channel = serverBootstrap.bind(host,port).sync().channel();

	 logger.info("NettyRPC server listening on port"+ port +"and ready for connections...");
	}

	@PreDestroy
	 public void stop() {
		 logger.info("destroy server resources");
		 if (null == channel) {
			 logger.error("server channel is null");
		 }
		 bossGroup.shutdownGracefully();
		 workerGroup.shutdownGracefully();
		 channel.closeFuture().syncUninterruptibly();
		 bossGroup = null;
		 workerGroup = null;
		 channel = null;
	}

	/**
	 * 利用此方法获取spring ioc接管的所有bean
	 * @param ctx
	 * @throws BeansException
	*/
	 public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		 Map<String, Object> serviceMap = ctx.getBeansWithAnnotation(ServiceExporter.class); // 获取所有带有 ServiceExporter 注解的 Spring Bean
		 logger.info("获取到所有的RPC服务:{}", serviceMap);
		 if (serviceMap != null && serviceMap.size() > 0) {
			 for (Object serviceBean : serviceMap.values()) {
				 String interfaceName = serviceBean.getClass().getAnnotation(ServiceExporter.class).value().getName();
			//	 String interfaceName = serviceBean.getClass().getAnnotation(ServiceExporter.class)
			//	.targetInterface()
			//	.getName();
				 logger.info("register service mapping:{}",interfaceName);
				 exportServiceMap.put(interfaceName, serviceBean);
			}
		}
	}

}
