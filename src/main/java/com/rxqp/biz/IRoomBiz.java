package com.rxqp.biz;

import io.netty.channel.ChannelHandlerContext;

import com.rxqp.protobuf.DdzProto.MessageInfo;
import com.rxqp.protobuf.DdzProto.MessageInfo.Builder;

public interface IRoomBiz {

	Builder createNewRoom(MessageInfo messageInfoReq);

	Builder entryRoom(MessageInfo messageInfoReq, ChannelHandlerContext ctx);

}
