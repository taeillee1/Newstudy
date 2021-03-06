<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width",initial-scale="1">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/onlymine.css">
<title>Insert title here</title>
<style>
	.tata{
		font-size:15px;
		padding:10px;
	}
	li{
		font-size:15px;
	}
</style>
</head>
<body>
	<!-- <img src="image/imimim.png"/> -->
	<!-- <a href="test1">test1</a> -->
	<!-- <button onclick="location='test1'">버튼 클릭시 이동</button> -->
	<nav class="navbar navbar-inverse">
		<div class="navbar-header">
			<a class="navbar-brand" href ="index" style="font-size:25px;">JSP활용한 페이지 만들기</a>
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 
			data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <!-- collapse는 숨기기 기능  -->
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				
			</button>
		</div>
		<div class="collapse navbar-collapse" id =bs-example-navbar-collapse-1>
			<ul class="nav navbar-nav">
				<li style="font-size:15px;"><a href="mainpage">메인</a></li>
				<li style="font-size:15px;"><a href="Mymenu">내가 만들 메뉴</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login">로그인</a></li>
						<li><a href="#">회원가입</a></li>
					</ul>
				</li>
			</ul>
			
		</div>
	</nav>
	<!-- 회원가입 양식 만들기 -->
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top : 20px;">
				<form method="post" action="joinAction">
					<h3 style="text-align:center; margin:20px;">회원가입 화면</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="ID" name="userID" maxlength="40">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="PassWord" name="userPassword" maxlength="20">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Name" name="userName" maxlength="20">
					</div>
					<div class="form-group">
						<div class="btn-group" data-toggle="buttons">
							<label class="tata">
								<input type="radio" name ="userGender" autocomplete="off" value="남자" checked>남자
							</label>
							<label class="tata">
								<input type="radio" name ="userGender" autocomplete="off" value="여자" checked>여자
							</label>
						</div>
					</div>
					<div class="form-group">
						<input type="email" class="form-control" placeholder="Email" name="userEmail" maxlength="40">
					</div>
					<input type="submit" value="회원가입" class="form-control" style="background-color:black; color:white; font-size:20px;">
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
	
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>