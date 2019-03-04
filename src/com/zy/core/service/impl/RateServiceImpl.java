package com.zy.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.core.dao.RateMapper;
import com.zy.core.model.Rate;
import com.zy.core.model.RateExample;
import com.zy.core.service.DaService;

@Service("rateService")
public class RateServiceImpl implements DaService<Rate,RateExample>{

	@Autowired
	private RateMapper rate;
	
	@Override
	public int countByExample(RateExample example) {
		
		return rate.countByExample(example);
	}

	@Override
	public int deleteByExample(RateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Rate record) {
		
		return rate.insert(record);
	}

	@Override
	public int insertSelective(Rate record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Rate> selectByExample(RateExample example) {
		return rate.selectByExample(example);
	}

	@Override
	public Rate selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(Rate record, RateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Rate record, RateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Rate record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Rate record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertByExample(RateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}

/** 
* @date:2017年7月8日 
* @author:zouyu
*/ 