package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.ding;
import com.model.huo;
import com.model.yonghu;
import com.service.IUserService;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@RequestMapping(value = "/add",produces="text/html;charset=UTF-8;")  
	@ResponseBody
	//增加货物
	public String add(Model model, HttpServletRequest request, Integer wid,String wname, Double wprice,String wxing,String wuse,String wyid) {
		System.out.println(wid);
		System.out.println(wname);
		System.out.println(wprice);
		System.out.println(wxing);
		System.out.println(wuse);
		System.out.println(wyid);
		huo c=new huo(wname,wprice,wxing,wuse,wyid);
		if(userService.add(c))
		{     	  
            return "true";
          }

	   else{
		   return "false";
        }
	}
	
	@RequestMapping(value = "/update" ,produces="text/html;charset=UTF-8;")  
	@ResponseBody
	//修改货物
	public String update(Model model, HttpServletRequest request,Integer wid,String wname, Double wprice,String wxing,String wuse) {
		System.out.println(wid);
		System.out.println(wname);
		System.out.println(wprice);
		System.out.println(wxing);
		System.out.println(wuse);
		//System.out.println(wyid);
		huo c=new huo(wid,wname,wprice,wxing,wuse);
		if(userService.update(c))
		{     	  
            return "true";
          }

	   else{
		   return "false";
        }
	}
	@RequestMapping(value = "/delete",produces="text/html;charset=UTF-8;")
	@ResponseBody
	//删除货物

	public String delete(Model model, HttpServletRequest request,Integer wid) {
		System.out.println(wid);
		if(userService.delete(wid))
		{     	  
            return "true";
          }

	   else{
		   return "false";
        }
	}
		

	@RequestMapping(value = "/huocha",produces="text/html;charset=UTF-8;")
	@ResponseBody
	//查询所有的货物
	public String huoqueryAll(Model model, HttpServletRequest request,huo huo) {
		List<huo> list=userService.huoqueryAll();
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json.toString());
		return json.toString(); 
	}
	
	@RequestMapping(value = "/gehuocha",produces="text/html;charset=UTF-8;")
	@ResponseBody
	//查询个人的货物
	public String gehuoqueryAll(Model model, HttpServletRequest request,huo huo,String wyid) {
		List<huo> list=userService.gehuoqueryAll(wyid);
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json.toString());
		return json.toString(); 
	}
	
	@RequestMapping(value = "/yonghucha",produces="text/html;charset=UTF-8;")
	@ResponseBody
	//查询个人的信息
	public String yonghuqueryAll(Model model, HttpServletRequest request,yonghu yong,String yid) {
		List<yonghu> list=userService.yonghuqueryAll(yid);
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json.toString());
		return json.toString(); 
	}
	
	@RequestMapping(value = "/dingcha",produces="text/html;charset=UTF-8;")
	@ResponseBody
	//查询个人订单
	public String dingqueryAll(Model model, HttpServletRequest request,ding ding,String dbuy) {
		List<ding> list=userService.dingqueryAll(dbuy);
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json.toString());
		return json.toString(); 
	}
	
	//用户
		@RequestMapping(value = "/yadd" ,produces="text/html;charset=UTF-8;")  
		@ResponseBody
		//用户注册
		public String yadd(Model model, HttpServletRequest request,String yid,String yname, Integer yphone, String yadress) {
			System.out.println(yid);
			System.out.println(yname);
			System.out.println(yphone);
			System.out.println(yadress);
			yonghu c=new yonghu(yid,yname,yphone,yadress);
			if(userService.yadd(c))
			{     	  
	            return "true";
	          }

		   else{
			   return "false";
	        }
		}
		
		@RequestMapping(value = "/chayong" ,produces="text/html;charset=UTF-8;")
		@ResponseBody
		//查询用户是否存在
		 public String checkGuan(Model model,HttpServletRequest request ,yonghu yong,String yid,String yname){
			System.out.println(yid);
			System.out.println(yname);
			yonghu c=new yonghu(yid,yname);
			if(userService.cun(c))
			{     	  
	            return "true";
	          }

		   else{
			   return "false";
	        }
		}
		
		@RequestMapping(value = "/buy" ,produces="text/html;charset=UTF-8;")
		@ResponseBody
		//增加订单
		 public String checkGuan(Model model,HttpServletRequest request ,Integer wid,String yid,String dmoney,String dwan){
			System.out.println(wid);
			System.out.println(yid);
			System.out.println(dmoney);
			System.out.println(dwan);
			dmoney=userService.buyname(wid);
			System.out.println(dmoney);
			ding c=new ding(yid,dmoney);
			if(userService.buyadd(c))
			{     	  
	            return "true";
	          }

		   else{
			   return "false";
	        }
		}
		
}
