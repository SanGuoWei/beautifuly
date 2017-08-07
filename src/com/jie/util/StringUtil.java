package com.jie.util;

public class StringUtil {
	/**
	 * @Description 是null或空字符都为true
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		if (str == null) {
			return true;
		}
		if (str.trim().length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Description 有一个为空即为true
	 * @return
	 */
	public static boolean isNull(String str, String string) {
		return isNull(string) || isNull(str);
	}

	public static boolean isNull(String str, String... strings) {
		if (strings == null || isNull(str)) {
			return true;
		}
		for (String string : strings) {
			if (isNull(string)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @Description
	 * @return
	 */
	public static boolean isNotNull(String str) {
		return !isNull(str);
	}

	public static boolean isNotNull(String str, String string) {
		return !isNull(str, string);
	}

	public static boolean isNotNull(String str, String... strings) {
		return !isNull(str, strings);
	}

}
