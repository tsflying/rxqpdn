package com.rxqp.common.constants;

public class MessageConstants {

	public static Integer PLAYER_WAITER_FOR_STATUS_TYPE = 0;
	public static String PLAYER_WAITER_FOR_STATUS_MSG = "等待其他玩家!";

	public static Integer PLAYER_READY_STATUS_TYPE = 1;
	public static String PLAYER_READY_STATUS_MSG = "开始玩牌!";

	public static Integer PLAYER_PLAYING_TYPE = 2;
	public static String PLAYER_PLAYING_MSG = "玩牌中!";

	public static Integer PLAYER_QUIT_STATUS_TYPE = 3;
	public static String PLAYER_QUIT_STATUS_MSG = "退出!";

	public static Integer UNKNOWN_CAUSE_TYPE = 1000;
	public static String UNKNOWN_CAUSE_MSG = "未知内部原因异常!";

	public static Integer PLAYER_NO_LOGIN_TYPE_1001 = 1001;
	public static String PLAYER_NO_LOGIN_MSG_1001 = "玩家没有登录!";

	public static Integer PLAYER_STATE_TYPE_1002 = 1002;
	public static String PLAYER_STATE_MSG_1002 = "玩家正在游戏中!";

	public static Integer LOGIN_ERROR_TYPE_1003 = 1003;
	public static String LOGIN_ERROR_MSG_1003 = "登录失败!";

	public static Integer PLAYER_STATE_TYPE_1004 = 1004;
	public static String PLAYER_STATE_MSG_1004 = "玩家已经登录!";

	public static Integer CREATE_ROOM_ERROR_TYPE = 3001;
	public static String CREATE_ROOM_ERROR_MSG = "创建房间失败!";

	public static Integer ENTRY_ROOM_ERROR_TYPE_4000 = 4000;
	public static String ENTRY_ROOM_ERROR_MSG_4000 = "房间没有人创建!";

	public static Integer ENTRY_ROOM_ERROR_TYPE_4001 = 4001;
	public static String ENTRY_ROOM_ERROR_MSG_4001 = "房间人数已满!";

	public static Integer THE_ROOM_NO_EXTIST_ERROR_TYPE = 4002;
	public static String THE_ROOM_NO_EXTIST_ERROR_MSG = "该房间不存在!";

	public static Integer THE_ROOM_NO_EXTIST_PLAYER_TYPE = 4003;
	public static String THE_ROOM_NO_EXTIST_PLAYER_MSG = "该房间不存在玩家";

	public static Integer REMAINDER_POKER_NUM_ERROR_TYPE = 5001;
	public static String REMAINDER_POKER_NUM_ERROR_MSG = "剩余底牌不是三，内部异常！";

	public static Integer DISCARD_TYPE_NO_SAME_TYPE = 6001;
	public static String DISCARD_TYPE_NO_SAME_MSG = "出牌类型不一样！";

	public static Integer DISCARD_CARDS_IS_NONE_TYPE = 6002;
	public static String DISCARD_CARDS_IS_NONE_MSG = "出牌为空！";

	public static Integer DISCARD_CARDS_ISNOT_ONE_TYPE = 6003;
	public static String DISCARD_CARDS_ISNOT_ONE_MSG = "当前玩家出牌不止一张，跟传递的出牌类型不匹配!";

	public static Integer DISCARD_NUM_GREATER_REMAIINDER_NUM_TYPE = 6004;
	public static String DISCARD_NUM_GREATER_REMAIINDER_NUM_MSG = "出的牌张数大于剩余的牌张数!";

	public static Integer DISCARD_POINT_ISNOT_GREATER_TYPE = 6005;
	public static String DISCARD_POINT_ISNOT_GREATER_MSG = "出牌的点数没上一家大!";

	public static Integer DISCARD_CARDS_ISNOT_DOUBLE_TYPE = 6006;
	public static String DISCARD_CARDS_ISNOT_DOUBLE_MSG = "当前玩家出牌不是对子，跟传递的出牌类型不匹配!";

	public static Integer DISCARD_CARDS_ISNOT_DOUBLE_STRAIGHT_TYPE = 6007;
	public static String DISCARD_CARDS_ISNOT_DOUBLE_STRAIGHT_MSG = "当前玩家出牌不是双顺子，跟传递的出牌类型不匹配!";

	public static Integer DISCARD_CARDS_ISNOT_EQUAL_PREPLAYER_TYPE = 6008;
	public static String DISCARD_CARDS_ISNOT_EQUAL_PREPLAYER_MSG = "当前玩家出牌张数跟上一家出牌张数不一致!";

	public static Integer DISCARD_CARDS_ISNOT_TRIPLE_STRAIGHT_TYPE = 6009;
	public static String DISCARD_CARDS_ISNOT_TRIPLE_STRAIGHT_MSG = "当前玩家出牌不是飞机顺子，跟传递的出牌类型不匹配!";

	public static Integer DISCARD_CARDS_ISNOT_SINGLE_STRAIGHT_TYPE = 6010;
	public static String DISCARD_CARDS_ISNOT_SINGLE_STRAIGHT_MSG = "当前玩家出牌不是单张顺子，跟传递的出牌类型不匹配!";

	public static Integer DISCARD_CARDS_ISNOT_TRIPLE_TYPE = 6011;
	public static String DISCARD_CARDS_ISNOT_TRIPLE_MSG = "当前玩家出牌不是三张不带的牌，跟传递的出牌类型不匹配!";

	public static Integer DISCARD_CARDS_ISNOT_THREE_AND_ONE_TYPE = 6012;
	public static String DISCARD_CARDS_ISNOT_THREE_AND_ONE_MSG = "当前玩家出牌不是三带一，跟传递的出牌类型不匹配!";

	public static Integer DISCARD_CARDS_ISNOT_THREE_AND_TWO_TYPE = 6013;
	public static String DISCARD_CARDS_ISNOT_THREE_AND_TWO_MSG = "当前玩家出牌不是三带二，跟传递的出牌类型不匹配!";

	public static Integer DISCARD_CARDS_ISNOT_FOUR_AND_ONE_TYPE = 6014;
	public static String DISCARD_CARDS_ISNOT_FOUR_AND_ONE_MSG = "当前玩家出牌不是四带一，跟传递的出牌类型不匹配!";

	public static Integer DISCARD_CARDS_ISNOT_FOUR_BOOM_TYPE = 6015;
	public static String DISCARD_CARDS_ISNOT_FOUR_BOOM_MSG = "当前玩家出牌不是四张牌的炸弹，跟传递的出牌类型不匹配!";

	public static Integer DISCARD_CARDS_BOOM_ISNOT_GREATER_PREPLAYER_TYPE = 6016;
	public static String DISCARD_CARDS_BOOM_ISNOT_GREATER_PREPLAYER_MSG = "当前玩家出的炸弹没有上一家大!";

	public static Integer DISCARD_CARDS_ISNOT_JOKER_BOOM_TYPE = 6016;
	public static String DISCARD_CARDS_ISNOT_JOKER_BOOM_MSG = "当前玩家出牌不是双王炸弹，跟传递的出牌类型不匹配!";

}
