package com.rxqp.enums;

public enum PokersTypeEnum {
	// 未知类型
	None(0),
	// 王炸
	JokerBoom(1),
	//
	Boom(2),
	// 四带二单
	FourAndTwoSingle(3),
	// 四带二对
	FourAndTwoDouble(4),
	// 三个不带
	OnlyThree(5),
	// 三个带一
	ThreeAndOne(6),
	// 三个带二
	ThreeAndTwo(7),
	// 顺子 五张或更多的连续单牌
	Straight(8),
	// 双顺 三对或更多的连续对牌
	DoubleStraight(9),
	// 飞机 三顺 二个或更多的连续三张牌
	TripleStraight(10),
	// 对子
	Double(11),
	// 单个
	Single(12);

	private Integer value;

	private PokersTypeEnum(int value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public static PokersTypeEnum getPokersTypeEnumByValue(Integer value) {
		for (PokersTypeEnum pt : PokersTypeEnum.values()) {
			if (pt.getValue().equals(value)) {
				return pt;
			}
		}
		return null;
	}
}
