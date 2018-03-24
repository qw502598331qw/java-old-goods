$.displayorder1 = function(){
	for(var i = 0;i<orderList.length;i++){
		$("#order-table").append("<tr>" +
				//"<td class=text-center>"+(i+1)+"</td>" +
				"<td class=text-center>"+orderList[i].wid+"</td>" +
				"<td class=text-center>"+orderList[i].wname+"</td>" +
				"<td class=text-center>"+orderList[i].wprice+"</td>" +
				"<td class=text-center>"+orderList[i].wxing+"</td>" +
				"<td class=text-center>"+orderList[i].wuse+"</td>" +
				"<td class=text-center><a href='javascript:void(0);' onclick=addgoodstocar("+orderList[i].wid+")>购买&nbsp;&nbsp </a>" +
				"</tr>")
	}
};

//<a href='javascript:void(0);' onclick=seegoods("+orderList[i].goodsID+")>查看详情</a>"
$.displayorder2 = function(){
	for(var i = 0;i<orderList.length;i++){
		$("#Book-table").append("<tr>" +
				//"<td class=text-center>"+(i+1)+"</td>" +
				"<td class=text-center>"+orderList[i].wid+"</td>" +
				"<td class=text-center>"+orderList[i].wname+"</td>" +
				"<td class=text-center>"+orderList[i].wprice+"</td>" +
				"<td class=text-center>"+orderList[i].wxing+"</td>" +
				"<td class=text-center>"+orderList[i].wuse+"</td>" +
				"</tr>")
	}
};
/*
$.ajax({
	url:"user/huocha",
	type:"post",
	datatype:"json",
	success:function(data){
		orderList=JSON.parse(data);
		$.displayorder1();
	},
	error:function(){alert("error!");},
});
*/
//得到自己信息
function getmyxinxi(){
	

	var thisURL = document.URL;    
	var  getval =thisURL.split('?')[1];  
	var name= getval.split("=")[1];  
	//alert(name);
	document.getElementById('editUsername').value=name;  
	$.ajax({
		url:"user/yonghucha",
		type:"post",
		datatype:"json",
		data:{
			"yid":name
		},
		success:function(data){
			//alert(data);
			$("#getAllGoods").hide();
			$("#findGood2").hide();
			$("#editMyxinxi").show();
			$("#editgoodsxinxi").hide();
			$("#getBuyGoodsjilu").hide();
			$("#sellGoods").hide();
			$("#getbuycar").hide();
			$("#buygoodsxinxi").hide();
			$("#selledgoodsxinxi").hide();
			for(var i = 0;i<JSON.parse(data).length;i++){
			document.getElementById("editUsername").value=JSON.parse(data)[i].yid;
			document.getElementById("editPhone").value=JSON.parse(data)[i].yphone;
			document.getElementById("editAddress").value=JSON.parse(data)[i].yaddress;
			}
		},
		error:function(){
			alert("error!");},
	});
}

//寻找物品

	var thisURL = document.URL;    
	var  getval =thisURL.split('?')[1];  
	var name= getval.split("=")[1];  
	//alert(name);
	$.ajax({
		url:"user/gehuocha",
		type:"post",
		datatype:"json",
		data:{
			"wyid":name
		},
		success:function(data){
			//alert(data);
			orderList=JSON.parse(data);
			$.displayorder2();
		},
		error:function(){alert("error!");},
	});
function findGood1(){
	
	var thisURL = document.URL;    
	var  getval =thisURL.split('?')[1];  
	var name= getval.split("=")[1];  
	//alert(name);
	$.ajax({
		url:"user/gehuocha",
		type:"post",
		datatype:"json",
		data:{
			"wyid":name
		},
		success:function(data){
			//alert(data);
			$("#Book-table tr").eq(0).nextAll().remove();
			orderList=JSON.parse(data);
			$.displayorder2();
			$("#getAllGoods").hide();
			$("#findGood2").show();
			$("#editMyxinxi").hide();
			$("#editgoodsxinxi").hide();
			$("#getBuyGoodsjilu").hide();
			$("#sellGoods").hide();
			$("#getbuycar").hide();
			$("#buygoodsxinxi").hide();
			$("#selledgoodsxinxi").hide();
		},
		error:function(){alert("error!");},
	});
}

