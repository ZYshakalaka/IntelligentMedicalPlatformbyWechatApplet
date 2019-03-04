package com.zy.core.controller;

import java.rmi.server.UID;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zy.core.model.Evaluate;
import com.zy.core.model.EvaluateExample;
import com.zy.core.model.Press;
import com.zy.core.model.PressDescribe;
import com.zy.core.model.PressDescribeExample;
import com.zy.core.model.PressExample;
import com.zy.core.model.Rate;
import com.zy.core.model.RateDescribe;
import com.zy.core.model.RateDescribeExample;
import com.zy.core.model.RateExample;
import com.zy.core.model.Tem;
import com.zy.core.model.TemDescribe;
import com.zy.core.model.TemDescribeExample;
import com.zy.core.model.TemExample;
import com.zy.core.model.User;
import com.zy.core.model.UserExample;
import com.zy.core.service.DaService;
import com.zy.util.EvaluateJson;
import com.zy.util.MyJson;
import com.zy.util.RankJson;
import com.zy.util.RankselfJson;
import com.zy.util.Time;
import com.zy.util.dataJson;

/**
 * 关于地区统计和排行榜
 * @author zouyu
 *
 */
@Controller
@RequestMapping("data/")
public class DataCityController {

	@Resource(name="userService")
	private DaService<User,UserExample> userDaService;
	@Resource(name="evaluateService")
	private DaService<Evaluate,EvaluateExample> evaluateDaService;
	@Resource(name="temService")
	private DaService<Tem, TemExample> temDaService;
	@Resource(name="rateService")
	private DaService<Rate,RateExample> rateDaService;
	@Resource(name="pressService")
	private DaService<Press,PressExample> pressDaService;
	
