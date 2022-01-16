<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="bbs.Bbs" %>
<%@ page import="bbs.BbsDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width",initial-scale="1">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/onlymine.css">
<title>Insert title here</title>
<style>
	.hi{
		background-color:yellow;
		font-size:30px;
	}
	.bye{
		display:block;
	    width:80px;
	    line-height:30px;
	    text-align:center;
	    background-color:#222;
	    color:#fff;
	    float:right;
	}
	li{
		font-size:15px;
	}
</style>
</head>
<body>
	<% 
		String userID=null;
		if(session.getAttribute("userID") != null){
			userID=(String)session.getAttribute("userID");
		}
		if(userID==null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 하세요.')");
			script.println("location.href='login'");
			script.println("<script>");
		}
		int bbsID=0;
		if(request.getParameter("bbsID")!=null){
			bbsID=Integer.parseInt(request.getParameter("bbsID"));
		}
		if(bbsID==0){
			PrintWriter script = response.getWriter();
			script.println("<script>"); //jsp파일에서 html처럼 페이지를 이동시킬때 사용하는 방법
			script.println("alert('유효하지 않은 글입니다')");
			script.println("location.href='Mymenu'");
			script.println("</script>"); 
		}
		Bbs bbs = new BbsDAO().getBbs(bbsID);
		if(!userID.equals(bbs.getUserID())){
			PrintWriter script = response.getWriter();
			script.println("<script>"); //jsp파일에서 html처럼 페이지를 이동시킬때 사용하는 방법
			script.println("alert('권한이 없습니다.')");
			script.println("location.href='Mymenu'");
			script.println("</script>"); 
		}
	%> 
	<nav class="navbar navbar-inverse">
		<div class="navbar-header">
			<a class="navbar-brand" href ="mainpage" style="font-size:25px;">JSP활용한 페이지 만들기</a>
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
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="hi"><a href="#"><%= userID %></a></li>
						<li><a href="logoutAction">로그아웃</a></li>
						
					</ul>
				</li>
			</ul>
			
		</div>
	</nav>
	<div class="container">
		<form method="post" action="updateAction?bbsID=<%= bbsID %>">
			<table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
				<thead><!-- 테이블의 제목부분으로 가장 윗줄에 해당하여 각각의 속성을 알려줌 -->
					<tr> <!-- 테이블의 하나의 행을 의미 -->
						<th colspan="2" style="text-align:center; border:1px solid #eeeeee">게사핀 글수정 양식</th>
						<!-- 위의 colspan은 몇개의 열을 잡아먹을것인가를 나타냄 -->
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" class="form-control" placeholder="글 제목" name="bbsTitle" maxlength="50" value="<%= bbs.getBbsTitle()%>"></td>
					</tr>
					<tr>
						<td><textarea class="form-control" placeholder="글 내용" name="bbsContent" maxlength="2048"
						style="height:350px;"><%= bbs.getBbsContent()%></textarea></td>
					</tr>
				</tbody>
				
			</table>
			<input  type="submit" class="btn btn-primarry pull-right" value="글수정">
		</form>
		
	</div>
	
	
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>