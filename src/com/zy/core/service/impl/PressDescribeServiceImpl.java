package com.zy.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.core.dao.EvaluateMapper;
import com.zy.core.dao.PressDescribeMapper;
import com.zy.core.dao.PressMapper;
import com.zy.core.dao.TemDescribeMapper;
import com.zy.core.dao.TemMapper;
import com.zy.core.model.Evaluate;
import com.zy.core.model.EvaluateExample;
import com.zy.core.model.Press;
import com.zy.core.model.PressDescribe;
import com.zy.core.model.PressDescribeExample;
import com.zy.core.model.PressExample;
import com.zy.core.model.Tem;
import com.zy.core.model.TemDescribe;
import com.zy.core.model.TemDescribeExample;
import com.zy.core.model.TemExample;
import com.zy.core.service.DaService;

@Service("pressdescribeService")
public class PressDescribeServiceImpl implements DaService<PressDescribe,PressDescribeExample>{

	@Autowired
	private PressDescribeMapper pMapper;

	@Override
	public int countByExample(PressDescribeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(PressDescribeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(PressDescribe record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertByExample(PressDescribeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(PressDescribe record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PressDescribe> selectByExample(PressDescribeExample example) {
		return pMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public PressDescribe selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(PressDescribe record,
			PressDescribeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(PressDescribe record,
			PressDescribeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(PressDescribe record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(PressDescribe record) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
}

/** 
* @date:2017年7月8日 
* @author:zouyu
*/ 