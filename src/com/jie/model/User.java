package com.jie.model;

import java.util.List;

import com.jie.model.base.BaseUser;
import com.jie.util.IConstants;
import com.jie.util.Kits;

@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	public static User dao = new User();

	/**
	 * @Description 保存用户
	 * @auth weishujie
	 * @creattime 2017年8月4日下午3:47:03
	 * @param userName
	 * @param passWord
	 * @param nickName
	 * @return
	 */
	public int saveUser(String userName, String passWord, String nickName) {
		User user = new User();
		user.setNickname(nickName);
		user.setPassword(passWord);
		user.setUsername(userName);
		user.setUuid(Kits.getUUID());
		user.save();
		return user.getNumber(IConstants.PK).intValue();
	}

	/**
	 * @Description 根据用户名查找用户
	 * @auth weishujie
	 * @creattime 2017年8月4日下午3:46:59
	 * @param userName
	 * @return
	 */
	public List<User> queryUserByName(String userName) {
		String querySql = "SELECT * FROM `user` u WHERE u.username=?";
		List<User> userList = User.dao.find(querySql, userName);
		return userList;
	}

	/**
	 * @Description 根据用户名和密码查询用户
	 * @auth weishujie
	 * @creattime 2017年8月4日下午3:59:51
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public User queryUser(String userName, String passWord) {
		String querySql = "SELECT * FROM `user` u WHERE u.username=? and u.password=?";
		User user = dao.findFirst(querySql, userName, passWord);
		return user;
	}

}