function myrefresh()
{
	  window.location.reload();
}
//增加方法
function insertBook(){
	$("#getAllGoods").hide();
	$("#findGood2").show();
	$("#editMyxinxi").hide();
	$("#editgoodsxinxi").hide();
	$("#getBuyGoodsjilu").hide();
	$("#sellGoods").hide();
	$("#getbuycar").show();
	$("#buygoodsxinxi").hide();
	$("#selledgoodsxinxi").hide();
	
}
function insertBook1(){
	var thisURL = document.URL;    
	var  getval =thisURL.split('?')[1];  
	var name= getval.split("=")[1]; 
	//alert(name);
	$.ajax({
		url:"user/add",
		data:{
			"wname":document.getElementById("Goodsname").value,
			"wprice":document.getElementById("Goodsprice1").value,
			"wxing":document.getElementById("Username1").value,
			"wuse":document.getElementById("data1").value,
			"wyid":name,
		},
		type:"post",
		success:function(data){
			if(data=="true")
				{
					alert("增加成功！");
				}
			else{
				alert("增加失败！");
			}
	
		},
		error:function(){
			alert("error!");},
	});
	
}
//删除方法
function deleteBook(){
	$.ajax({
		url:"user/delete",
		data:{
			"wid":document.getElementById("deleteGoodsname").value
			},
		type:"post",
		success:function(data){
			if(data=="true")
				{
					alert("删除成功！");
				}
			else{
				alert("删除失败！");
			}
		},
		error:function(){
			alert("error!");},
	});
	
}
//修改方法
function updateBook(){
	$("#getAllGoods").hide();
	$("#findGood2").show();
	$("#editMyxinxi").hide();
	$("#editgoodsxinxi").show();
	$("#getBuyGoodsjilu").hide();
	$("#sellGoods").hide();
	$("#getbuycar").hide();
	$("#buygoodsxinxi").hide();
	$("#selledgoodsxinxi").hide();
}
function updateBook1(){
	$.ajax({
		url:"user/update",
		data:{
			"wid":document.getElementById("id").value,
			"wname":document.getElementById("name").value,
			"wprice":document.getElementById("price1").value,
			"wxing":document.getElementById("name1").value,
			"wuse":document.getElementById("ta1").value,
			},
		type:"post",
		success:function(data){
			if(data=="true")
				{
				alert("修改成功！");
				}
			else{
				alert("修改失败！");
			}
		},
		error:function(){
			alert("error!");},
	});
	
}

//获取所有物品信息
function getallGoods(){
	$.ajax({
		url:"user/huocha",
		type:"post",
		datatype:"json",
		success:function(data){
			$("#order-table tr").eq(0).nextAll().remove(); //除第0行外，全部删除其它行。。
			orderList=JSON.parse(data);
			$.displayorder1();
			$("#getAllGoods").show();
			$("#editMyxinxi").hide();
			$("#findGood2").hide();
			$("#editgoodsxinxi").hide();
			$("#getBuyGoodsjilu").hide();
			$("#sellGoods").hide();
			$("#getbuycar").hide();
			$("#buygoodsxinxi").hide();
			$("#selledgoodsxinxi").hide();
		},
		error:function(){alert("error!");},
	});
}

function addgoodstocar(t){
	var thisURL = document.URL;    
	var  getval =thisURL.split('?')[1];  
	var name= getval.split("=")[1]; 
	//alert(t);
	var r=confirm("确定购买?");	
	if(r==true){
		$.ajax({
			url:"user/buy",
			type:"post",
			data:{
				"wid":t,
				"yid":name
				  },
			datatype:"json",
			success:function(data){
		
				if(data=="true"){
					alert("购买成功！");
					window.location.reload(); 
					
				}else{
					alert("购买失败！");}
				
			},
			error:function(){
				alert("error!");},
		});
		
	}else
		return;
}

