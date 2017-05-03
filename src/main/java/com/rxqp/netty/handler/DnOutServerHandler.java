package com.rxqp.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import com.rxqp.protobuf.DdzProto;

public class DnOutServerHandler extends ChannelOutboundHandlerAdapter {

	@Override
	public void write(ChannelHandlerContext ctx, Object msg,
			ChannelPromise promise) throws Exception {
		DdzProto.MessageInfo req = (DdzProto.MessageInfo) msg;
		System.out.println("--------resp:" + req.toString());
		// 执行下一个OutboundHandler
		super.write(ctx, msg, promise);
	}
}
