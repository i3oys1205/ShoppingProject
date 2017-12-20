<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="context" value="${pageContext.request.contextPath}" />
<jsp:include page="${context}/include/includeScripts.jsp"></jsp:include>
<link href="${context}/css/userDefined/displayCss.css" rel="stylesheet">
<link href="${context}/css/plugin/font-awesome.min.css" rel="stylesheet">
<link href="${context}/css/plugin/froala_style.min.css" rel="stylesheet">
<link href="${context}/css/plugin/codemirror.min.css" rel="stylesheet">
<link href="${context}/css/plugin/froala_editor.pkgd.min.css" rel="stylesheet">
<script type="text/javascript" src="${context}/scripts/userDefined/adminPaging.js"></script>
<script type="text/javascript" src="${context}/scripts/plugin/froala_editor.min.js"></script>
<title>${pageTitle}</title>
</head>
<body>
	<jsp:include page="${context}/include/includeJsp.jsp"></jsp:include>

	<div class="container-fluid text-center pading-left-0 pading-right-0 pading-top-5">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<div class="sidebar left">
					<ul class="list-sidebar bg-defoult">
					</ul>
				</div>
			</div>
			<div class="col-sm-8 contextDesinge">
			</div>
			<div class="col-sm-2 sidenav">
				<div class="list-group">
					<span href="#" class="list-group-item active"> 디자인 툴 <span class="pull-right" id="slide-submenu"> <i class="fa fa-times" action="sidebarToggle"></i></span></span>
					<div class="list-group-item sct">
						<div class="row">
							<div class="col-md-12 del"></div>
						</div>
					</div>
					<div class="list-group-item sct">
						<div class="row">
							<div class="col-md-8 del"></div>
							<div class="col-md-4 del"></div>
						</div>
					</div>
					<div class="list-group-item sct">
						<input type="text" class="in">
					</div>
					<div class="list-group-item sct">
						<input type="checkbox" class="del">
					</div>
					<div class="list-group-item sct">
						<div class="jumbotron del">
							<div class="container">
								<h1 class="in">Header</h1>
								<p class="in">container</p>
							</div>
						</div>
					</div>
					<div class="list-group-item sct">
						<a class="btn btn-primary btn-lg in_act" href="#" role="button">확인</a>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- dynamic display modal -->
	<div class="modal fade" id="displayModal_1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">HTML Editor</h4>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="type_in" id="edit"></div>
					<div class="type_act">
						#link
						<input type="text" class="type_link">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary displayModalSave" action="displayModalSave">저장</button>
					<button type="button" class="btn btn-danger" action="displayModalDelete">삭제</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

</body>
</html>