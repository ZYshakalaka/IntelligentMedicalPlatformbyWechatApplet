package com.zy.core.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
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
@RequestMapping("rate/")
public class RateController {

	@Resource(name="rateService")
	private DaService<Rate,RateExample> rateDaService;
	
	/**
	 * 得到心率数据
	 * @author zouyu
	 * @param user_rate
	 * @param user_id
	 * @param model
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="getrate.do",method=RequestMethod.POST)
	public String getData(@RequestParam String user_rate,
			@RequestParam String user_id,Model model) throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = df.format(new Date());
		
		Rate rate = new Rate();
		rate.setUserId(user_id);
		rate.setUserRate(Integer.valueOf(user_rate));
		rate.setTime(df.parse(today));
		
		rateDaService.insert(rate);
		
		return "rate";
	}
	
	
	/**
	 * 处理心率数据for week
	 * @author zouyu
	 * @param user_id
	 * @return
	 * @throws ParseException 
	 */
	@ResponseBody
	@RequestMapping(value="calrateforday.do")
	public MyJson calratebyday(@RequestParam String user_id) throws ParseException{
		MyJson myJson = new MyJson();
		
		Date d=null;
		RateExample raExample = new RateExample();
		raExample.createCriteria().andUserIdEqualTo(user_id);
		java.util.List<Rate> raList = rateDaService.selectByExample(raExample);
		
		LinkedHashMap<String, Date> mapp = new LinkedHashMap<String, Date>();
		for(Rate rate :raList){
			mapp.put(rate.getTime().toString().substring(0, 10),rate.getTime());
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
		
		
		
		RateExample rExample = new RateExample();
		rExample.createCriteria().andUserIdEqualTo(user_id).andTimeGreaterThanOrEqualTo(d);
		java.util.List<Rate> ratelist = rateDaService.selectByExample(rExample);
		
		java.util.List<Map> listr = new ArrayList<Map>();

		int temp = 0;
		boolean flag=false;
		String today = null;
		if(ratelist != null && ratelist.size()>0){
			Rate ratee = new Rate();
			int i = 0;
			int j = 1;
			//System.out.println(temlist.size());
			for(Rate r : ratelist){

				Map<String,String> map = new HashMap<String,String>();
				
				if (i == 0) {
					temp = r.getUserRate();
				}
				//将一天多余数据平均化
					if (i != 0 && ratee.getTime().toString().substring(0, 3).equals(r.getTime().toString().substring(0, 3))) {
						temp = temp+r.getUserRate();
						++j;
						if (i == ratelist.size()-1) {
							map.put("rate",String.valueOf((int)(temp/j)));
							map.put("time", ratee.getTime().toString().substring(0, 3));
							listr.add(map);
							flag=true;
							break;
						}
					}
					else if(i != 0 && !ratee.getTime().toString().substring(0, 3).equals(r.getTime().toString().substring(0, 3))){

						map.put("rate",String.valueOf((int)(temp/j)));
						map.put("time", ratee.getTime().toString().substring(0, 3));
						listr.add(map);
						j = 1;
						temp = r.getUserRate();
					}
					if (i == ratelist.size()-1) {
						today=r.getTime().toString().substring(0, 3);
						break;
					}
				ratee.setId(r.getId());
				ratee.setUserRate(r.getUserRate());
				ratee.setTime(r.getTime());
				ratee.setUserId(r.getUserId());
				i++;
			}
		}
		
		Map<String,String> maptail = new HashMap<String,String>();
		if (flag == false) {
			maptail.put("rate",String.valueOf(temp));
			maptail.put("time", today);
			listr.add(maptail);
		}
		
		
		net.sf.json.JSONArray json = net.sf.json.JSONArray.fromObject(listr);
		myJson.setFlag(MyJson.ANSWER_OK);
		myJson.setJson(json);
		return myJson;
	}
	
}

/** 
* @date:2017年7月8日 
* @author:zouyu
*/ 