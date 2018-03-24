function gotochange(){
	var yid=document.getElementById("user").value;
	var yname=document.getElementById("pwd").value;
	//alert(yid);
	var  getval =document.getElementById("user").value;
alert(getval);  
	$.ajax({
		url:"user/chayong",
		data:{"yid":yid,
			  "yname":yname},
		type:"post",
		success:function(data){
			if(data=="true"){
				
				document.location.href("main.html?name="+getval);
			}else{
				alert("用户名密码错误");
			}	
		},
		error:function(data){
			alert("系统出错")
		}
	})

}
function gotoset(){
	var yid=document.getElementById("newname").value;
	var yname=document.getElementById("newpwd").value;
	var yphone=document.getElementById("newphone").value;
	var yadress=document.getElementById("newaddress").value;
	$.ajax({
		url:"user/yadd",
		data:{"yid":yid,
			  "yname":yname,
			  "yphone":yphone,
			  "yadress":yadress},
		type:"post",
		success:function(data){
		
			if(data=="true"){
					alert("注册成功，返回登入");
				window.location.href = "index.html"
			}else{
				alert("注册失败");
			}
			
		},
		error:function(data){
			alert("系统出错")
		}
	})

}