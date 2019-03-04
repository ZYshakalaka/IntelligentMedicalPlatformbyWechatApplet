package com.zy.util;
/**
 * 评估报告返回参数json
 * @author zouyu
 *
 */
public class EvaluateJson {

	public static final int ANSWER_OK=1;//成功标志字段
	public static final int ANSWER_ERROR=0;//错误标志字段
	
	private int score;
	private String user_tem;
	private String tem_describe;
	private String user_rate;
	private String rate_describe;
	private String user_press_l;
	private String user_press_h;
	private String press_describe;
	private String time;
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getUser_tem() {
		return user_tem;
	}
	public void setUser_tem(String user_tem) {
		this.user_tem = user_tem;
	}
	public String getTem_describe() {
		return tem_describe;
	}
	public void setTem_describe(String tem_describe) {
		this.tem_describe = tem_describe;
	}
	public String getUser_rate() {
		return user_rate;
	}
	public void setUser_rate(String user_rate) {
		this.user_rate = user_rate;
	}
	public String getRate_describe() {
		return rate_describe;
	}
	public void setRate_describe(String rate_describe) {
		this.rate_describe = rate_describe;
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
	public String getPress_describe() {
		return press_describe;
	}
	public void setPress_describe(String press_describe) {
		this.press_describe = press_describe;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}

/** 
* @date:2017年7月29日 
* @author:zouyu
*/ 