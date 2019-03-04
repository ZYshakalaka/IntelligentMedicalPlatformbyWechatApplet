package com.zy.core.controller;

import java.awt.List;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

















import com.zy.core.model.Tem;
import com.zy.core.model.TemExample;
import com.zy.core.service.DaService;
import com.zy.util.MyJson;

import java.text.DecimalFormat;

@Controller
@RequestMapping("tem/")
public class TemController {

	@Resource(name="temService")
	private DaService<Tem, TemExample> temDaService;
	
	/**
	 * 得到温度数据
	 * @author zouyu
	 * @param user_tem
	 * @param user_id
	 * @param model
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="gettem.do",method=RequestMethod.POST)
	public String getData(@RequestParam String user_tem,
			@RequestParam String tem,
			@RequestParam String user_id,Model model) throws ParseException{
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = df.format(new Date());
		
		Tem t = new Tem();
		t.setUserId(user_id);
		t.setUserTem(user_tem);
		t.setTime(df.parse(today));
		t.setTem(tem);
		temDaService.insert(t);
		
		return "tem";
	}
	
	/**
	 * 处理温度数据for week
	 * @author zouyu
	 * @param user_id
	 * @return
	 * @throws ParseException 
	 */
	@ResponseBody
	@RequestMapping(value="caltemforday.do")
	public MyJson caltembyday(@RequestParam String user_id) throws ParseException{
		MyJson myJson = new MyJson();
		
		Date d=null;
		TemExample temExample = new TemExample();
		temExample.createCriteria().andUserIdEqualTo(user_id);
		java.util.List<Tem> tList = temDaService.selectByExample(temExample);
		
		LinkedHashMap<String, Date> mapp = new LinkedHashMap<String, Date>();
		
		for(Tem tem :tList){
			mapp.put(tem.getTime().toString().substring(0, 10),tem.getTime());
		}
		int jj = 0;
		ListIterator<Map.Entry<String,Date>> ii= new ArrayList<Map.Entry<String,Date>>(mapp.entrySet()).listIterator(mapp.size());
			while(ii.hasPrevious()) {
				++jj;
				Map.Entry<String, Date> entry = ii.previous();
				if (jj == 5) {
					d = entry.getValue();
					break;
				}
			}
		
		TemExample tExample = new TemExample();
		tExample.createCriteria().andUserIdEqualTo(user_id).andTimeGreaterThanOrEqualTo(d);
		java.util.List<Tem> temlist = temDaService.selectByExample(tExample);
		
		java.util.List<Map> listm = new ArrayList<Map>();

		double temp = 0;
		boolean flag=false;
		String today = null;
		DecimalFormat totwo = new DecimalFormat("#.00");
		if(temlist != null && temlist.size()>0){
			Tem temm = new Tem();
			int i = 0;
			int j = 1;
			//System.out.println(temlist.size());
			for(Tem t : temlist){

				Map<String,String> map = new HashMap<String,String>();
				
				if (i == 0) {
					temp = Double.valueOf(t.getTem());
				}
				//将一天多余数据平均化
				if (i != 0 && temm.getTime().toString().substring(0, 3).equals(t.getTime().toString().substring(0, 3))) {
					temp = temp+Double.valueOf(t.getTem());
					++j;
					if (i == temlist.size()-1) {
						map.put("tem", totwo.format(temp/(j*100)));
						map.put("time", temm.getTime().toString().substring(0, 3));
						listm.add(map);
						flag=true;
						break;
					}
					
				}else if(i != 0 && !temm.getTime().toString().substring(0, 3).equals(t.getTime().toString().substring(0, 3))){

					map.put("tem", totwo.format(temp/(j*100)));
					map.put("time", temm.getTime().toString().substring(0, 3));
					listm.add(map);
					j = 1;
					temp = Double.valueOf(t.getTem());
				}
				if (i == temlist.size()-1) {
					today = t.getTime().toString().substring(0, 3);
					break;
				}
				temm.setId(t.getId());
				temm.setTem(t.getTem());
				temm.setTime(t.getTime());
				temm.setUserId(t.getUserId());
				temm.setUserTem(t.getUserTem());

				i++;
			}
		}

		Map<String,String> maptail = new HashMap<String,String>();
		if (flag == false) {
			maptail.put("tem",totwo.format(temp/100));
			maptail.put("time", today);
			listm.add(maptail);
		}
		net.sf.json.JSONArray json = net.sf.json.JSONArray.fromObject(listm);
		myJson.setFlag(MyJson.ANSWER_OK);
		myJson.setJson(json);
		return myJson;
	}
	
