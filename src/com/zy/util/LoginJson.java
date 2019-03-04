package com.zy.util;
/**
 * 后台管理对象
 * @author zouyu
 *
 */
public class LoginJson {
	
	private String relation;
	private net.sf.json.JSONArray json;
	private String phone;
	
	
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public net.sf.json.JSONArray getJson() {
		return json;
	}
	public void setJson(net.sf.json.JSONArray json) {
		this.json = json;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
