package com.zy.core.controller;

import java.awt.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSON;

import org.springframework.stereotype.Controller;
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
import com.zy.core.model.User;
import com.zy.core.model.UserExample;
import com.zy.core.service.DaService;
import com.zy.util.LoginJson;
import com.zy.util.MyJson;
import com.zy.util.UserJson;

@Controller
@RequestMapping("user/")
public class UserController {

	@Resource(name="userService")
	private DaService<User,UserExample> userDaService;
	@Resource(name="temService")
	private DaService<Tem, TemExample> temDaService;
	@Resource(name="pressService")
	private DaService<Press,PressExample> pressDaService;
	@Resource(name="rateService")
	private DaService<Rate,RateExample> rateDaService;
	
	
	
	@ResponseBody
	@RequestMapping(value="changeid.do")
	public JSON changeid(@RequestParam String id){
		
		UserExample uExample = new UserExample();
		uExample.createCriteria().andIdEqualTo(id);
		java.util.List<User> users = new ArrayList<User>();
		users = userDaService.selectByExample(uExample);
		String usergroup[] = null;
		
		for (User u:users){
			usergroup = u.getUserId().split(",");
		}
		
		net.sf.json.JSONArray json = net.sf.json.JSONArray.fromObject(usergroup);
		
		return json;
	}
	
	
	
	
	/**
	 * 用户自己登陆完善信息
	 * @author zouyu
	 * @param id
	 * @param map
	 * @param img
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="setinfo.do",method=RequestMethod.GET)
	public String setinfo(@RequestParam String id,
			@RequestParam String map,@RequestParam String img){
		
		UserExample usExample = new UserExample();
		usExample.createCriteria().andIdEqualTo(id);
		java.util.List<User> uList = new ArrayList<User>();
		uList = userDaService.selectByExample(usExample);
		User user = new User();
		for(User u:uList){
			user.setAge(u.getAge());
			user.setCity(map);
			user.setImg(img);
			user.setId(id);
			user.setNo(u.getNo());
			user.setPwd(u.getPwd());
			user.setSex(u.getSex());
			user.setRelation(u.getRelation());
			user.setUserId(u.getUserId());
			user.setPhone(u.getPhone());
		}
		int i=userDaService.updateByPrimaryKey(user);
		System.out.println(i);
		return "success";
	}
	
	
	
	/**
	 * 硬件登陆接口
	 * @author zouyu
	 * @param id
	 * @param pwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="Login.do",method=RequestMethod.GET)
	public String login(@RequestParam String id,@RequestParam String pwd){
		
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserIdEqualTo(id).andPwdEqualTo(pwd);
		if (userDaService.selectByExample(userExample).size() == 0) {
			return "fail";
		}
		return "loginsuccess";
	}
	
	/**
	 * 硬件注册接口
	 * @author zouyu
	 * @param id
	 * @param pwd
	 * @param user_id
	 * @param age
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="Register.do",method=RequestMethod.GET)
	public String register(@RequestParam String id,@RequestParam String pwd,
			@RequestParam String user_id,@RequestParam int age,
			@RequestParam String phone,@RequestParam String relation,
			@RequestParam String sex){

		User u = new User();
			u.setAge(age);
			u.setCity(null);
			u.setId(id);
			u.setImg(null);
			u.setPhone(phone);
			u.setPwd(pwd);
			u.setRelation(relation);
			if(sex.equals("0")){
				u.setSex("女");
			}else {
				u.setSex("男");
			}
			u.setUserId(user_id);
		userDaService.insert(u);
		
		return "loginsuccess";
	}
	
	
	
	/**
	 * 微信小程序登录验证
	 * @author zouyu
	 * @param id
	 * @param pwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="login.do",method=RequestMethod.GET)
	public LoginJson getData(@RequestParam String id,
			@RequestParam String pwd){
		
		LoginJson loginJson = new LoginJson();
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String relation=null;
		
		UserExample usExample = new UserExample();
		usExample.createCriteria().andIdEqualTo(id).andPwdEqualTo(pwd);
		java.util.List<User> ulist = userDaService.selectByExample(usExample);
		
		String useridGroup[] = null;
		String userphone[] = null;
		if(ulist != null && ulist.size()>0){
			for(User u : ulist){
				useridGroup = u.getUserId().split(",");
				relation = u.getRelation();
				
				UserExample uExample = new UserExample();
				java.util.List<User> users = userDaService.selectByExample(uExample);
				loginJson.setPhone(null);
				for(User us:users){
					userphone = us.getUserId().split(",");
					for (int j = 0; j < userphone.length; j++) {
						if (userphone[j].equals(id) && us.getRelation().equals("0")) {
							loginJson.setPhone(us.getPhone());
						}
					}
				}
			}
		}
		
		
		java.util.List<Map> list = new ArrayList<Map>();
		
		for (int i = 0; i < useridGroup.length; i++) {
			
			Map<String,String> map = new HashMap<String,String>();
			UserExample userExample = new UserExample();
			userExample.createCriteria().andIdEqualTo(useridGroup[i]);
			java.util.List<User> users = new ArrayList<User>();
			users = userDaService.selectByExample(userExample);
			for(User u:users){
				map.put("age", u.getAge().toString());
				map.put("user_id", u.getUserId());
				map.put("bimg", u.getImg());
			}
			
			//get tem data
			TemExample temExample = new TemExample();
			temExample.createCriteria().
				andUserIdEqualTo(useridGroup[i]);
			java.util.List<Tem> tlist =  temDaService.selectByExample(temExample);
			
			if(tlist != null && tlist.size()>0){
					map.put("tem", String.valueOf((Double.parseDouble(tlist.get(tlist.size()-1).getTem())/100)));
					map.put("user_tem",String.valueOf((Double.parseDouble(tlist.get(tlist.size()-1).getUserTem())/100)));
					map.put("tem_time",df.format(tlist.get(tlist.size()-1).getTime()));
			}
			
			//get press data
			PressExample pExample = new PressExample();
			pExample.createCriteria().
				andUserIdEqualTo(useridGroup[i]);
			java.util.List<Press> plist = pressDaService.selectByExample(pExample);
			if(plist != null && plist.size()>0){
				map.put("user_press_h",plist.get(plist.size()-1).getUserPressH().toString());
				map.put("user_press_l",plist.get(plist.size()-1).getUserPressL().toString());
				map.put("press_time",df.format(plist.get(plist.size()-1).getTime()));
			}
			
			//get rate data
			RateExample rExample = new RateExample();
			rExample.createCriteria().
				andUserIdEqualTo(useridGroup[i]);
			java.util.List<Rate> rlist = rateDaService.selectByExample(rExample);
			if(rlist != null && rlist.size()>0){
				map.put("user_rate",rlist.get(rlist.size()-1).getUserRate().toString());
				map.put("rate_time",df.format(rlist.get(rlist.size()-1).getTime()));
			}
			list.add(map);
		}
		
		net.sf.json.JSONArray json = net.sf.json.JSONArray.fromObject(list);
		loginJson.setRelation(relation);
		loginJson.setJson(json);
		return loginJson;
	}
	
	
	
	
	
	
}

/** 
* @date:2017年7月13日 
* @author:zouyu
*/ 