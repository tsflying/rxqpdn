package com.rxqp.entity.bo;

import io.netty.channel.Channel;

import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.rxqp.protobuf.DdzProto;

public class Player implements Serializable {

	private static final long serialVersionUID = 5732930012273200036L;

	private Integer id;
	private String name;
	private List<DdzProto.Poker> pokers = new ArrayList<DdzProto.Poker>();
	private Socket socket;
	private Boolean island = false;// 是否登录
	private Boolean onPlay = false;// 是否正在玩牌中
	private Integer groupId;
	private String openId;// 微信公众号的普通用户的一个唯一的标识
	private Channel channel;
	private Integer roomId;
	private String imgUrl = "";
	private Integer score = 0;// 本局得分
	private Integer finalScore = 0;// 最终得分
	private Boolean isDz = true;// 当前是否地主
	private Integer grabHostType = -1;// // type:0--不抢 1--抢地主1分 2--抢地主2分//
										// 3--抢地主3分
	private Integer order;// 座位顺序
	private Integer nextPlayerId;// 按照座位顺序下家玩家ID
	private boolean isRoomOwner = false;//是否是房主，创建房间的玩家

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DdzProto.Poker> getPokers() {
		return pokers;
	}

	public void setPokers(List<DdzProto.Poker> pokers) {
		this.pokers = pokers;
	}

	public Boolean getIsland() {
		return island;
	}

	public void setIsland(Boolean island) {
		this.island = island;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Player(int id, String name, boolean island) {
		super();
		this.id = id;
		this.name = name;
		this.island = island;
	}

	public Player(int id, String name, Socket socket, Channel channel,
			boolean island) {
		super();
		this.id = id;
		this.name = name;
		this.socket = socket;
		this.island = island;
	}

	public Player() {
		super();
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", pokers=" + pokers
				+ ", island=" + island + "]";
	}

	public Boolean getOnPlay() {
		return onPlay;
	}

	public void setOnPlay(Boolean onPlay) {
		this.onPlay = onPlay;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(Integer finalScore) {
		this.finalScore = finalScore;
	}

	public Boolean getIsDz() {
		return isDz;
	}

	public void setIsDz(Boolean isDz) {
		this.isDz = isDz;
	}

	public Integer getGrabHostType() {
		return grabHostType;
	}

	public void setGrabHostType(Integer grabHostType) {
		this.grabHostType = grabHostType;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getNextPlayerId() {
		return nextPlayerId;
	}

	public void setNextPlayerId(Integer nextPlayerId) {
		this.nextPlayerId = nextPlayerId;
	}
	
	public boolean isRoomOwner() {
		return isRoomOwner;
	}

	public void setRoomOwner(boolean isRoomOwner) {
		this.isRoomOwner = isRoomOwner;
	}

	public boolean equals(Player player) {
		if (this.id.equals(player.getId())
				&& this.name.equals(player.getName())
				&& this.groupId.equals(player.getGroupId())) {
			return true;
		} else {
			return false;
		}
	}
}
