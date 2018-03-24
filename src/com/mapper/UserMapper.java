package com.mapper;
import java.util.List;

import com.model.ding;
import com.model.huo;
import com.model.yonghu;
public  interface UserMapper{
	//用户
		public int ysave(yonghu yong);
	//	
		public int getcun(yonghu yong);

	//个人货物
		public List<yonghu> getgeren(String yid);
		
		// 查询全部用户信息
		public List<huo> getgehuo(String wyid);
		
		// 添加一条用户信息	
		public int save(huo huo);
		
		// 删除一条用户信息
		public int delete(Integer wid);
		
		// 修改一条用户信息
		public int update(huo huo);
		

	
	//购买
		public List<huo> gethuo();
		
		public int buysave(ding ding);
		
		public String buyname(Integer wid);
	//订单
		
		public List<ding> getding(String dbuy);
	

	
}
