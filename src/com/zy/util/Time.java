package com.zy.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Time {

	/**
	 * 工具类 得到一周
	 * @author zouyu
	 * @param mdate
	 * @return
	 */
	public List<Date> dateToWeek(Date mdate){
		int b = mdate.getDay();
		Date fdate;
		List<Date> list = new ArrayList<Date>();
		Long fTime = mdate.getTime() - b*24*3600000;
		for (int a =1;a<=7;a++){
		fdate = new Date();
		fdate.setTime(fTime +(a*24*3600000));
			list.add(a-1,fdate);
		}
		return list;
    }
	
	
	
}

/** 
* @date:2017年8月9日 
* @author:zouyu
*/ 