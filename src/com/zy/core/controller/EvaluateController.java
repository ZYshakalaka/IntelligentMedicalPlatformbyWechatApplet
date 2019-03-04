package com.zy.core.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
import com.zy.util.ConJson;
import com.zy.util.EvaluateJson;
import com.zy.util.MyJson;
import com.zy.util.SendSms;
import com.zy.util.SmsFinalValue;

@Controller
@RequestMapping("eval/")
public class EvaluateController {

	@Resource(name="userService")
	private DaService<User,UserExample> userDaService;
	@Resource(name="evaluateService")
	private DaService<Evaluate,EvaluateExample> evaluateDaService;
	@Resource(name="temdescribeService")
	private DaService<TemDescribe,TemDescribeExample> tdesDaService;
	@Resource(name="ratedescribeService")
	private DaService<RateDescribe,RateDescribeExample> rdesDaService;
	@Resource(name="pressdescribeService")
	private DaService<PressDescribe,PressDescribeExample> pdesDaService;
	
	EvaluateExample evaluateExample = new EvaluateExample();
    TemDescribeExample tDesExample = new TemDescribeExample();
    RateDescribeExample rDesExample = new RateDescribeExample();
    PressDescribeExample pDesExample = new PressDescribeExample();
	EvaluateJson eJson = new EvaluateJson();
	
	String pressDes="";
	String rateDes="";
	String temDes="";
	String pdescribleString="";
	String rdescribleString="";
	String tdescribleString="";
	int score = 0;
	
	int scoret = 0;
	int scorer = 0;
	int scoreh = 0;
	int scorel = 0;
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String today = df.format(new Date());
	
	
	@ResponseBody
	@RequestMapping(value="sendSms.do")
	public void sendSms(@RequestParam String tem,@RequestParam String rate,
			@RequestParam String press_l,@RequestParam String press_h,@RequestParam String score,
			@RequestParam String user_id,@RequestParam String phone){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("key", SmsFinalValue.key);
		map.put("mobile", phone);
		map.put("templateId", SmsFinalValue.template);
		map.put("param", user_id+","+tem+","+rate+","+press_h+","+press_l+","+score);
		
		SendSms sms = new SendSms();
		sms.sendGet(SmsFinalValue.Url, map, "utf-8");
	}
	
	
	