	/**
	 * 获得自己排名
	 * @author zouyu
	 * @return
	 * @throws ParseException 
	 */
	@ResponseBody
	@RequestMapping(value="rankbyself.do")
	public RankselfJson rankbyself(@RequestParam String id) throws ParseException{
		RankselfJson rankselfJson = new RankselfJson();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		String today = df.format(new Date());
		Time time = new Time();
		List<Date> daList = time.dateToWeek(df.parse(today));
		Date monday=null;
		monday = daList.get(0);
		System.out.println(monday.toString());
		
		EvaluateExample eample = new EvaluateExample();
		List<Evaluate> eList = new ArrayList<Evaluate>();
		List<Map<String, String>> maplist = new ArrayList<Map<String,String>>();
		List<Map<String, String>> maplistend = new ArrayList<Map<String,String>>();
		eample.createCriteria().andEvaluateTimeGreaterThanOrEqualTo(monday);
		eList = evaluateDaService.selectByExample(eample);
		Collections.sort(eList,new Comparator<Evaluate>(){
			@Override
			public int compare(Evaluate o1, Evaluate o2) {
				return o1.getUserId().compareTo(o2.getUserId());
			}
		});
		int i=0,total=0;
		String uid =null;
		int k=0;
		for(Evaluate e:eList){
			if (i == 0) {
				uid = e.getUserId();
				total += Integer.parseInt(e.getScore());
				++i;
			}else if (uid.equals(e.getUserId())) {
				total += Integer.parseInt(e.getScore());
				++i;
				//遍历到最后一个
				if (k==eList.size()-1) {
					Map<String, String> map = new HashMap<String, String>();
					map.put("score", String.valueOf(total/i));
					map.put("times", String.valueOf(i));
					map.put("userid", uid);
					maplist.add(map);
					break;
				}
			}else {
				Map<String, String> map = new HashMap<String, String>();
				map.put("score", String.valueOf(total/i));
				map.put("times", String.valueOf(i));
				map.put("userid", uid);
				maplist.add(map);
				
				uid = e.getUserId();
				i = 1;
				total =Integer.parseInt(e.getScore());
				//遍历到最后一个
				if (k==eList.size()-1) {
					Map<String, String> mapp = new HashMap<String, String>();
					mapp.put("score", String.valueOf(total/i));
					mapp.put("times", String.valueOf(i));
					mapp.put("userid", uid);
					maplist.add(mapp);
					break;
				}
			}
			k++;
		}
		Collections.sort(maplist,new Comparator<Map<String,String>>(){
			@Override
			public int compare(Map<String, String> o1, Map<String, String> o2) {
				return o2.get("times").compareTo(o1.get("times"));
			}
		});
		int flag=1;
		for(Map<String,String> m:maplist){
			if (m.get("userid").equals(id)) {
				maplistend.add(m);
				break;
			}
			++flag;
		}
		
		net.sf.json.JSONArray json = net.sf.json.JSONArray.fromObject(maplistend);
		rankselfJson.setTime(new Date().toString().substring(0, 19));
		rankselfJson.setNumber(flag);
		rankselfJson.setJson(json);
		return rankselfJson;
	}
	
	
	/**
	 * 获得周排名by times  
	 * @author zouyu
	 * @return
	 * @throws ParseException 
	 */
	@ResponseBody
	@RequestMapping(value="rankbyday.do")
	public RankJson rankbyday() throws ParseException{
		
		RankJson rankJson = new RankJson();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		String today = df.format(new Date());
		Time time = new Time();
		List<Date> daList = time.dateToWeek(df.parse(today));
		Date monday=null;
		monday = daList.get(0);
		System.out.println(monday.toString());
		
		EvaluateExample eample = new EvaluateExample();
		List<Evaluate> eList = new ArrayList<Evaluate>();
		List<Map<String, String>> maplist = new ArrayList<Map<String,String>>();
		List<Map<String, String>> maplistend = new ArrayList<Map<String,String>>();
		eample.createCriteria().andEvaluateTimeGreaterThanOrEqualTo(monday);
		eList = evaluateDaService.selectByExample(eample);
//		for(Evaluate e:eList){
//			System.out.println("uid:"+e.getUserId());
//		}
//		System.out.println("=================");
		Collections.sort(eList,new Comparator<Evaluate>(){
			@Override
			public int compare(Evaluate o1, Evaluate o2) {
				return o1.getUserId().compareTo(o2.getUserId());
			}
		});
		int i=0,total=0;
		String uid =null;
		
//		for(Evaluate e:eList){
//			System.out.println(e.getUserId());
//		}
		int k=0;
		for(Evaluate e:eList){
			if (i == 0) {
				uid = e.getUserId();
				total += Integer.parseInt(e.getScore());
				++i;
			}else if (uid.equals(e.getUserId())) {
				total += Integer.parseInt(e.getScore());
				++i;
				//遍历到最后一个
				if (k==eList.size()-1) {
					Map<String, String> map = new HashMap<String, String>();
					map.put("score", String.valueOf(total/i));
					map.put("times", String.valueOf(i));
					map.put("userid", uid);
					map.put("img", getImg(uid));
					maplist.add(map);
					break;
				}
			}else {
				Map<String, String> map = new HashMap<String, String>();
				map.put("score", String.valueOf(total/i));
				map.put("times", String.valueOf(i));
				map.put("userid", uid);
				map.put("img", getImg(uid));
				maplist.add(map);
				
				uid = e.getUserId();
				i = 1;
				total =Integer.parseInt(e.getScore());
				//遍历到最后一个
				if (k==eList.size()-1) {
					Map<String, String> mapp = new HashMap<String, String>();
					mapp.put("score", String.valueOf(total/i));
					mapp.put("times", String.valueOf(i));
					mapp.put("userid", uid);
					mapp.put("img", getImg(uid));
					maplist.add(mapp);
					break;
				}
			}
			k++;
		}
		
		Collections.sort(maplist,new Comparator<Map<String,String>>(){
			@Override
			public int compare(Map<String, String> o1, Map<String, String> o2) {
				return Integer.valueOf(o2.get("times")).compareTo(Integer.valueOf(o1.get("times")));
			}
		});
		int flag=0;
		//取得top3
		for(Map<String,String> m: maplist){
			maplistend.add(m);
			if (flag == 2) {
				break;
			}
			flag++;
		}
		net.sf.json.JSONArray json = net.sf.json.JSONArray.fromObject(maplistend);
		rankJson.setTime(new Date().toString().substring(0, 19));
		rankJson.setJson(json);
		return rankJson;
	}
	
