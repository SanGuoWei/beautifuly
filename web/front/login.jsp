<%@page import="com.jfinal.template.stat.ast.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html class="login-bg">
<head>
	<title>登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%@include file="./share/layout-heard.jsp" %>
</head>
<body>


    <!-- background switcher -->
    <div class="bg-switch visible-desktop">
        <div class="bgs">
            <a href="#" data-img="landscape.jpg" class="bg active">
                <img src="${ctx}/front/img/bgs/landscape.jpg" />
            </a>
            <a href="#" data-img="blueish.jpg" class="bg">
                <img src="${ctx}/front/img/bgs/blueish.jpg" />
            </a>            
            <a href="#" data-img="7.jpg" class="bg">
                <img src="${ctx}/front/img/bgs/7.jpg" />
            </a>
            <a href="#" data-img="8.jpg" class="bg">
                <img src="${ctx}/front/img/bgs/8.jpg" />
            </a>
            <a href="#" data-img="9.jpg" class="bg">
                <img src="${ctx}/front/img/bgs/9.jpg" />
            </a>
            <a href="#" data-img="10.jpg" class="bg">
                <img src="${ctx}/front/img/bgs/10.jpg" />
            </a>
            <a href="#" data-img="11.jpg" class="bg">
                <img src="${ctx}/front/img/bgs/11.jpg" />
            </a>
        </div>
    </div>


    <div class="login-wrapper">
        <a href="index.html">
            <img class="logo" src="${ctx}/front/img/logo-white.png">
        </a>
		<form id="loginForm" action="${ctx}/user/loginIn">
			<div class="box">
	            <div class="content-wrap">
	                <h6>登录</h6>
	                <input class="form-control" type="text" name="username" placeholder="用户名">
	                <input class="form-control" type="password" name="password" placeholder="密码">
	                <a href="#" class="forgot">忘记密码?</a>
	                <div class="remember">
	                    <input id="remember-me" type="checkbox">
	                    <label for="remember-me">记住密码</label>
	                </div>
	                <a class="btn-glow primary login" href="javascript:void(0)" onclick="login()">登录</a>
	            </div>
	        </div>
		</form>
        

        <div class="no-account">
            <p>还没账号?</p>
            <a href="signup.html">注册</a>
        </div>
    </div>

	<!-- scripts -->
    <%@include file="./share/layout-js.jsp" %>
	<script src="${ctx}/front/js/myjs/login.js"></script>
    <!-- pre load bg imgs -->
    <script type="text/javascript">
        $(function () {
            // bg switcher
            var $btns = $(".bg-switch .bg");
            $btns.click(function (e) {
                e.preventDefault();
                $btns.removeClass("active");
                $(this).addClass("active");
                var bg = $(this).data("img");

                $("html").css("background-image", "url('img/bgs/" + bg + "')");
            });

        });
    </script>
</body>
</html>