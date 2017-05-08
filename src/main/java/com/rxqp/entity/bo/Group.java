package com.rxqp.entity.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.util.CollectionUtils;


/**
 * 
 * @author tsflying
 * 
 */
public class Group implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4335448436797066512L;

	private Integer groupId;
	// 玩家列表
	private List<Player> players = new LinkedList<Player>();

	// 创建时间
	private Date createdTime;

	// 开始玩牌时间
	private Date startTime;

	public Group(Integer groupId, Date createTime) {
		this.groupId = groupId;
		this.createdTime = createTime;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean isBeReady() {
		if (!CollectionUtils.isEmpty(players) && players.size() == 3) {
			return true;
		} else {
			return false;
		}
	}

}
