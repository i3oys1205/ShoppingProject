<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="context" value="${pageContext.request.contextPath}" />
<jsp:include page="${context}/include/includeScripts.jsp"></jsp:include>
<script type="text/javascript" src="${context}/scripts/userDefined/adminPaging.js"></script>
<title>${pageTitle}</title>
</head>
<body>

	<jsp:include page="${context}/include/includeJsp.jsp"></jsp:include>

	<div class="container starter-template">
		<div class="card">
			<h4 class="card-header">상단 메뉴관리</h4>
			<div class="card-body">
				<div class="col-lg-6">
					<div class="input-group">
						<span class="input-group-addon"> <input type="checkbox">
						</span> <input type="text" class="form-control">
					</div>
				</div>
				 <p class="card-text"></p>
				<a href="#" class="btn btn-primary btn-lg btn-block" action="pageInputAdd">추가</a>
				<a href="#" class="btn btn-primary btn-lg btn-block" action="pageSave">저장</a>
				<a href="#" class="btn btn-danger  btn-lg btn-block" action="pageDelete">삭제</a>
			</div>
		</div>
	</div>
	<!-- /.container -->
</body>
</html>