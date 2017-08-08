package com.jie.util;

import com.jfinal.plugin.activerecord.Db;

public class ThreadUtil {
	private String sql;
	private Object[][] paras;
	private int size;

	public ThreadUtil(String sql, Object[][] paras, int size) {
		this.sql = sql;
		this.paras = paras;
		this.size = size;
	}

	/**
	 * @Description
	 * @auth weishujie
	 * @creattime 2017年8月8日上午9:35:52
	 * @return
	 */
	public Runnable creatBeathSave() {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				Db.batch(sql, paras, size);
			}
		};
		return runnable;

	}
}
