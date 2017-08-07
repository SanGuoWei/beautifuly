package com.jie.service;

import com.jie.ResConsts;
import com.jie.dot.BaseResultDto;
import com.jie.model.User;
import com.jie.util.StringUtil;

public class UserService {
	private static String DEFAULT_NICKNAME = "游客";

	public BaseResultDto saveUser(String userName, String passWord) {
		return saveUser(userName, passWord, DEFAULT_NICKNAME);
	}

	public BaseResultDto saveUser(String userName, String passWord, String nickName) {
		BaseResultDto result = new BaseResultDto();
		if (StringUtil.isNull(userName, passWord, nickName)) {
			result.setStatus(ResConsts.Code.ERROR);
			result.setInfo("参数为空...");
			result.setDate(0);
			return result;
		}
		int id = User.dao.saveUser(userName, passWord, nickName);
		result.setDate(id);
		return result;
	}

	public BaseResultDto login(String userName, String passWord) {
		BaseResultDto result = new BaseResultDto();
		User user = User.dao.queryUser(userName, passWord);
		if (user == null) {
			result.setStatus(ResConsts.Code.ERROR);
			result.setInfo("用户名或密码错误");
		} else {
			result.setDate(user);
		}
		return result;
	}

}
