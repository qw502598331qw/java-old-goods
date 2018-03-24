package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.UserMapper;
import com.model.ding;
import com.model.huo;
import com.model.yonghu;
import com.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{
	@Autowired
	UserMapper userMapper;
	private int result;
	@Override
	public boolean add(huo huo) {
	result = userMapper.save(huo);
	if (result > 0) 
	{
	return true;
	}	
	return false;
	}
	
	@Override
	public boolean delete(Integer wid) {
	result = userMapper.delete(wid);
	if (result > 0) 
	{
	return true;
	}	
	return false;
	}

	@Override
	public boolean update(huo huo) {
	result = userMapper.update(huo);
	if (result > 0) 
	{
	return true;
	}	
	return false;
	}

	@Override
	public List<huo> huoqueryAll(){
		List<huo> users = userMapper.gethuo();
		return users;
	}
	
	@Override
	public List<yonghu> yonghuqueryAll(String yid){
		List<yonghu> users = userMapper.getgeren(yid);
		return users;
	}
	
	@Override
	public List<huo> gehuoqueryAll(String wyid){
		List<huo> users = userMapper.getgehuo(wyid);
		return users;
	}
	
	@Override
	public List<ding> dingqueryAll(String dbuy){
		List<ding> users = userMapper.getding(dbuy);
		return users;
	}
	
	
	//ÓÃ»§
	@Override
	public boolean yadd(yonghu yong) {
	result = userMapper.ysave(yong);
	if (result > 0) 
	{
	return true;
	}	
	return false;
	}
	
	@Override
	public boolean cun(yonghu yong) {
	result = userMapper.getcun(yong);
	if (result > 0) 
	{
	return true;
	}	
	return false;
}
	//¹ºÂò
	@Override
	public String buyname(Integer wid) {
	String gou;
	gou= userMapper.buyname(wid);
	return gou;		
	}
	
	@Override
	public boolean buyadd(ding ding) {
	result = userMapper.buysave(ding);
	if (result > 0) 
	{
	return true;
	}	
	return false;
	}
	
}