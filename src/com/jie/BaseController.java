package com.jie;

import com.jfinal.core.Controller;
import com.jie.dot.BaseResultDto;

/**
 * @Description 基础的控制器
 * @author weishujie
 * @data 2017年8月3日下午4:40:09
 * @version
 */
public class BaseController extends Controller {
	private int status;
	private String info;
	private int error;
	private Object date;

	private void setResult(BaseResultDto resule) {
		this.status = resule.getStatus();
		this.info = resule.getInfo();
		this.error = resule.getError();
		this.date = resule.getDate();
	}

	private void setDataAttr() {
		setAttr(ResConsts.KEY_DATA, date);
		setAttr(ResConsts.KEY_STATUS, status);
		setAttr(ResConsts.KEY_ERROR, error);
		setAttr(ResConsts.KEY_MSG, info);
	}

	protected void render(BaseResultDto resule) {
		setResult(resule);
		// 渲染JSON数据
		setDataAttr();
		renderJson();
	}

	protected void render(Object data) {
		this.date = data;
		// 渲染JSON数据
		setDataAttr();
		renderJson();
	}

	protected void render(int status, Object data) {
		this.status = status;
		this.date = data;
		// 渲染JSON数据
		setDataAttr();
		renderJson();
	}

	protected void render(int status, String info) {
		this.status = status;
		this.info = info;
		// 渲染JSON数据
		setDataAttr();
		renderJson();
	}

	protected void render(int status, int error, String info) {
		this.status = status;
		this.error = error;
		this.info = info;
		// 渲染JSON数据
		setDataAttr();
		renderJson();
	}

}