	/**
	 * 
	 * @author zouyu
	 * @param id 评估表id	
	 * @param user_tem  体温
	 * @param user_press_l  舒张压
	 * @param user_press_h  收缩压
	 * @param rate  心率
	 * @param map  所在城市
	 * @param sex 性别
	 * @return
	 * @throws ParseException 
	 */
	@ResponseBody
	@RequestMapping(value="evaluate.do")
	public EvaluateJson evaluate(@RequestParam String id,@RequestParam String user_tem,
			@RequestParam String user_press_l,@RequestParam String user_press_h,
			@RequestParam String user_rate,@RequestParam String map,@RequestParam String sex
			) throws ParseException{
			
		    /**
		     * 体温处理
		     */
		    if (Double.valueOf(user_tem) > 36 && Double.valueOf(user_tem) < 37) {

		    	scoret = 25;
		    	temdeal("1");
		    	temDes = "体温正常";
		    	
			}else if(Double.valueOf(user_tem) <= 36){
				
				double t = 36 - Double.valueOf(user_tem);
				if (t < 1) {
					t =((t*10)%10)*2.5;
					scoret = (int)t;
				}else if(t > 1 && t < 3){
					scoret = 20;
				}
				temdeal("0");
				temDes = "体温偏低";
				
			}else if(Double.valueOf(user_tem) >= 37){
				
				double t = Double.valueOf(user_tem) - 37;
				if (t < 1) {
					t =((t*10)%10)*2.5;
					scoret = (int)t;
				}else if(t > 1 && t < 3){
					scoret = 20;
				}
				temdeal("2");
				temDes = "体温偏高";
				
			}
		    
		    /**
		     * 心率处理
		     */
		    if (Integer.valueOf(user_rate) > 60 && Integer.valueOf(user_rate) < 100) {
		    	scorer = 25;
		    	ratedeal("1");
		    	rateDes ="心率正常";
			}else if(Integer.valueOf(user_rate) <= 60){
				
				int r = 60 - Integer.valueOf(user_rate);
				if (r < 10) {
					scorer = (int) (r * 2.5);
				}
				rateDes = "心率偏低";
				ratedeal("0");
				
			}else if(Integer.valueOf(user_rate) >= 100){
				
                int r = Integer.valueOf(user_rate) - 100;
				if (r <= 10) {
					scorer = 20 + (int)r/2;
				}else if(r <= 50){
					//10<x<50
					r = r-10;
					scorer = 20 - (int)r/2;
				}
				ratedeal("2");
				rateDes = "心率偏高";
			}
		    
		    /**
		     * 血压处理
		     */
		    if (Integer.valueOf(user_press_l) <= 85 && Integer.valueOf(user_press_h) <= 130) {
		    	
		    	scorel=25;
		    	scoreh=25;
				pressdeal("1");
				pressDes= "血压正常";
			}else if(Integer.valueOf(user_press_l) <= 60 || Integer.valueOf(user_press_h) <= 90){
				
				int h = 90 - Integer.valueOf(user_press_h);
				int l = 60 - Integer.valueOf(user_press_l);
				
				if(h <= 10){
					scoreh = 20 + (int)h/2; 
				}else if(h<= 50){
					h= h-10;
					scoreh = 20 - (int)h/2;
				}
				if(l <= 10){
					scorel = 20 + (int)l/2; 
				}else if(l <= 50){
					l= l-10;
					scorel = 20 - (int)l/2;
				}
				pressdeal("0");
				pressDes= "血压偏低";
			}else if(Integer.valueOf(user_press_l) > 85 || Integer.valueOf(user_press_h) > 130){
				
				int h = Integer.valueOf(user_press_h) - 130;
				int l = Integer.valueOf(user_press_l) - 85;
				if(h <= 10){
					scoreh = 20 + (int)h/2; 
				}else if(h <= 50){
					h= h-10;
					scoreh = 20 - (int)h/2;
				}
				if(l <= 10){
					scorel = 20 + (int)l/2; 
				}else if(l <= 50){
					l = l-10;
					scorel = 20 - (int)l/2;
				}
				pressdeal("2");
				pressDes= "血压偏高";
			}
		    
		    
		    /**
		     * 分数综合
		     */
		    score = scoreh+scorel+scorer+scoret;
		    System.out.println(scoret+" "+scorer+" "+scoreh+" "+scorel);
		    
		    /**
		     * 评估表装填
		     */
		    Evaluate e = new Evaluate();
		    e.setEvaluateMap(map);
		    e.setEvaluateTime(df.parse(today));
		    e.setpDesc(pressDes);
		    e.setPressH(user_press_h);
		    e.setPressL(user_press_l);
		    e.setRate(user_rate);
		    e.setrDesc(rateDes);
		    e.setScore(String.valueOf(score));
		    e.setTem(user_tem);
		    e.settDesc(temDes);
		    e.setPressDescribe(pdescribleString);
		    e.setTemDescribe(tdescribleString);
		    e.setRateDescribe(rdescribleString);
		    e.setUserId(id);
		    evaluateDaService.insert(e);
		    
		    
		    
		    /**
		     * 返回json部分装填
		     */
		    eJson.setUser_tem(user_tem);
		    eJson.setUser_press_h(user_press_h);
		    eJson.setUser_press_l(user_press_l);
		    eJson.setUser_rate(user_rate);
		    eJson.setScore(score);
		    eJson.setTime(today);

		    return eJson;
	}
	
	
	/**
	 * 家长得到评估表列表
	 * @author zouyu
	 * @param id
	 * @param user_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="findeval.do")
	public MyJson findeval(@RequestParam String id){
		MyJson myJson = new MyJson();
		List<User> uList = new ArrayList<User>();
		java.util.List<Map> list = new ArrayList<Map>();
		
		UserExample uample = new UserExample();
		UserExample uexample = new UserExample();
		
			String no=null;
			uample.createCriteria().andIdEqualTo(id);
			userDaService.selectByExample(uample);
			uList = userDaService.selectByExample(uample);
			for (User user : uList){
				no = user.getNo().toString();
			}
			
			uexample.createCriteria().andRelationEqualTo(no);
			uList = userDaService.selectByExample(uexample);
			String useridGroup[] = new String[uList.size()];
			String imgGroup[] = new String[uList.size()];
			int i=0;
			//得到user_id
			for(User u:uList){
				useridGroup[i] = u.getUserId();
				imgGroup[i] = u.getImg();
				i++;
			}
			
			for (int j = 0; j < useridGroup.length; j++) {
				EvaluateExample eample = new EvaluateExample();
				List<Evaluate> eList = new ArrayList<Evaluate>();
				System.out.println(useridGroup[j]);
				eample.createCriteria().andUserIdEqualTo(useridGroup[j]);
				eList = evaluateDaService.selectByExample(eample);
				
				for(Evaluate e:eList){
					String describe=null;
					String tdes="";
					String pdes="";
					String rdes="";
					Map<String,String> map = new HashMap<String,String>();
					map.put("score", e.getScore());
					map.put("time",df.format(e.getEvaluateTime()));
					if (!e.getpDesc().equals("血压正常")) {
						pdes = e.getpDesc()+" ";
					}
					if (!e.getrDesc().equals("心率正常")){
						rdes = e.getrDesc()+" ";
					}
					if (!e.gettDesc().equals("体温正常")){
						tdes = e.gettDesc()+" ";
					}
					System.out.println("p:"+e.getPressDescribe()+"r:"+e.getRateDescribe()+"t:"+e.getTemDescribe());
					if (pdes=="" && rdes=="" && tdes==""){
						describe = "检测一切正常！";
					}else {
						describe = pdes+rdes+tdes;
					}
					map.put("describe", describe);
					map.put("userid", e.getUserId());
					map.put("id", e.getId().toString());
					map.put("img", imgGroup[j]);
					list.add(map);
				}
			}
		
		net.sf.json.JSONArray json = net.sf.json.JSONArray.fromObject(list);
		myJson.setFlag(MyJson.ANSWER_OK);
		myJson.setJson(json);
		return myJson;
	}
	
	
	/**
	 * 通过id得到具体页面
	 * @author zouyu
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="findevalpage.do")
	public ConJson findvalpage(@RequestParam String id){

		ConJson cJson = new ConJson();
		Evaluate e = evaluateDaService.selectByPrimaryKey(Integer.valueOf(id));
		
		UserExample uExample = new UserExample();
		uExample.createCriteria().andIdEqualTo(e.getUserId());
		List<User> uList = userDaService.selectByExample(uExample);
		for (User u:uList){
			cJson.setAge(u.getAge());
			cJson.setMap(u.getCity());
			cJson.setSex(u.getSex());
		}
		cJson.setPress_describe(e.getPressDescribe());
		cJson.setRate_describe(e.getRateDescribe());
		cJson.setScore(Integer.valueOf(e.getScore()));
		cJson.setTem_describe(e.getTemDescribe());
		cJson.setTime(df.format(e.getEvaluateTime()));
		cJson.setUser_press_h(e.getPressH());
		cJson.setUser_press_l(e.getPressL());
		cJson.setUser_rate(e.getRate());
		cJson.setUser_tem(e.getTem());
		cJson.setUser_id(e.getUserId());
		return cJson;
	}
	
	
	
	
	
	/**
	 * 处理函数handle
	 * @author zouyu
	 * @param flag
	 */
	private void temdeal(String flag){
		List<TemDescribe> temDescribes = new ArrayList<TemDescribe>();
		tDesExample.createCriteria().andStatusEqualTo(flag);
    	temDescribes =  tdesDaService.selectByExample(tDesExample);
    	for(TemDescribe t : temDescribes){
    		eJson.setTem_describe(t.getDescription());
    		tdescribleString = t.getDescription();
    	}
	}
	private void ratedeal(String flag){
		List<RateDescribe> rateDescribes = new ArrayList<RateDescribe>();
		rDesExample.createCriteria().andStatusEqualTo(flag);
		rateDescribes = rdesDaService.selectByExample(rDesExample);
		for(RateDescribe r:rateDescribes){
			eJson.setRate_describe(r.getDescription());
			rdescribleString = r.getDescription();
		}
		
	}
	private void pressdeal(String flag){
		List<PressDescribe> pressDescribes = new ArrayList<PressDescribe>();
		pDesExample.createCriteria().andStatusEqualTo(flag);
		pressDescribes = pdesDaService.selectByExample(pDesExample);
		for(PressDescribe p:pressDescribes){
			eJson.setPress_describe(p.getDescription());
			pdescribleString = p.getDescription();
		}
	}
}

/** 
* @date:2017年7月25日 
* @author:zouyu
*/ 