	/**
	 * 区域统计
	 * @author zouyu
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getdata.do")
	public dataJson getData(){
		dataJson dataJson = new dataJson();
		/**
		 * 处理体温数据
		 */
		TemExample temExample0 = new TemExample();
		int totalt = temDaService.countByExample(temExample0);
		TemExample temExample1 = new TemExample();
		temExample1.createCriteria().andUserTemGreaterThan("3700");
		List<Tem> tListH = temDaService.selectByExample(temExample1); //高温
		TemExample temExample2 = new TemExample();
		temExample2.createCriteria().andUserTemLessThan("3600");
		List<Tem> tListL = temDaService.selectByExample(temExample2);  //低温
		/**
		 * 处理心率数据
		 */
		RateExample raExample0 = new RateExample();
		int totalr = rateDaService.countByExample(raExample0);
		RateExample raExample1 = new RateExample();
		raExample1.createCriteria().andUserRateGreaterThan(100);
		List<Rate> rListH = rateDaService.selectByExample(raExample1);
		RateExample raExample2 = new RateExample();
		raExample2.createCriteria().andUserRateLessThan(60);
		List<Rate> rListL = rateDaService.selectByExample(raExample2);
		System.out.println(rListH.size()+","+rListL.size());
		/**
		 * 处理血压数据
		 */
		PressExample pExample0 = new PressExample();
		int totalp = pressDaService.countByExample(pExample0);
		PressExample pExample1 = new PressExample();
		pExample1.createCriteria().andUserPressHGreaterThan(130);
		List<Press> pListH = pressDaService.selectByExample(pExample1);
		PressExample pExample2 = new PressExample();
		pExample2.createCriteria().andUserPressHLessThan(90);
		List<Press> pListL = pressDaService.selectByExample(pExample2);
		System.out.println(pListH.size()+","+pListL.size());
		
		
		net.sf.json.JSONArray jsont_h = net.sf.json.JSONArray.fromObject(getTemH(tListH));
		net.sf.json.JSONArray jsont_l = net.sf.json.JSONArray.fromObject(getTemH(tListL));
		net.sf.json.JSONArray jsonr_h = net.sf.json.JSONArray.fromObject(getRateH(rListH));
		net.sf.json.JSONArray jsonr_l = net.sf.json.JSONArray.fromObject(getRateH(rListL));
		net.sf.json.JSONArray jsonp_h = net.sf.json.JSONArray.fromObject(getPress(pListH));
		net.sf.json.JSONArray jsonp_l = net.sf.json.JSONArray.fromObject(getPress(pListL));
		dataJson.setTime(new Date().toString().substring(0, 19));
		dataJson.setJsont_h(jsont_h);
		dataJson.setJsont_l(jsont_l);
		dataJson.setJsonr_h(jsonr_h);
		dataJson.setJsonr_l(jsonr_l);
		dataJson.setJsonp_h(jsonp_h);
		dataJson.setJsonp_l(jsonp_l);
		dataJson.setPh(pListH.size()+"/"+totalp);
		dataJson.setPl(pListL.size()+"/"+totalp);
		dataJson.setRh(rListH.size()+"/"+totalr);
		dataJson.setRl(rListL.size()+"/"+totalr);
		dataJson.setTh(tListH.size()+"/"+totalt);
		dataJson.setTl(tListL.size()+"/"+totalt);
		
