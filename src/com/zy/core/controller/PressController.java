package com.zy.core.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zy.core.model.Press;
import com.zy.core.model.PressExample;
import com.zy.core.model.Rate;
import com.zy.core.model.RateExample;
import com.zy.core.model.Tem;
import com.zy.core.model.TemExample;
import com.zy.core.service.DaService;
import com.zy.util.MyJson;

@Controller
@RequestMapping("press/")
public class PressController {

	@Resource(name="pressService")
	private DaService<Press,PressExample> pressDaService;
	
	
	/**
	 * 得到press值
	 * @author zouyu
	 * @param user_press_l
	 * @param user_press_h
	 * @param user_id
	 * @param model
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="getpress.do",method=RequestMethod.POST)
	public String getData(@RequestParam String user_press_l,
			@RequestParam String user_press_h,@RequestParam String user_id,Model model) throws ParseException{
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = df.format(new Date());
		
		Press press = new Press();
		press.setUserId(user_id);
		press.setUserPressH(Integer.valueOf(user_press_h));
		press.setUserPressL(Integer.valueOf(user_press_l));
		press.setTime(df.parse(today));
		
		pressDaService.insert(press);
		
		return "press";
	}
	
	/**
	 * 处理血压数据for week
	 * @author zouyu
	 * @param user_id
	 * @return
	 * @throws ParseException 
	 */
	@ResponseBody
	@RequestMapping(value="calpressforday.do")
	public MyJson calpressbyday(@RequestParam String user_id) throws ParseException{
		MyJson myJson = new MyJson();
		
		Date d=null;
		PressExample presExample = new PressExample();
		presExample.createCriteria().andUserIdEqualTo(user_id);
		java.util.List<Press> preList = pressDaService.selectByExample(presExample);
		
		LinkedHashMap<String, Date> mapp = new LinkedHashMap<String, Date>();
		for(Press press :preList){
			mapp.put(press.getTime().toString().substring(0, 10),press.getTime());
		}
		System.out.println(mapp.size());
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
		PressExample pExample = new PressExample();

		pExample.createCriteria().andUserIdEqualTo(user_id).andTimeGreaterThanOrEqualTo(d);
		java.util.List<Press> presslist = pressDaService.selectByExample(pExample);
		System.out.println("..............."+presslist.size());
		
		java.util.List<Map> listp = new ArrayList<Map>();
		int temp = 0;
		int temp2 = 0;
		boolean flag=false;
		String today = null;
		if(presslist != null && presslist.size()>0){
			Press presse = new Press();
			int i = 0;
			int j = 1;
			//System.out.println(temlist.size());
			for(Press p : presslist){

				Map<String,String> map = new HashMap<String,String>();
				
				if (i == 0) {
					temp = p.getUserPressH();
					temp2 = p.getUserPressL();
				}
				//将一天多余数据平均化
					if (i != 0 && presse.getTime().toString().substring(0, 3).equals(p.getTime().toString().substring(0, 3))) {
						temp = temp+p.getUserPressH();
						temp2 = temp2+p.getUserPressL();
						++j;
						if (i == presslist.size()-1) {
							map.put("user_press_h",String.valueOf((int)(temp/j)));
							map.put("user_press_l",String.valueOf((int)(temp2/j)));
							map.put("time", presse.getTime().toString().substring(0, 3));
							listp.add(map);
							flag=true;
							break;
						}
					}
					else if(i != 0 && !presse.getTime().toString().substring(0, 3).equals(p.getTime().toString().substring(0, 3))){

						map.put("user_press_h",String.valueOf((int)(temp/j)));
						map.put("user_press_l",String.valueOf((int)(temp2/j)));
						map.put("time", presse.getTime().toString().substring(0, 3));
						listp.add(map);
						j = 1;
						temp = p.getUserPressH();
						temp2 = p.getUserPressL();
					}
					if (i == presslist.size()-1) {
						today=p.getTime().toString().substring(0, 3);
						break;
					}
					presse.setId(p.getId());
					presse.setUserPressH(p.getUserPressH());
					presse.setUserPressL(p.getUserPressL());
					presse.setTime(p.getTime());
					presse.setUserId(p.getUserId());
				i++;
			}
		}
		
		Map<String,String> maptail = new HashMap<String,String>();
		if (flag == false) {
			maptail.put("user_press_h",String.valueOf(temp));
			maptail.put("user_press_l",String.valueOf(temp2));
			maptail.put("time", today);
			listp.add(maptail);
		}
		
		
		net.sf.json.JSONArray json = net.sf.json.JSONArray.fromObject(listp);
		myJson.setFlag(MyJson.ANSWER_OK);
		myJson.setJson(json);
		return myJson;
	}
	
}

/** 
* @date:2017年7月8日 
* @author:zouyu
*/ 