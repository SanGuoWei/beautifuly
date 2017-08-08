package com.jie.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.jfinal.plugin.activerecord.Db;
import com.jie.util.FileUtil;
import com.jie.util.IConstants;
import com.jie.util.ThreadUtil;

/**
 * @Description	获取图片的URL
 * @author weishujie
 * @data 2017年8月7日下午8:19:36
 */
public class BeautyService {

	public void init() {// 3084
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(20, 50, 1000L, TimeUnit.SECONDS, workQueue);// 定义线程池
		// 从2000开始
		long start = System.currentTimeMillis();
		for (int i = 2000; i < 2050; i++) {
			StringBuffer urlBuffer = new StringBuffer("http://img1.mm131.com/pic/").append(i).append("/");
			List<Object[]> values = new ArrayList<Object[]>();
			for (int j = 0; j < IConstants.FILE_LENGTH; j++) {
				StringBuffer newUrl = new StringBuffer(urlBuffer.toString()).append(j).append(".jpg");
				Object[] par = new Object[4];
				par[0] = newUrl.toString();
				par[1] = par[2] = System.currentTimeMillis();
				par[3] = i;
				if (FileUtil.urlFileExists(newUrl.toString())) {
					values.add(par);
				} else {
					break;
				}
			}
			Object[][] paras = new Object[values.size()][4];
			for (int j = 0; j < paras.length; j++) {
				paras[j] = values.get(j);

			}
			String insertSql = "insert into beauty(url,create_time,update_time,directory) values(?,?,?,?)";
			Runnable runnable = new ThreadUtil(insertSql, paras, values.size()).creatBeathSave();
			threadPool.execute(runnable);// 执行线程
			paras = null;// 数组指针置为空
			values.clear();// 清空数组
		}
		threadPool.shutdown();// 关闭线程池
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public List<String> downLoadBeautyPhoto() {
		String queryLastDirectory = "SELECT b.`directory` FROM beauty b ORDER BY id DESC LIMIT 1";// 查询最后的文件夹
		String directory = Db.queryStr(queryLastDirectory);// 最后的文件夹
		int startDirectory = Integer.parseInt(directory) + 1;// 开始下载的文件夹
		int endDirectory = Integer.parseInt(directory) + 3;// 结束下载的文件夹
		return downLoadBeautyPhoto(startDirectory, endDirectory, true);
	}

	public List<String> downLoadBeautyPhoto(int startDirectory, int endDirectory, boolean saveData) {
		List<String> strList = new ArrayList<String>();
		for (int i = startDirectory; i < endDirectory; i++) {// 下载后三个
			File dir = new File(IConstants.PHOTO_DOWNLOAD_FILEPATH + "/" + i);
			dir.mkdir();// 创建文件夹
			StringBuffer urlBuffer = new StringBuffer("http://img1.mm131.com/pic/").append(i).append("/");
			StringBuffer fileBuffer = new StringBuffer(IConstants.PHOTO_DOWNLOAD_FILEPATH).append("/").append(i)
					.append("/");
			List<Object[]> values = new ArrayList<Object[]>();
			for (int j = 1; j < IConstants.FILE_LENGTH; j++) {
				StringBuffer newUrl = new StringBuffer(urlBuffer.toString()).append(j).append(".jpg");// 最终网络文件路径
				StringBuffer newFile = new StringBuffer(fileBuffer.toString()).append(j).append(".jpg");// 最终的文件路径
				Object[] par = new Object[4];
				par[0] = newUrl.toString();
				par[1] = par[2] = System.currentTimeMillis();
				par[3] = i;
				if (FileUtil.downFileFile(newUrl.toString(), newFile.toString())) {
					values.add(par);
					strList.add(newUrl.toString());
				} else {
					break;
				}
			}
			Object[][] paras = new Object[values.size()][4];
			for (int j = 0; j < paras.length; j++) {
				paras[j] = values.get(j);
			}
			if (saveData) {
				String insertSql = "insert into beauty(url,create_time,update_time,directory) values(?,?,?,?)";
				Db.batch(insertSql, paras, values.size());// 下载完保存数据
			}
		}
		return strList;
	}

}
