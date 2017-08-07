package com.jie.dot;

import com.jie.ResConsts;

/**
 * @Description 基础返回模型
 * @author weishujie
 * @data 2017年8月3日下午7:20:38
 * @version
 */
public class BaseResultDto {
	private int status = ResConsts.Code.SUCCESS;
	private String info = ResConsts.Msg.SUCCESS_MSG;
	private int error = ResConsts.Code.ERROR;
	private Object date;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public Object getDate() {
		return date;
	}

	public void setDate(Object date) {
		this.date = date;
	}

	public BaseResultDto(int status, String info, int error) {
		super();
		this.status = status;
		this.info = info;
		this.error = error;
	}

	public BaseResultDto(int status, String info) {
		super();
		this.status = status;
		this.info = info;
	}

	public BaseResultDto() {
		super();
	}

}
