package com.zy.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.core.dao.EvaluateMapper;
import com.zy.core.dao.PressMapper;
import com.zy.core.dao.TemDescribeMapper;
import com.zy.core.dao.TemMapper;
import com.zy.core.model.Evaluate;
import com.zy.core.model.EvaluateExample;
import com.zy.core.model.Press;
import com.zy.core.model.PressExample;
import com.zy.core.model.Tem;
import com.zy.core.model.TemDescribe;
import com.zy.core.model.TemDescribeExample;
import com.zy.core.model.TemExample;
import com.zy.core.service.DaService;

@Service("temdescribeService")
public class TemDescribeServiceImpl implements DaService<TemDescribe,TemDescribeExample>{

	@Autowired
	private TemDescribeMapper tMapper;

	@Override
	public int countByExample(TemDescribeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(TemDescribeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TemDescribe record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertByExample(TemDescribeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TemDescribe record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TemDescribe> selectByExample(TemDescribeExample example) {
		return tMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public TemDescribe selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(TemDescribe record,
			TemDescribeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(TemDescribe record, TemDescribeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(TemDescribe record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TemDescribe record) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
	
	
}

/** 
* @date:2017年7月8日 
* @author:zouyu
*/ 