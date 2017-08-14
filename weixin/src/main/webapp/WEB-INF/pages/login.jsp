<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>用户登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width,initial-scale=1"/>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/login.css">
<script src="js/jquery-1.9.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<!--[if lt IE 9]>
	<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
<script>
	$(function(){ 
		$(".container").css("position","fixed").css("top",($(window).height()-$(".container").height())/2)
		.css("left",($(window).width()-$(".container").width())/2);
		
		$('.close-button').click(function(){
			$(this).parent().removeClass("slidePageInFromLeft").addClass("slidePageBackLeft");
		});
		
		$(window).resize(function(){
			$(".container").css("position","fixed").css("top",($(window).height()-$(".container").height())/2)
			.css("left",($(window).width()-$(".container").width())/2);
		});
			
	});
	
	function login(id,role) {
    	var flag = $("#"+id).text();
    	$("#"+role).val(flag);
	}
	
	function backlogin(){
		$(".register-page").removeClass("slidePageInFromLeft").addClass("slidePageBackLeft");
	}
		
</script>
</head>

<body>
	<div class="container">
		<div class="row">
            <div class="col-md-5 col-md-offset-3">
            	<div class="panel">
                	<div class="panel-heading login-top">用户登录</div>
                    <div class="panel-body">
                    	<form class="form-group col-lg-10 col-md-offset-1" action="admin_login.action" method="post" role="form">
                			<div class="input-group">
								<div class="input-group-btn">
									<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">角&nbsp;&nbsp;色<span class="caret"></span></button>
									<ul class="dropdown-menu">
										<c:forEach items="${adminTypeList }" var="admintype">
											<li><a id="${admintype.typeid }" href="javascript:login('${admintype.typeid }','typename')">${admintype.typename }</a></li>
										</c:forEach>
									</ul>
								</div>
								<input id="typename" type="text" class="form-control" disabled="disabled" required placeholder="请选择角色"/>						
									<label class="input-group-addon"><a href="" class="errorinfo">忘记密码...</a></label>
							</div>
                            <br />
                            <div class="input-group">
                            	<label for="uname" class="input-group-addon">用户名</label>
                                <input type="text" class="form-control" name="aname" id="aname" required placeholder="请输入用户名"/>
                            </div>
                            <br />
                            <div class="input-group">
                            	<label for="pwd" class="input-group-addon">密&nbsp;&nbsp;&nbsp;码</label>
                                <input type="password" class="form-control" name="apwd" id="apwd" required  placeholder="请输入密码"/>
                            </div>
                            <br />
                            <div class="input-group">
                            	<label for="vcode" class="input-group-addon">验证码</label>
                                <input type="text" style="font-size: 14px;width: 180px;height: 30px" name="vcode" id="vcode" required placeholder="  请输入右边的验证码"/>
                                <img src="image.jsp" onclick="changeVilidateCode(this)" border="0" title="点击图片刷新验证码" size="10"/>
                            </div>
                            <br/>
                            <div class="input-group">
                            	<input type="submit" value="登陆" class="btn btn-success mybtn"/>
                                <input type="reset" value="重置" class="btn btn-warning mybtn"/>
                            </div>
                            <br/>
                			<div id="result">${errormsg }</div>
                		</form>
                    </div>
                    <div class="panel-footer login-footer">源辰信息 &copy; 版权所有</div>
                </div>
            </div>
            <div class="col-md-2"></div>
        </div>
	</div>
</body>
</html>
