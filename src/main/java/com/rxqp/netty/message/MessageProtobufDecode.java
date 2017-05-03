package com.rxqp.netty.message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import com.google.protobuf.MessageLite;
import com.rxqp.protobuf.DdzProto;

/**
 * 参考ProtobufVarint32FrameDecoder 和 ProtobufDecoder
 */
public class MessageProtobufDecode extends ByteToMessageDecoder {
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		while (in.readableBytes() > 4) { // 如果可读长度小于包头长度，退出。
			in.markReaderIndex();

			// 获取包头中的body长度
			byte low = in.readByte();
			byte high = in.readByte();
			short s0 = (short) (low & 0xff);
			short s1 = (short) (high & 0xff);
			s1 <<= 8;
			short length = (short) (s0 | s1);

			// 获取包头中的protobuf类型
			in.readByte();
			byte dataType = in.readByte();

			// 如果可读长度小于body长度，恢复读指针，退出。
			if (in.readableBytes() < length) {
				in.resetReaderIndex();
				return;
			}

			// 读取body
			ByteBuf bodyByteBuf = in.readBytes(length);

			byte[] array;
			int offset;

			int readableLen = bodyByteBuf.readableBytes();
			if (bodyByteBuf.hasArray()) {
				array = bodyByteBuf.array();
				offset = bodyByteBuf.arrayOffset() + bodyByteBuf.readerIndex();
			} else {
				array = new byte[readableLen];
				bodyByteBuf.getBytes(bodyByteBuf.readerIndex(), array, 0,
						readableLen);
				offset = 0;
			}

			// 反序列化
			MessageLite result = decodeBody(dataType, array, offset,
					readableLen);
			out.add(result);
		}
	}

	public MessageLite decodeBody(byte dataType, byte[] array, int offset,
			int length) throws Exception {
		return DdzProto.MessageInfo.getDefaultInstance().getParserForType()
				.parseFrom(array, offset, length);
		// if (dataType == 0x14) {// 出牌请求
		// return DdzProto.DiscardReq.getDefaultInstance().getParserForType()
		// .parseFrom(array, offset, length);
		// } else if (dataType == 0x15) {// 出牌返回广播
		// return DdzProto.DiscardPost.getDefaultInstance().getParserForType()
		// .parseFrom(array, offset, length);
		// } else if (dataType == 0x01) {// 登录请求
		// return DdzProto.LoginReq.getDefaultInstance().getParserForType()
		// .parseFrom(array, offset, length);
		// } else if (dataType == 0x02) {// 登录返回
		// return DdzProto.LoginResp.getDefaultInstance().getParserForType()
		// .parseFrom(array, offset, length);
		// } else if (dataType == 0x03) {// 创建房间请求
		// return DdzProto.CreateRoomReq.getDefaultInstance()
		// .getParserForType().parseFrom(array, offset, length);
		// } else if (dataType == 0x04) {// 创建房间返回
		// return DdzProto.CreateRoomResp.getDefaultInstance()
		// .getParserForType().parseFrom(array, offset, length);
		// } else if (dataType == 0x05) {// 进入特定房间请求
		// return DdzProto.EntryRoomReq.getDefaultInstance()
		// .getParserForType().parseFrom(array, offset, length);
		// } else if (dataType == 0x06) {// 进入房间返回
		// return DdzProto.EntryRoomResp.getDefaultInstance()
		// .getParserForType().parseFrom(array, offset, length);
		// } else if (dataType == 0x07) {// 广播进入房间，开始玩游戏
		// return DdzProto.PostEntryRoom.getDefaultInstance()
		// .getParserForType().parseFrom(array, offset, length);
		// } else if (dataType == 0x08) {// 玩家当前信息
		// return DdzProto.Player.getDefaultInstance().getParserForType()
		// .parseFrom(array, offset, length);
		// } else if (dataType == 0x09) {// 玩家请求解散房间
		// return DdzProto.DisbandReq.getDefaultInstance().getParserForType()
		// .parseFrom(array, offset, length);
		// } else if (dataType == 0x10) {// 广播其他玩家解散房间
		// return DdzProto.DisbandPost.getDefaultInstance().getParserForType()
		// .parseFrom(array, offset, length);
		// } else if (dataType == 0x11) {// 其他玩家答复解散房间请求
		// return DdzProto.DisbandCheckReq.getDefaultInstance()
		// .getParserForType().parseFrom(array, offset, length);
		// } else if (dataType == 0x12) {// 解散房间应答广播,是否解散成功
		// return DdzProto.DisbandCheckPost.getDefaultInstance()
		// .getParserForType().parseFrom(array, offset, length);
		// } else if (dataType == 0x13) {// 结算信息
		// return DdzProto.SettlementInfo.getDefaultInstance()
		// .getParserForType().parseFrom(array, offset, length);
		// }

		// if (dataType == 0x00) {
		// return PokerProto.Poker.getDefaultInstance().getParserForType()
		// .parseFrom(array, offset, length);
		//
		// } else if (dataType == 0x01) {
		// return PlayerProto.Player.getDefaultInstance().getParserForType()
		// .parseFrom(array, offset, length);
		// } else if (dataType == 0x02) {
		// return MessageProto.Message.getDefaultInstance().getParserForType()
		// .parseFrom(array, offset, length);
		// }

		// return null; // or throw exception
	}
}
