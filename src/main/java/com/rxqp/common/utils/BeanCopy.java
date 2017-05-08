package com.rxqp.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.rxqp.entity.bo.Player;
import com.rxqp.protobuf.DdzProto;


public class BeanCopy {

	public static List<DdzProto.Player> playersCopy(List<Player> src) {

		List<DdzProto.Player> des = new ArrayList<DdzProto.Player>(src.size());

		for (Player player : src) {
			if (player.getId() == null || StringUtils.isEmpty(player.getName()))
				continue;
			DdzProto.Player.Builder py = DdzProto.Player.newBuilder();
			py.setID(player.getId());
			py.setName(player.getName());
			py.setImgUrl(player.getImgUrl());
			py.setScore(player.getScore());
			py.setIsDz(player.getIsDz());
			py.setOrder(player.getOrder());
			des.add(py.build());
		}
		return des;
	}

	public static DdzProto.Player playerCopy(Player player) {
		if (player == null) {
			return null;
		}
		DdzProto.Player.Builder py = DdzProto.Player.newBuilder();
		py.setID(player.getId());
		py.setName(player.getName());
		py.setImgUrl(player.getImgUrl());
		py.setScore(player.getScore());
		py.setIsDz(player.getIsDz());
		py.setOrder(player.getOrder());
		return py.build();
	}

	// public static List<DdzProto.Poker> pokersCopy(List<Poker> src) {
	// List<DdzProto.Poker> des = new ArrayList<DdzProto.Poker>(src.size());
	//
	// for (Poker poker : src) {
	// DdzProto.Poker.Builder pk = DdzProto.Poker.newBuilder();
	// pk.setID(poker.getId());
	// pk.setIsOut(poker.isOut());
	// des.add(pk.build());
	// }
	//
	// return des;
	// }

	// public static DdzProto.Poker pokerCopy(Poker poker) {
	// if (poker == null) {
	// return null;
	// }
	// DdzProto.Poker.Builder pk = DdzProto.Poker.newBuilder();
	// pk.setID(poker.getId());
	// pk.setIsOut(poker.isOut());
	// return pk.build();
	// }
}
