package com.rxqp.biz;

import com.rxqp.protobuf.DdzProto;

import io.netty.channel.ChannelHandlerContext;


public interface ICoreBiz {

	public DdzProto.MessageInfo process(DdzProto.MessageInfo messageInfoReq,
			ChannelHandlerContext ctx);
}
