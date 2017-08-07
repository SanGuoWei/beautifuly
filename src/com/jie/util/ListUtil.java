package com.jie.util;

import java.util.List;

public class ListUtil {

	/**
	 * @Description List是否为Null和Empty
	 * @auth weishujie
	 * @creattime 2017年8月3日下午4:45:29
	 * @param list
	 * @return true:是null和empty
	 */
	public static <E> boolean isNullOrEmpty(List<E> list) {
		if (list == null) {
			return true;
		}
		if (list.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * @Description
	 * @auth weishujie
	 * @creattime 2017年8月3日下午4:45:56
	 * @param list
	 * @return
	 */
	public static <E> boolean isNotNullOrEmpty(List<E> list) {
		return !isNullOrEmpty(list);
	}
}
