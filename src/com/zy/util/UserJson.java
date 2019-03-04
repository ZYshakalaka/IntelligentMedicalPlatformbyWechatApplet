package com.zy.util;
public class UserJson {

	public static final int ANSWER_OK=1;//成功标志字段
	public static final int ANSWER_ERROR=0;//错误标志字段
	
	private int flag;//标志字段
	private String user_id;
	private String tem;
	private String user_tem;
	private String user_press_l;
	private String user_press_h;
	private String user_rate;
	private String tem_time;
	private String press_time;
	private String rate_time;
	private String relation;
	private int age;
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTem() {
		return tem;
	}
	public void setTem(String tem) {
		this.tem = tem;
	}
	public String getUser_tem() {
		return user_tem;
	}
	public void setUser_tem(String user_tem) {
		this.user_tem = user_tem;
	}
	public String getUser_press_l() {
		return user_press_l;
	}
	public void setUser_press_l(String user_press_l) {
		this.user_press_l = user_press_l;
	}
	public String getUser_press_h() {
		return user_press_h;
	}
	public void setUser_press_h(String user_press_h) {
		this.user_press_h = user_press_h;
	}
	public String getUser_rate() {
		return user_rate;
	}
	public void setUser_rate(String user_rate) {
		this.user_rate = user_rate;
	}
	public String getTem_time() {
		return tem_time;
	}
	public void setTem_time(String tem_time) {
		this.tem_time = tem_time;
	}
	public String getPress_time() {
		return press_time;
	}
	public void setPress_time(String press_time) {
		this.press_time = press_time;
	}
	public String getRate_time() {
		return rate_time;
	}
	public void setRate_time(String rate_time) {
		this.rate_time = rate_time;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}

/** 
* @date:2017年7月13日 
* @author:zouyu
*/ 