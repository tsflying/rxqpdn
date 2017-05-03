package com.rxqp.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.rxqp.biz.ICoreBiz;
import com.rxqp.biz.impl.CoreBizImpl;
import com.rxqp.protobuf.DdzProto;

public class DnServerHandler extends ChannelInboundHandlerAdapter {

	// 牌桌ID与该牌桌玩家通道集合的映射
	// private static Map<Integer, ChannelGroup> groupIdToChannels = new
	// ConcurrentHashMap<Integer, ChannelGroup>();
	// 客户端通道ID与该客户端玩家所在牌桌ID的映射
	// private static Map<Integer, Integer> channelIdToGroupId = new
	// ConcurrentHashMap<Integer, Integer>();

	private ICoreBiz ICoreBiz = new CoreBizImpl();

	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		DdzProto.MessageInfo req = (DdzProto.MessageInfo) msg;
		System.out.println("=====req:" + req.toString());
		try {
			DdzProto.MessageInfo mi = ICoreBiz.process(req, ctx);
			if (mi != null)
				ctx.writeAndFlush(mi);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// private SubscribeResqProto.SubscribeResq resp(int subReqID) {
	// SubscribeResqProto.SubscribeResq.Builder builder =
	// SubscribeResqProto.SubscribeResq
	// .newBuilder();
	// builder.setSubReqID(subReqID);
	// builder.setRespCode(0);
	// builder.setDesc("Netty book order success..");
	// return builder.build();
	// }
	//
	// @Override
	// public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
	// throws Exception {
	// // Channel channel = ctx.channel();
	// // removeChannel(channel);
	// // cause.printStackTrace();
	// }
	//
	// /**
	// * 删除相应的通道
	// *
	// * @param channel
	// */
	// private void removeChannel(Channel channel) {
	// // 获取该玩家所在牌桌ID
	// Integer groupId = channelIdToGroupId.get(channel.hashCode());
	// if (groupId != null) {
	// ChannelGroup channelGroup = groupIdToChannels.get(groupId);
	// if (channelGroup != null) {
	// channelGroup.remove(channel);
	// try {
	// Group group = groupBiz.getGroupById(groupId);
	// List<Player> players = group.getPlayers();
	// Iterator<Player> itr = players.iterator();
	// Player player = null;
	// while (itr.hasNext()) {
	// Player p = itr.next();
	// if (p.getChannel().hashCode() == channel.hashCode()) {
	// player = p;
	// itr.remove();
	// groupBiz.addFreeGroupIds(groupId);// 有玩家退出，则将房间号加入空闲房间号集中
	// break;
	// }
	// }
	// if (player != null) {
	// String message = player.getName() + "退出游戏!";
	// channelGroup.writeAndFlush(setMessage(
	// MessageConstants.PLAYER_QUIT_STATUS_TYPE,
	// message));
	// }
	// } catch (BusinnessException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }
	// channelIdToGroupId.remove(channel.hashCode());
	// }
	//
	// public void channelActive(ChannelHandlerContext ctx) {
	// System.out.println(ctx);
	// // try {
	// // Player player = loginBiz.authenticate();
	// // player.setChannel(ctx.channel());
	// // Integer groupId = groupBiz.entryGroup(player);
	// // Group group = groupBiz.getGroupById(groupId);
	// // channelIdToGroupId.put(ctx.channel().hashCode(), groupId);
	// // ChannelGroup channelGroup = groupIdToChannels.get(groupId);
	// // if (channelGroup == null) {
	// // channelGroup = new DefaultChannelGroup(
	// // GlobalEventExecutor.INSTANCE);
	// // groupIdToChannels.put(groupId, channelGroup);
	// // }
	// // channelGroup.add(ctx.channel());
	// // if (group.getPlayers().size() == 3) {// 该牌桌人数已满，可以开始玩牌
	// // String resContent = "玩家：" + player.getName() + "加入" + groupId
	// // + "号房间。" + MessageConstants.PLAYER_READY_STATUS_MSG;
	// // channelGroup.writeAndFlush(setMessage(
	// // MessageConstants.PLAYER_READY_STATUS_TYPE, resContent));
	// // List<Player> players = group.getPlayers();
	// // for (Player p : players) {
	// // Channel ch = p.getChannel();
	// // resContent = p.getName() + "正在" + p.getGroupId()
	// // + "号房间中玩牌!";
	// // ch.writeAndFlush(setMessage(
	// // MessageConstants.PLAYER_PLAYING_TYPE, resContent));
	// // }
	// // } else {// 否则玩家继续等待
	// // String resContent = "玩家：" + player.getName() + "加入" + groupId
	// // + "号房间。"
	// // + MessageConstants.PLAYER_WAITER_FOR_STATUS_MSG;
	// // channelGroup.writeAndFlush(setMessage(
	// // MessageConstants.PLAYER_WAITER_FOR_STATUS_TYPE,
	// // resContent));
	// // }
	// // } catch (BusinnessException e) {
	// // if (e.getCode().equals(ExcMsgConstants.ENTRY_GROUP_EXC_CODE)) {//
	// // 进入的房间已满，请再试其他房间
	// //
	// // }
	// // }
	// }
	//
	// private MessageProto.Message setMessage(Integer msgType, String content)
	// {
	// MessageProto.Message.Builder builder = MessageProto.Message
	// .newBuilder();
	// builder.setType(msgType);
	// builder.setContent(content);
	// return builder.build();
	// }
}
