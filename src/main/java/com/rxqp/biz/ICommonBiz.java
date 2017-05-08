package com.rxqp.biz;

import java.util.List;

import com.rxqp.protobuf.DdzProto.MessageInfo;

public interface ICommonBiz {

	public MessageInfo.Builder setMessageInfo(Integer msgType, String message);

	/**
	 * 交互list 索引a，b的值
	 * 
	 * @param lst
	 * @param a
	 * @param b
	 */
	public void swapLst(List<Integer> lst, Integer a, Integer b);
}
