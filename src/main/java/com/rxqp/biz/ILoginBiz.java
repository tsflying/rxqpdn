package com.rxqp.biz;

import io.netty.channel.ChannelHandlerContext;

import com.rxqp.entity.bo.Player;
import com.rxqp.protobuf.DdzProto.MessageInfo;
import com.rxqp.protobuf.DdzProto.MessageInfo.Builder;

public interface ILoginBiz {

	/**
	 * 用户认证
	 * 
	 * @param openId
	 *            微信公众号的普通用户的一个唯一的标识
	 * @return
	 */
	public Player authenticate();

	public MessageInfo.Builder login(MessageInfo messageInfoReq,
			ChannelHandlerContext ctx);

}
