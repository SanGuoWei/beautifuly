package com.jie.controllers;

import com.jie.BaseController;
import com.jie.ResConsts;
import com.jie.dot.BaseResultDto;
import com.jie.service.UserService;
import com.jie.util.IConstants;

public class DownLoadController extends BaseController {
	private static final UserService userService = new UserService();

	public void index() {
		// setAttr("user", );
		// render("user.jsp");
	}

	public void login() {
		setAttr("name", "JIE");
		redirect("/front/login.jsp");
	}

	public void loginIn() {
		String userName = getPara("username");
		String passWord = getPara("password");
		BaseResultDto result = userService.login(userName, passWord);
		if (result.getStatus() == ResConsts.Code.SUCCESS) {// 用户名密码正确
			setSessionAttr(IConstants.SESSION_USER_KEY, result.getDate());// 登陆成功,把用户信息放入session域中
			render(result);
		} else {
			removeSessionAttr(IConstants.SESSION_USER_KEY);
			render(result);
		}
	}
}
