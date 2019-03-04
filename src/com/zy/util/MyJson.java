package com.zy.util;
/**
 * 后台管理对象
 * @author zouyu
 *
 */
public class MyJson {

	public static final int ANSWER_OK=1;//成功标志字段
	public static final int ANSWER_ERROR=0;//错误标志字段
	
	private int flag;//标志字段
	private net.sf.json.JSONArray json;
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public net.sf.json.JSONArray getJson() {
		return json;
	}
	public void setJson(net.sf.json.JSONArray json) {
		this.json = json;
	}
	
	
	
	
	
}
