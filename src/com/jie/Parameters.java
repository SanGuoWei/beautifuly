package com.jie;

import java.io.File;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

/**
 * 
 * 相关的配置信息放在一个配置文件里，通过类Parameters来统一访问。
 * Parameters里通过java.util.Properties读取配置文件，然后通过 {@link #getParameter(String)}
 * 来获得配置信息。系统的各个全局 变量也都放在这个类里面，静态共享。
 * 
 * @Description
 * @author weishujie
 * @data 2017年8月3日下午3:28:36
 * @version
 * 
 */
public class Parameters {
	// 私有构造方法
	private Parameters() {
	}

	/**
	 * 配置文件路径
	 */
	public static String CONFIG_PATH = PathKit.getRootClassPath() + File.separator + "jdbc.properties";

	private static Prop pro;

	/**
	 * 浏览分页数据时每页大小
	 */
	public static final int DEFAULT_PAGE_SIZE = 10;

	/**
	 * 读取配置文件
	 */
	public static Prop getPro() {
		if (pro == null) {
			pro = PropKit.use(new File(CONFIG_PATH));
		}
		return pro;
	}

	public static String DRIVER = getPro().get("driver", "com.mysql.jdbc.Driver").trim();

	public static String URL = getPro().get("jdbcUrl", "").trim();

	public static String USER = getPro().get("user", "root").trim();

	public static String PASSWORD = getPro().get("password", "123456").trim();

	public static boolean DEVMODE = getPro().getBoolean("devMode", false);

	public static String DOWNLOAD_FILEPATH = getPro().get("DownLoadFilePath");// 文件下载路径

}
