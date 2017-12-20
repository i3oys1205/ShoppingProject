<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:set var="context" value="${pageContext.request.contextPath}" />
<jsp:include page="${context}/include/includeScripts.jsp"></jsp:include>
<script type="text/javascript" src="${context}/scripts/userDefined/mainPaging.js"></script>
<title>${pageTitle}</title>
<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top"><a class="navbar-brand" href="#" page="/main">haeorum</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
			
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item">
						<a class="nav-link" href="#">로그인</a>
					</li>
					<li class="nav-item active">
						<a class="nav-link" href="#" page="admin">관리자</a>
					</li>
				</ul>
				<input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
			</form>
		</div>
	</nav>

	<div class="container-fluid starter-template">

	</div><!-- /.container -->
	
</body>
</html>