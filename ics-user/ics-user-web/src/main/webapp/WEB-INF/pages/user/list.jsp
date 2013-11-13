<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
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
	<div class="navbar navbar-inverse navbar-fixed-top ">
		<div class="row-fluid navbar-inner">
			<div class="span2 pl-10">
				<a class="brand" href="./index.html">ICS资源管理系统</a>
			</div>
			<div class="span10">
				<ul class="nav">
					<li class="active"><a href="./index.html">首页</a></li>
					<li class=""><a href="./index1.html">用户管理</a></li>
					<li class=""><a href="./scaffolding.html">角色管理</a></li>
					<li class=""><a href="./base-css.html">部门管理</a></li>
					<li class=""><a href="./components.html">资源管理</a></li>
					<li class=""><a href="./javascript.html">用户组管理</a></li>
					<li class=""><a href="./customize.html">权限管理</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row-fluid">
			<div class="span2 pt-60">
				<ul id="treeDemo" class="ztree">
				</ul>
			</div>
			<div class="span10 pt-60">
				<div class="mt-5">
					<ul class="breadcrumb">
						<li><a href="#">Home</a> <span class="divider">/</span></li>
						<li><a href="#">Library</a> <span class="divider">/</span></li>
						<li class="active">Data</li>
					</ul>
				</div>
				<div>
					<div class="alert alert-success fade in out" style="display:none;">
						<button type="button" class="close" data-dismiss="alert">
							&times;</button>
						<strong> <s:actionmessage /> <s:actionerror /> </strong>
					</div>
				</div>
				<div>
					<div class="span9">
						<form class="form-search" action="/user/listUser.action"
							method="get">
							<input id="username" name="user.username" type="text" class="input-medium" value="${request.user.username }">
							<input id="pageSize" name="user.pageSize" type="hidden" class="input-medium"
								value="${request.pagedQuery.pageSize }">
							<input id="currPage"
								name="user.currPage" type="hidden" class="input-medium"
								value="${request.pagedQuery.currPage }">
							<button type="submit" class="btn">搜索</button>
						</form>
					</div>
					<div class="span3 text-right">
						<button data-toggle="modal" data-target="#myModal" type="button"
							class="btn">新增</button>
						<button data-toggle="modal" data-target="#myModal" type="button"
							class="btn">批量删除</button>
					</div>
				</div>
				<table id="example"
					class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>id</th>
							<th>username</th>
							<th>nickname</th>
							<th>email</th>
							<th>phone</th>
							<th>createDate</th>
							<th class="operate-column">操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator var="queryResult" status="status"
							value="#request.pagedQuery.queryResults">
							<tr>
								<td><s:property value="#status.getIndex()" /></td>
								<td><s:property value="#queryResult.id" /></td>
								<td><s:property value="#queryResult.username" /></td>
								<td><s:property value="#queryResult.password" /></td>
								<td>@mdo</td>
								<td>@mdo</td>
								<td>Thornton</td>
								<td class="operate-column"><a href="#myModal" role="button"
									class="btn" data-toggle="modal">编辑</a> <a href="#deleteModal"
									_deleteUserId="${ queryResult.id }" role="button"
									class="btn deleteBtn" data-toggle="modal">删除</a></td>
							</tr>
						</s:iterator>
					</tbody>
					<tfoot>
					</tfoot>
				</table>
				<!--/example-->

				<div class="center">
					<div class="pagination">
						<ul>
							<li class="prev disabled"><a href="#">上一页</a></li>
							<!-- <s:url value='/listUser.action'>
									<s:param name='user.currPage' value='#status.count'/>
									<s:param name='user.pageSize' value='#request.pagedQuery.pageSize'/>
								</s:url> -->
							<s:iterator begin="1" end="#request.pagedQuery.totalPage"
								status="status">
								<li class="active">
									<a class="pagedQueryClick" _pageSize="${ status.count }" _currPage="${ request.pagedQuery.pageSize }" href="javascript:void(0);"><s:property value="#status.count" /> </a>
								</li>
							</s:iterator>
							<li class="next"><a href="#">下一页</a></li>
						</ul>
					</div>
				</div>
				<!--/center-->

				<!-- Modal -->
				<div id="myModal" class="modal hide fade" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

				</div>
				<!--/myModal-->

				<!-- delte Modal -->
				<div id="deleteModal" class="modal hide fade" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<s:form id="deleteForm" action="deleteUser" method="post">
						<s:hidden id="userId" name="user.id"></s:hidden>
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h3 id="myModalLabel">删除用户</h3>
						</div>
						<div class="modal-body">
							<p>是否确认删除该用户？</p>
						</div>
						<div class="modal-footer">
							<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
							<button id="deleteUser" class="btn btn-primary">Delete</button>
						</div>
					</s:form>
				</div>

			</div>
		</div>
	</div>
	<script src="<s:url value='/js/jquery-1.10.2.min.js' />"></script>
	<script src="<s:url value='/js/bootstrap.min.js' />"></script>
	<script src="<s:url value='/js/jquery.ztree.all-3.5.js' />"></script>
	<SCRIPT type="text/javascript">
	<!--
		var setting = {};

		var zNodes = [ {
			name : "父节点1 - 展开",
			open : true,
			children : [ {
				name : "父节点11 - 折叠",
				children : [ {
					name : "叶子节点111"
				}, {
					name : "叶子节点112"
				}, {
					name : "叶子节点113"
				}, {
					name : "叶子节点114"
				} ]
			}, {
				name : "父节点12 - 折叠",
				children : [ {
					name : "叶子节点121"
				}, {
					name : "叶子节点122"
				}, {
					name : "叶子节点123"
				}, {
					name : "叶子节点124"
				} ]
			}, {
				name : "父节点13 - 没有子节点",
				isParent : true
			} ]
		}, {
			name : "父节点2 - 折叠",
			children : [ {
				name : "父节点21 - 展开",
				open : true,
				children : [ {
					name : "叶子节点211"
				}, {
					name : "叶子节点212"
				}, {
					name : "叶子节点213"
				}, {
					name : "叶子节点214"
				} ]
			}, {
				name : "父节点22 - 折叠",
				children : [ {
					name : "叶子节点221"
				}, {
					name : "叶子节点222"
				}, {
					name : "叶子节点223"
				}, {
					name : "叶子节点224"
				} ]
			}, {
				name : "父节点23 - 折叠",
				children : [ {
					name : "叶子节点231"
				}, {
					name : "叶子节点232"
				}, {
					name : "叶子节点233"
				}, {
					name : "叶子节点234"
				} ]
			} ]
		}, {
			name : "父节点3 - 没有子节点",
			isParent : true
		}

		];

		$(document).ready(function() {
			//初始化树形结构
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			
			//
			$("#myModal").load("<s:url value='/detailUser.action' />");
			
			//打开删除对话框
			$(".deleteBtn").click(function() {
				var userId = $(this).attr("_deleteUserId");
				$("#userId").val(userId);
			});
			
			//确认删除用户
			$("#deleteUser").click(function() {
				$("#deleteForm").submit();
			});
			
			//处理Action信息
			var actionMessages = $(".actionMessage");
			var actionError = $(".actionError");
			if (actionMessages.length != 0 || actionError.length != 0) {
				$(".alert").show().alert();
				window.setTimeout(function() {
					$(".alert").alert("close");
				}, 5000);
			}
			
			$(".pagedQueryClick").click(function(){
				$("#pageSize").val($(this).attr("_pageSize"));
				$("#currPage").val($(this).attr("_currPage"));
				console.info("pageSize="+$(this).attr("_pageSize")+",currPage="+$(this).attr("_currPage"));
				$(".form-search").submit();
			});
		});
	//-->
	</SCRIPT>
</body>
</html>
