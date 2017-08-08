package com.jie.controllers;

import com.jie.BaseController;

public class MainController extends BaseController {
	/**
	 * @Description 跳转到index页面
	 * @auth weishujie
	 * @creattime 2017年8月4日下午5:32:33
	 */
	public void index() {
		redirect("/front/index.jsp");
	}
}
