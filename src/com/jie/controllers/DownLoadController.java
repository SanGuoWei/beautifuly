package com.jie.controllers;

import java.util.List;

import com.jfinal.kit.PathKit;
import com.jie.BaseController;
import com.jie.dot.BaseResultDto;
import com.jie.service.BeautyService;

/**
 * @Description	下载控制器
 * @author weishujie
 * @data 2017年8月7日下午7:29:59
 */
public class DownLoadController extends BaseController {

	private static final BeautyService beauty = new BeautyService();

	public void index() {
		render(new BaseResultDto(0, PathKit.getRootClassPath()));
	}

	public void login() {
	}

	public void loginIn() {
	}

	/**
	 * @Description	初始化表
	 * @auth weishujie
	 * @creattime 2017年8月7日下午7:31:23
	 */
	public void init() {// 3084
		beauty.init();
		render(new BaseResultDto());
	}

	public void downLoadFile() {// 3084
		List<String> strList = beauty.downLoadBeautyPhoto();
		BaseResultDto result = new BaseResultDto();
		result.setDate(strList);
		render(result);
	}

	public void downLoadPhoto() {// 3084
		int start = getParaToInt("start");
		int end = getParaToInt("end");
		List<String> strList = beauty.downLoadBeautyPhoto(start, end + 1, false);
		BaseResultDto result = new BaseResultDto();
		result.setDate(strList);
		render(result);
	}

}