		return dataJson;
	}
	
	
	
	
	
	
	/**
	 * 通过id得到头像
	 * @author zouyu
	 * @param user_id
	 * @return
	 */
	private String getImg(String user_id){
		UserExample userExample = new UserExample();
		userExample.createCriteria().andIdEqualTo(user_id);
		List<User> users = userDaService.selectByExample(userExample);
		for(User u:users){
			return u.getImg();
		}
		return null;
	}
	
	/**
	 * 得到体温不正常者信息
	 * @author zouyu
	 * @param tList
	 * @return
	 */
	private List<Map<String, String>> getTemH(List<Tem> tList){
		List<String> mapList = new ArrayList<String>();
		for(Tem t:tList){   //H
			UserExample uExample = new UserExample();
			uExample.createCriteria().andIdEqualTo(t.getUserId());
			List<User> uListH = userDaService.selectByExample(uExample);
			for(User u:uListH){
				mapList.add(u.getCity());
			}
		}
		Collections.sort(mapList,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		List<Map<String, String>> tmapList = new ArrayList<Map<String,String>>();
		int k=0,i=0;
		String city=null;
		System.out.println(mapList.size());
		for(String s:mapList){
			if (i == 0) {
				city = s;
				++i;
			}else if (city.equals(s)) {
				++i;
				//遍历到最后一个
				if (k==mapList.size()-1) {
					Map<String, String> map = new HashMap<String, String>();
					map.put("name", city);
					map.put("data", String.valueOf((int)((i*100))/tList.size()));
					tmapList.add(map);
					break;
				}
			}else {
				Map<String, String> map = new HashMap<String, String>();
				map.put("name", city);
				map.put("data", String.valueOf((int)((i*100))/tList.size()));
				tmapList.add(map);
				
				city = s;
				i = 1;
				//遍历到最后一个
				if (k==mapList.size()-1) {
					Map<String, String> mapp = new HashMap<String, String>();
					mapp.put("name", city);
					mapp.put("data", String.valueOf((int)((i*100))/tList.size()));
					tmapList.add(mapp);
					break;
				}
			}
			k++;
		}
		Collections.sort(tmapList,new Comparator<Map<String,String>>(){
			@Override
			public int compare(Map<String, String> o1, Map<String, String> o2) {
				return o2.get("data").compareTo(o1.get("data"));
			}
		});
		return tmapList;
	}
	
	/**
	 * 得到心率不正常者信息 sex
	 * @author zouyu
	 * @param tList
	 * @return
	 */
	private List<Map<String, String>> getRateH(List<Rate> rList){

		System.out.println(rList.size());
		List<String> mapList = new ArrayList<String>();
		for(Rate r:rList){   //H
			UserExample uExample = new UserExample();
			uExample.createCriteria().andIdEqualTo(r.getUserId());
			List<User> uListH = userDaService.selectByExample(uExample);
			for(User u:uListH){
				mapList.add(u.getSex());
			}
		}
		List<Map<String, String>> tmapList = new ArrayList<Map<String,String>>();

		int i=0,j=0;
		for(String s:mapList){
			if (s.equals("男")) {
				i++;
			}else{
				j++;
			}
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("name","男");
		map.put("data", String.valueOf((int)((i*100))/rList.size()));
		tmapList.add(map);
		Map<String, String> mapp = new HashMap<String, String>();
		mapp.put("name","女");
		mapp.put("data", String.valueOf((int)((j*100))/rList.size()));
		tmapList.add(mapp);
		return tmapList;
	}
	
	
	/**
	 * 得到血压不正常者信息
	 * @author zouyu
	 * @param pList
	 * @return
	 */
	private List<Map<String, String>> getPress(List<Press> pList){
		List<Integer> mapList = new ArrayList<Integer>();
		List<User> uListH = new ArrayList<User>();
		for(Press p:pList){   //H
			UserExample uExample = new UserExample();
			uExample.createCriteria().andIdEqualTo(p.getUserId());
			uListH = userDaService.selectByExample(uExample);
			for(User u:uListH){
				mapList.add(u.getAge());
			}
		}
//		System.out.println("listp:"+pList.size());
//		System.out.println("listu:"+uListH.size());
//		System.out.println("list:"+mapList.size());
		
		Collections.sort(mapList,new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		int i=0,j=0,k=0,l=0,m=0;
		for(Integer s:mapList){
			if (s < 20) {
				i++;
			}else if(s >=20 && s <40){
				j++;
			}else if(s >=40 && s <60){
				k++;
			}else if(s >=60 && s <80){
				l++;
			}else {
				m++;
			}
		}
		System.out.println("i:"+i);
		System.out.println("j:"+j);
		System.out.println("k:"+k);
		System.out.println("l:"+l);
		System.out.println("m:"+m);

		List<Map<String, String>> pMaps = new ArrayList<Map<String,String>>();
		if (i != 0) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", "0~20");
			map.put("data", String.valueOf((int)((i*100))/pList.size()));
			pMaps.add(map);
		}
		if (j != 0) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", "20~40");
			map.put("data", String.valueOf((int)((j*100))/pList.size()));
			pMaps.add(map);
		}
		if (k != 0) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", "40~60");
			map.put("data", String.valueOf((int)((k*100))/pList.size()));
			pMaps.add(map);
		}
		if (l != 0){
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", "60~80");
			map.put("data", String.valueOf((int)((l*100))/pList.size()));
			pMaps.add(map);
		}
		if (m != 0) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", "80~120");
			map.put("data", String.valueOf((int)((m*100))/pList.size()));
			pMaps.add(map);
		}
		return pMaps;
	}
}

/** 
* @date:2017年8月6日 
* @author:zouyu
*/ 