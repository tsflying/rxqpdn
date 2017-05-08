package com.rxqp.biz;

import io.netty.channel.ChannelHandlerContext;

import com.rxqp.protobuf.DdzProto.MessageInfo;
import com.rxqp.protobuf.DdzProto.MessageInfo.Builder;

public interface IGameBiz {

	Builder dealProcess(MessageInfo messageInfoReq, ChannelHandlerContext ctx);

}
