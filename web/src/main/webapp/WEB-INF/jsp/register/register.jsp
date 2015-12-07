<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link href="/statics/images/base.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="images/html5shiv.js"></script>
<![endif]-->
</head>
<body>
<div class="login_top_btn"><a class="btn" href="register.html">新用户注册</a></div>
<section class="reg_box">
	<form class="login-form" action="#" method="post">
                   		<div class="logo_icon"></div>
						<div class="logo_text">【会员登录】</div>
       <div class="form_body">
          <div class="control-group">
            <label class="control-label" for="username">用户名</label>
            <div class="controls">
              <input type="text" id="username" class="span3" placeholder="请输入用户名" nullmsg="请填写用户名" value="" name="username">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="inputPassword">密 码</label>
            <div class="controls">
              <input type="password" id="inputPassword"  class="span3" placeholder="请输入密码" nullmsg="请填写密码" name="password">
            </div>
          </div>     
          <div class="control-group">
          	<label class="control-label">&nbsp;</label>
            <div class="controls">
              <button type="submit" class="btn btn-large">登 录</button>
            </div>
          </div>
      </div>
    </form>
</section>
</body>
</html>