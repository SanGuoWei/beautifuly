package com.jie.controllers;

import com.jie.BaseController;
import com.jie.ResConsts;
import com.jie.dot.BaseResultDto;
import com.jie.service.UserService;
import com.jie.util.IConstants;
import com.jie.util.StringUtil;

/**
 * @Description
 * @author weishujie
 * @data 2017年8月7日下午2:08:26
 */
public class UserController extends BaseController {
	private static final UserService userService = new UserService();

	public void index() {
		// setAttr("user", );
		// render("user.jsp");
	}

	public void login() {
		redirect("/front/login.jsp");
	}

	/**
	 * @Description 登陆
	 * @auth weishujie
	 * @creattime 2017年8月7日下午2:08:30
	 */
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

	/**
	 * @Description 登出
	 * @auth weishujie
	 * @creattime 2017年8月7日下午2:08:46
	 */
	public void loginOut() {
		removeSessionAttr(IConstants.SESSION_USER_KEY);
		forwardAction("/user/login");// 跳转到登陆页
	}

	/**
	 * @Description 注册
	 * @auth weishujie
	 * @creattime 2017年8月3日下午5:31:49
	 */
	public void register() {
		// User user = getModel(User.class);
		String userName = getPara("userName", "");
		String passWord = getPara("passWord", "");
		String nikeName = getPara("nikeName", "");
		BaseResultDto result = null;
		if (StringUtil.isNotNull(nikeName)) {
			result = userService.saveUser(userName, passWord, nikeName);
		} else {
			result = userService.saveUser(userName, passWord);
		}
		render(result);
	}
}
