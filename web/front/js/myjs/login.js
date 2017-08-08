function login(){
	/*var data = $("form").serialize();
	console.log(data);*/
	var data = $("#loginForm").serialize();
	jQuery.ajax({
		url:Consts.PATH+"/user/loginIn",
		type: "GET",
		data:data,
		dataType: "json",
		success: function(data){
			if(data.status==Consts.SUCCESS){
				//请求跳转
				window.location.href=Consts.PATH;
			}else{
				//打印信息
				alert(data.info);
			}
	   }
	});
}

