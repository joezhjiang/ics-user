<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>用户详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<!-- Bootstrap -->
<link href="<s:url value='/css/bootstrap.min.css' />" rel="stylesheet"
	media="screen">
<link href="<s:url value='/css/zTreeStyle/zTreeStyle.css' />"
	rel="stylesheet" media="screen">
<link href="<s:url value='/css/common.css' />" rel="stylesheet"
	media="screen">

</head>

<body>

	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel">Modal header</h3>
	</div>
	<div class="modal-body">
		<form id="addForm" class="form-horizontal" action="addUser.action" method="get">
			<div class="control-group">
				<label class="control-label" for="username">用户名</label>
				<div class="controls">
					<s:textfield id="username" name="user.username"
						placeholder="username" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="password">密码</label>
				<div class="controls">
					<s:textfield id="password" name="user.password"
						placeholder="password" />
				</div>
			</div>
		</form>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
		<button id="btnSubmit" class="btn btn-primary">Save changes</button>
	</div>
	<script src="<s:url value='/js/jquery-1.10.2.min.js' />"></script>
	<script src="<s:url value='/js/bootstrap.min.js' />"></script>
	<script src="<s:url value='/js/jquery.ztree.all-3.5.js' />"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnSubmit").click( function () {
				$("#addForm").submit();
			});
		});
	</script>
</body>
</html>
