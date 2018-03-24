package com.service;

import java.util.List;
import com.model.ding;
import com.model.huo;
import com.model.yonghu;
public interface IUserService {
	
	//货物
	// 添加货物信息，需要加入huo里面6种属性
	public boolean add(huo huo);
	
	// 删除货物信息，需要wid
	public boolean delete(Integer wid);

	// 修改货物信息，需要修改huo6种属性
	public boolean update(huo huo);

	//查询个人用户信息，需要yid
	public List<yonghu> yonghuqueryAll(String yid);
	
	//查询所有的货物
	public List<huo> huoqueryAll();
	
	//查询个人发布的货物，需要yid
	public List<huo> gehuoqueryAll(String wyid);
	
	//查询个人订单，需要yid
	public List<ding> dingqueryAll(String dbuy);

	//添加用户信息，需要yonghu4种属性
	public boolean yadd(yonghu yong);
	
	//判断注册是否有重名，需要yonghu两种属性，yid与yname
	public boolean cun(yonghu yong);
	
	//购买
	//获得购买货物的名字，需要货物的wid
	public String buyname (Integer wid);
	
	//添加购买货物的订单，需要ding四种属性
	public boolean buyadd(ding ding);
	
	

}
