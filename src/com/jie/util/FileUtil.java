package com.jie.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description	文件工具类
 * @author weishujie
 * @data 2017年8月7日下午8:10:02
 */
public class FileUtil {

	/**
	 * @Description	判断一个文件路径的文件是否存在
	 * @auth weishujie
	 * @creattime 2017年8月7日下午8:12:08
	 * @param url 需要判断你的URL
	 * @return	true:存在 false:不存在
	 */
	public static boolean urlFileExists(String url) {
		try {
			URL fileUrl = new URL(url);
			fileUrl.openStream();// 获取文件输出流,报错文件则不存在
			return true;
		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * @Description	下载文件
	 * @auth weishujie
	 * @creattime 2017年8月8日下午2:23:59
	 * @param url	文件网络地址
	 * @param filePath	保存地址
	 * @return
	 */
	public static boolean downFileFile(String url, String filePath) {
		File file = new File(filePath);
		try {
			URL fileUrl = new URL(url);
			InputStream is = fileUrl.openStream();// 获取文件输出流,报错文件则不存在
			byte[] bs = new byte[1024];// 1K的数据缓冲流
			int len = 0;
			OutputStream os = new FileOutputStream(file);
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			os.close();
			is.close();
			return true;
		} catch (MalformedURLException e) {
			if (file.exists()) {
				file.delete();// 删除文件
			}
			return false;
		} catch (IOException e) {
			if (file.exists()) {
				file.delete();// 删除文件
			}
			return false;
		}
	}
}
