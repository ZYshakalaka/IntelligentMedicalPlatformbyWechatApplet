package com.zy.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.core.dao.PressMapper;
import com.zy.core.dao.TemMapper;
import com.zy.core.model.Press;
import com.zy.core.model.PressExample;
import com.zy.core.model.Tem;
import com.zy.core.model.TemExample;
import com.zy.core.service.DaService;

@Service("pressService")
public class PressServiceImpl implements DaService<Press,PressExample>{

	@Autowired
	private PressMapper press;

	@Override
	public int countByExample(PressExample example) {
		
		return press.countByExample(example);
	}

	@Override
	public int deleteByExample(PressExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Press record) {
		
		return press.insert(record);
	}

	@Override
	public int insertSelective(Press record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Press> selectByExample(PressExample example) {
		
		return press.selectByExample(example);
	}

	@Override
	public Press selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(Press record, PressExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Press record, PressExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Press record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Press record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertByExample(PressExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}

/** 
* @date:2017年7月8日 
* @author:zouyu
*/ 