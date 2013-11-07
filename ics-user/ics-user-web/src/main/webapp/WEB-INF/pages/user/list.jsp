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
					<div class="span9">
						<form class="form-search">
							<input type="text" class="input-medium">
							<!-- search-query -->
							<input type="text" class="input-medium">
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
							<th>First Name</th>
							<th>Last Name</th>
							<th>Username</th>
							<th>Last Name</th>
							<th>Username</th>
							<th class="operate-column">操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator var="user" status="status"
							value="#request.pagedQuery.queryResults">
							<tr>
								<td><s:property value="#status.getIndex()" />
								</td>
								<td><s:property value="#user.username" /></td>
								<td><s:property value="#user.password" />
								</td>
								<td>@mdo</td>
								<td>@mdo</td>
								<td>Thornton</td>
								<td class="operate-column"><a href="#myModal" role="button"
									class="btn" data-toggle="modal">编辑</a><a href="#myModal"
									role="button" class="btn" data-toggle="modal">删除</a></td>
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
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li class="next"><a href="#">下一页</a></li>
						</ul>
					</div>
				</div>
				<!--/center-->

				<!-- Modal -->
				<div id="myModal" class="modal hide fade" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">Modal header</h3>
					</div>
					<div class="modal-body">
						<p>One fine body…</p>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
						<button class="btn btn-primary">Save changes</button>
					</div>
				</div>
				<!--/myModal-->

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
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
	//-->
	</SCRIPT>
</body>
</html>
