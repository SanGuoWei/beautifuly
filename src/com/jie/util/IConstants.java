package com.jie.util;

import com.jie.Parameters;

public interface IConstants {
	String PK = "id";

	String SESSION_USER_KEY = "user";

	String SESSION_USERID_KEY = "userID";

	String SESSION_USER_UUID = "UUID";

	String SESSION_ADMINID_KEY = "adminID";

	String SESSION_REMAIN_KEY = "jie";

	String DEFAULT_PASSWORD = "123456";

	String PAGE_NUM = "pageNum";

	String PAGE_SIZE = "pageSize";

	int HEAD_MOD = 74;

	int REPORT = 0;

	int FILE_LENGTH = 80;// 美图网一组图片的最大值

	String EMAIL = "810968656@qq.com";

	String AUTHOR = "三国魏";

	String DEFAULT_DOWNLOAD_FILEPATH = Parameters.DOWNLOAD_FILEPATH + "/file";// 默认文件的下载位置

	String PHOTO_DOWNLOAD_FILEPATH = Parameters.DOWNLOAD_FILEPATH + "/photo";// 图片下载位置

}
