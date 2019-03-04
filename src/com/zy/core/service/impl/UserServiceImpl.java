package com.zy.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.core.dao.TemMapper;
import com.zy.core.dao.UserMapper;
import com.zy.core.model.Tem;
import com.zy.core.model.TemExample;
import com.zy.core.model.User;
import com.zy.core.model.UserExample;
import com.zy.core.service.DaService;

@Service("userService")
public class UserServiceImpl implements DaService<User, UserExample>{

	@Autowired
	private UserMapper user;

	@Override
	public int countByExample(UserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(UserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(User record) {
		return user.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> selectByExample(UserExample example) {
		
		return user.selectByExample(example);
	}

	@Override
	public User selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(User record, UserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(User record, UserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(User record) {

		return user.updateByPrimaryKey(record);
	}

	@Override
	public int insertByExample(UserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}

/** 
* @date:2017年7月8日 
* @author:zouyu
*/ 