/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013-2014 sagyf Yang. The Four Group.
 */

package com.jie.util;

import java.util.UUID;

public class Kits {
	public static Number convertNumber(Number num) {
		Number newNumber = 0;
		if (num == null) {
			return newNumber;
		} else {
			return num;
		}
	}

	/**
	 * String NULL判断
	 */
	public static String convertString(String str) {
		String newStr = "";
		if (StringUtil.isNull(str)) {
			return newStr;
		} else {
			return str;
		}
	}

	/**
	 * Long NULL判断
	 */
	public static Long convertLong(Long lon) {
		Long newLon = 0L;
		if (lon == null) {
			return newLon;
		} else {
			return lon;
		}
	}

	/**
	 * @Description 获取UUID
	 * @auth weishujie
	 * @creattime 2017年8月3日下午5:52:38
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
