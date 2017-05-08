package com.rxqp.common.data;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.rxqp.common.constants.ExcMsgConstants;
import com.rxqp.common.exception.BusinnessException;
import com.rxqp.entity.bo.Player;
import com.rxqp.entity.bo.Room;


public class CommonData {

	// 房间号与房间里玩家映射关系
	// private static Map<Integer, List<Player>> roomidToPlayers = new
	// ConcurrentHashMap<Integer, List<Player>>();
	private static Map<Integer, Room> roomIdToRoomInfo = new ConcurrentHashMap<Integer, Room>();
	// 玩家ID与玩家对象映射
	private static Map<Integer, Player> playerIdToPlayer = new ConcurrentHashMap<Integer, Player>();

	// public static List<Player> getPlayersByRoomId(Integer roomId) {
	// return roomidToPlayers.get(roomId);
	// }

	// public static void putRoomidToPlayers(Integer roomId, List<Player>
	// players) {
	// roomidToPlayers.put(roomId, players);
	// }

	// public static void removeRoom(Integer roomId) {
	// roomidToPlayers.remove(roomId);
	// }

	public static Room getRoomByRoomId(Integer roomId) {
		return roomIdToRoomInfo.get(roomId);
	}

	public static List<Player> getPlayersByRoomId(Integer roomId)
			throws BusinnessException {
		Room room = roomIdToRoomInfo.get(roomId);
		if (room == null) {
			throw new BusinnessException(
					ExcMsgConstants.NO_EXISTS_THE_ROOM_EXC_CODE,
					ExcMsgConstants.NO_EXISTS_THE_ROOM_EXC_MSG);
		}
		return roomIdToRoomInfo.get(roomId).getPlayers();
	}

	public static void putPlayersIntoRoom(Integer roomId, List<Player> players)
			throws BusinnessException {
		Room room = roomIdToRoomInfo.get(roomId);
		if (room == null) {
			throw new BusinnessException(
					ExcMsgConstants.NO_EXISTS_THE_ROOM_EXC_CODE,
					ExcMsgConstants.NO_EXISTS_THE_ROOM_EXC_MSG);
		}
		room.setPlayers(players);
	}

	public static void removeRoom(Integer roomId) {
		roomIdToRoomInfo.remove(roomId);
	}

	public static Player getPlayerById(Integer playerId) {
		return playerIdToPlayer.get(playerId);
	}

	public static void putPlayerIdToPlayer(Integer playerId, Player player) {
		playerIdToPlayer.put(playerId, player);
	}

	public static void removePlayer(Integer playerId) {
		playerIdToPlayer.remove(playerId);
	}

	public static void putRoomIdToRoom(Integer roomId, Room room) {
		roomIdToRoomInfo.put(roomId, room);
	}

	/**
	 * 获取同一房间里所有玩家信息
	 * 
	 * @param playerId
	 * @return
	 * @throws BusinnessException
	 */
	public static List<Player> getPlayersByIdInSameRoom(Integer playerId)
			throws BusinnessException {
		Player player = playerIdToPlayer.get(playerId);
		if (player != null && player.getRoomId() != null) {
			Room room = roomIdToRoomInfo.get(player.getRoomId());
			if (room == null) {
				throw new BusinnessException(
						ExcMsgConstants.NO_EXISTS_THE_ROOM_EXC_CODE,
						ExcMsgConstants.NO_EXISTS_THE_ROOM_EXC_MSG);
			}
			return room.getPlayers();
		} else {
			return null;
		}
	}
}