	/**
	 * 处理体温度数据for week
	 * @author zouyu
	 * @param user_id
	 * @return
	 * @throws ParseException 
	 */
	@ResponseBody
	@RequestMapping(value="calutemforday.do")
	public MyJson calutembyday(@RequestParam String user_id) throws ParseException{
		MyJson myJson = new MyJson();
		
		Date d=null;
		TemExample temExample = new TemExample();
		temExample.createCriteria().andUserIdEqualTo(user_id);
		java.util.List<Tem> tList = temDaService.selectByExample(temExample);
		LinkedHashMap<String, Date> mapp = new LinkedHashMap<String, Date>();
		for(Tem tem :tList){
			mapp.put(tem.getTime().toString().substring(0, 10),tem.getTime());
		}
		int jj = 0;
		ListIterator<Map.Entry<String,Date>> ii= new ArrayList<Map.Entry<String,Date>>(mapp.entrySet()).listIterator(mapp.size());
			while(ii.hasPrevious()) {
				++jj;
				Map.Entry<String, Date> entry = ii.previous();
				if (jj == 5) {
					d = entry.getValue();
					break;
				}
			}
		
		TemExample tExample = new TemExample();
		tExample.createCriteria().andUserIdEqualTo(user_id).andTimeGreaterThanOrEqualTo(d);
		java.util.List<Tem> temlist = temDaService.selectByExample(tExample);
		
		java.util.List<Map> listm = new ArrayList<Map>();
		
		double temp = 0;
		boolean flag=false;
		String today = null;
		DecimalFormat totwo = new DecimalFormat("#.00");
		if(temlist != null && temlist.size()>0){
			Tem temm = new Tem();
			int i = 0;
			int j = 1;
			//System.out.println(temlist.size());
			for(Tem t : temlist){

				Map<String,String> map = new HashMap<String,String>();
				
				if (i == 0) {
					temp = Double.valueOf(t.getUserTem());
				}
				//将一天多余数据平均化
				if (i != 0 && temm.getTime().toString().substring(0, 3).equals(t.getTime().toString().substring(0, 3))) {
					temp = temp+Double.valueOf(t.getUserTem());
					++j;
					if (i == temlist.size()-1) {
						map.put("tem", totwo.format(temp/(j*100)));
						map.put("time", temm.getTime().toString().substring(0, 3));
						listm.add(map);
						flag = true;
						break;
					}
					
				}else if(i != 0 && !temm.getTime().toString().substring(0, 3).equals(t.getTime().toString().substring(0, 3))){

					map.put("tem", totwo.format(temp/(j*100)));
					map.put("time", temm.getTime().toString().substring(0, 3));
					listm.add(map);
					j = 1;
					temp = Double.valueOf(t.getUserTem());
				}
				if (i == temlist.size()-1) {
					today = t.getTime().toString().substring(0, 3);
					break;
				}
				temm.setId(t.getId());
				temm.setTem(t.getTem());
				temm.setTime(t.getTime());
				temm.setUserId(t.getUserId());
				temm.setUserTem(t.getUserTem());

				i++;
			}
		}
		Map<String,String> maptail = new HashMap<String,String>();
		if (flag == false) {
			maptail.put("tem",totwo.format(temp/100));
			maptail.put("time", today);
			listm.add(maptail);
		}
		
		net.sf.json.JSONArray json = net.sf.json.JSONArray.fromObject(listm);
		myJson.setFlag(MyJson.ANSWER_OK);
		myJson.setJson(json);
		return myJson;
	}
}

/** 
* @date:2017年7月8日 
* @author:zouyu
*/ 