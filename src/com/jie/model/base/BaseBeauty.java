package com.jie.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class BaseBeauty<M extends BaseBeauty<M>> extends Model<M> implements IBean {

	public void setId(int id) {
		set("id", id);
	}

	public Integer getId() {
		return getInt("id");
	}

	public void setUrl(String url) {
		set("url", url);
	}

	public String getUrl() {
		return get("url");
	}

	public void setCreateTime(long creaeTime) {
		set("create_time", creaeTime);
	}

	public Long getCreateTime() {
		return get("create_time");
	}

	public void setUpdateTime(long updateTime) {
		set("update_time", updateTime);
	}

	public Long getUpdateTime() {
		return get("update_time");
	}

	public void setDirectory(String directory) {
		set("directory", directory);
	}

	public String getDirectory() {
		return get("directory");
	}
}
