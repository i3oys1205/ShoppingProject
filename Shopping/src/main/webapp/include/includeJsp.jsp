<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top"><a class="navbar-brand" href="#" page="/main">haeorum</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link active" href="#" page="/admin">메뉴관리</a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="#" page="/display">화면설정</a>
				</li>				
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a class="nav-link" href="#" action="displayApply">반영하기</a>
					</li>
					<li class="nav-item active">
						<a class="nav-link" href="#" action="displaySave">저장하기</a>
					</li>
					<li class="nav-item active">
						<a class="nav-link" href="#" page="/main">돌아가기</a>
					</li>
				</ul>
			</form>
		</div>
	</nav>
