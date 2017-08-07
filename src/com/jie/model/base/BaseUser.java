package com.jie.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class BaseUser<M extends BaseUser<M>> extends Model<M> implements IBean {

	public void setId(int id) {
		set("id", id);
	}

	public Integer getId() {
		return getInt("id");
	}

	public void setUuid(String uuid) {
		set("uuid", uuid);
	}

	public String getUuid() {
		return get("uuid");
	}

	public void setUsername(String userName) {
		set("username", userName);
	}

	public String getUsername() {
		return get("username");
	}

	public void setPassword(String passWord) {
		set("password", passWord);
	}

	public String getPassword() {
		return get("password");
	}

	public void setNickname(String nickName) {
		set("nickname", nickName);
	}

	public String getNickname() {
		return get("nickname");
	}
}
