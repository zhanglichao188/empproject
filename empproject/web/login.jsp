<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
		<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
		<script>
			$(function () {
				$("#loginsubmit").click(function () {
					$.post("${pageContext.request.contextPath}/login.action",{"code":$("#logincode").val(),"pwd":$("#loginpwd").val(),"flag":$("#loginauto").prop("checked")},function (data){
						if (data.message) {
							window.location.href="${pageContext.request.contextPath}/page/main/index.jsp";
						} else {
							alert("账号或密码错误！");
						}
					},"json");
				});
			});
		</script>
	</head>
	<body>
		<div class="bg"></div>
		<div class="container">
			<div class="line bouncein">
				<div class="xs6 xm4 xs3-move xm4-move">
					<div style="height:150px;"></div>
					<div class="media media-y margin-big-bottom">
					</div>
					<%--<form action="${pageContext.request.contextPath}/page/main/index.jsp" method="post">--%>
						<div class="panel loginbox" style="margin-top: -100px;">
							<div class="text-center margin-big padding-big-top">
								<h1>后台管理中心</h1>
							</div>
							<div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
								<div class="form-group">
									<div class="field field-icon-right">
										<input type="text" autofocus="autofocus" class="input input-big" name="name" id="logincode" value="${cookie.loginCode.value}" placeholder="登录账号" data-validate="required:请填写账号" />
										<span class="icon icon-user margin-small"></span>
									</div>
								</div>
								<div class="form-group">
									<div class="field field-icon-right">
										<input type="password" class="input input-big" name="password" id="loginpwd" value="${cookie.loginPwd.value}" placeholder="登录密码" data-validate="required:请填写密码" />
										<span class="icon icon-key margin-small"></span>
									</div>
								</div>
								<div class="form-group">
									<div class="field">
										<input type="text" class="input input-big" name="code" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
										<img src="images/passcode.jpg" alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;"
										 onclick="this.src=this.src+'?'">

									</div>
								</div>
								<div class="checkbox">
									<label style="font-family: 宋体;font-weight: bold;color: gray;">
										<input style="vertical-align: middle;" type="checkbox" id="loginauto" value="" checked="checked">
										两周内自动登录
									</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="#" data-toggle="modal" data-target="#myModal" style="font-style: italic;">没账号？点我注册</a>
								</div>
							</div>
							<div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" id="loginsubmit" value="登录"></div>
						</div>
					<%--</form>--%>
				</div>
			</div>
		</div>
		<!-- 注册弹出框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>
						<h4 class="modal-title" id="myModalLabel">新用户注册</h4>
					</div>
					<div class="modal-body">
						<form>
							<div class="form-group">
								<label>用户名</label>
								<input type="text" class="form-control" placeholder="请输入用户名">
							</div>
							<div class="form-group">
								<label>密码</label>
								<input type="password" class="form-control" placeholder="请输入密码">
							</div>
							<div class="form-group">
								<label>确认密码</label>
								<input type="password" class="form-control" placeholder="请输入确认密码">
							</div>

							<div class="form-group">
								<input type="submit" style="width: 100%;" class="btn btn-lg btn-success" data-dismiss="modal" value="注 册">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
