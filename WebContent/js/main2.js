$.displayorder3 = function(){
	for(var i = 0;i<orderList3.length;i++){
		$("#yijingbuy-table").append("<tr>" +
				//"<td class=text-center>"+(i+1)+"</td>" +
				"<td class=text-center>"+orderList3[i].did+"</td>" +
				"<td class=text-center>"+orderList3[i].dbuy+"</td>" +
				"<td class=text-center>"+orderList3[i].dmoney+"</td>" +
				//"<td class=text-center>"+orderList3[i].dwan+"</td>" +
				//"<td class=text-center><a href='javascript:void(0);' onclick=seeyijingbuygoods("+orderList3[i].goodsID+")>查看详情</a>" +
				"</tr>")
	}
};

function getBuyjilv(){
	var thisURL = document.URL;    
	var  getval =thisURL.split('?')[1];  
	var name= getval.split("=")[1];  
	//alert(name);
	
	$("#getAllGoods").hide();
	$("#findGood2").hide();
	$("#editMyxinxi").hide();
	$("#editgoodsxinxi").hide();
	$("#getBuyGoodsjilu").show();
	$("#sellGoods").hide();
	$("#getbuycar").hide();
	$("#buygoodsxinxi").hide();
	$("#selledgoodsxinxi").hide();
	
	$.ajax({
		url:"user/dingcha",
		type:"post",
		datatype:"json",
		data:{
			"dbuy":name
		},
		success:function(data){		
			//alert(data);
			$("#yijingbuy-table tr").eq(0).nextAll().remove();
			orderList3=JSON.parse(data);
			$.displayorder3();
		},
		error:function(){alert("error!");},
	});
}

