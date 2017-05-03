package com.rxqp.netty.message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import com.google.protobuf.MessageLite;
import com.rxqp.protobuf.DdzProto;

/**
 * 参考ProtobufVarint32LengthFieldPrepender 和 ProtobufEncoder
 */
@Sharable
public class MessageProtobufEncode extends MessageToByteEncoder<MessageLite> {

	// HangqingEncoder hangqingEncoder;

	// public CustomProtobufEncoder(HangqingEncoder hangqingEncoder) {
	// this.hangqingEncoder = hangqingEncoder;
	// }

	@Override
	protected void encode(ChannelHandlerContext ctx, MessageLite msg,
			ByteBuf out) throws Exception {

		byte[] body = msg.toByteArray();
		byte[] header = encodeHeader(msg, (short) body.length);

		out.writeBytes(header);
		out.writeBytes(body);

		return;
	}

	/**
	 * 为消息头添加4byte数据分别如下： body长度（low）、body长度（high）、保留字节 、类型
	 * 
	 * @param msg
	 * @param bodyLength
	 * @return
	 */
	private byte[] encodeHeader(MessageLite msg, short bodyLength) {
		DdzProto.MessageInfo messageInfo = (DdzProto.MessageInfo) msg;
		DdzProto.MESSAGE_ID mssageId = messageInfo.getMessageId();
		byte messageType = 0x00;
		// MessageProtoConstants.getMessageType(mssageId);

		// if (msg instanceof DdzProto.DiscardReq) {// 出牌返回广播
		// messageType = 0x0e;
		// } else if (msg instanceof DdzProto.DiscardPost) {// 出牌返回广播
		// messageType = 0x0f;
		// } else if (msg instanceof DdzProto.LoginReq) {// 登录请求
		// messageType = 0x01;
		// } else if (msg instanceof DdzProto.LoginResp) {// 登录返回
		// messageType = 0x02;
		// } else if (msg instanceof DdzProto.CreateRoomReq) {// 创建房间请求
		// messageType = 0x03;
		// } else if (msg instanceof DdzProto.CreateRoomResp) {// 创建房间返回
		// messageType = 0x04;
		// } else if (msg instanceof DdzProto.EntryRoomReq) {// 进入特定房间请求
		// messageType = 0x05;
		// } else if (msg instanceof DdzProto.EntryRoomResp) {// 进入房间返回
		// messageType = 0x06;
		// } else if (msg instanceof DdzProto.PostEntryRoom) {// 广播进入房间，开始玩游戏
		// messageType = 0x07;
		// } else if (msg instanceof DdzProto.Player) {// 玩家当前信息
		// messageType = 0x08;
		// } else if (msg instanceof DdzProto.DisbandReq) {// 玩家请求解散房间
		// messageType = 0x09;
		// } else if (msg instanceof DdzProto.DisbandPost) {// 广播其他玩家解散房间
		// messageType = 0x0a;
		// } else if (msg instanceof DdzProto.DisbandCheckReq) {// 其他玩家答复解散房间请求
		// messageType = 0x0b;
		// } else if (msg instanceof DdzProto.DisbandCheckPost) {//
		// 解散房间应答广播,是否解散成功
		// messageType = 0x0c;
		// } else if (msg instanceof DdzProto.SettlementInfo) {// 结算信息
		// messageType = 0x0d;
		// }

		// if (msg instanceof PokerProto.Poker) {
		// messageType = 0x00;
		// } else if (msg instanceof PlayerProto.Player) {
		// messageType = 0x01;
		// } else if (msg instanceof MessageProto.Message) {
		// messageType = 0x02;
		// }

		byte[] header = new byte[4];
		header[0] = (byte) (bodyLength & 0xff);
		header[1] = (byte) ((bodyLength >> 8) & 0xff);
		header[2] = 0; // 保留字段
		header[3] = messageType;

		return header;

	}
}
