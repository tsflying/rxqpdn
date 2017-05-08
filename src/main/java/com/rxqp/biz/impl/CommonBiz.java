package com.rxqp.biz.impl;

import java.util.List;

import com.rxqp.biz.ICommonBiz;
import com.rxqp.protobuf.DdzProto.MESSAGE_ID;
import com.rxqp.protobuf.DdzProto.MessageInfo;
import com.rxqp.protobuf.DdzProto.MsgInfo;

public class CommonBiz implements ICommonBiz {

	@Override
	public MessageInfo.Builder setMessageInfo(Integer msgType, String message) {
		MessageInfo.Builder messageInfo = MessageInfo.newBuilder();
		messageInfo.setMessageId(MESSAGE_ID.msg_MsgInfo);
		MsgInfo.Builder msgInfo = MsgInfo.newBuilder();
		msgInfo.setType(msgType);
		msgInfo.setMessage(message);
		messageInfo.setMsgInfo(msgInfo);
		return messageInfo;
	}

	/**
	 * 交互list 索引a，b的值
	 * 
	 * @param lst
	 * @param a
	 * @param b
	 */
	public void swapLst(List<Integer> lst, Integer a, Integer b) {
		int tmp = lst.get(a);
		lst.set(a, lst.get(b));
		lst.set(b, tmp);
	}
}
