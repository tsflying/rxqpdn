package com.rxqp.common.constants;

import java.util.HashMap;

import com.rxqp.protobuf.DdzProto;


public class MessageProtoConstants {

	private static HashMap<DdzProto.MESSAGE_ID, Integer> messageHeadMap = new HashMap<DdzProto.MESSAGE_ID, Integer>();

	static {
		messageHeadMap.put(DdzProto.MESSAGE_ID.msg_LoginReq, 1);
	}

	public static byte getMessageType(DdzProto.MESSAGE_ID msgId) {
		Integer messageId = messageHeadMap.get(msgId);
		if (messageId != null) {
			return (byte) messageId.intValue();
		} else {
			return 0x00;
		}
	}
}
