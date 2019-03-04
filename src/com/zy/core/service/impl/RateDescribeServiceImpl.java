package com.zy.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.core.dao.EvaluateMapper;
import com.zy.core.dao.PressMapper;
import com.zy.core.dao.RateDescribeMapper;
import com.zy.core.dao.TemDescribeMapper;
import com.zy.core.dao.TemMapper;
import com.zy.core.model.Evaluate;
import com.zy.core.model.EvaluateExample;
import com.zy.core.model.Press;
import com.zy.core.model.PressExample;
import com.zy.core.model.RateDescribe;
import com.zy.core.model.RateDescribeExample;
import com.zy.core.model.Tem;
import com.zy.core.model.TemDescribe;
import com.zy.core.model.TemDescribeExample;
import com.zy.core.model.TemExample;
import com.zy.core.service.DaService;

@Service("ratedescribeService")
public class RateDescribeServiceImpl implements DaService<RateDescribe,RateDescribeExample>{

	@Autowired
	private RateDescribeMapper rMapper;

	@Override
	public int countByExample(RateDescribeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(RateDescribeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(RateDescribe record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertByExample(RateDescribeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(RateDescribe record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RateDescribe> selectByExample(RateDescribeExample example) {
		return rMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public RateDescribe selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(RateDescribe record,
			RateDescribeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(RateDescribe record, RateDescribeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(RateDescribe record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(RateDescribe record) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
}

/** 
* @date:2017年7月8日 
* @author:zouyu
*/ 