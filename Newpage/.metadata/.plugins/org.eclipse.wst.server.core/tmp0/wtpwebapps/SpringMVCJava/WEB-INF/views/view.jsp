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
			
			<%
			if(userID==null){
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login">로그인</a></li>
						<li><a href="join">회원가입</a></li>
					</ul>
				</li>
			</ul>
			<%
				}else{
			%>
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
			<%
				}
			%>
			
		</div>
	</nav>
	<div class="container">
		
			<table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
				<thead><!-- 테이블의 제목부분으로 가장 윗줄에 해당하여 각각의 속성을 알려줌 -->
					<tr> <!-- 테이블의 하나의 행을 의미 -->
						<th colspan="3" style="text-align:center; border:1px solid #eeeeee">게사핀 글보기</th>
						<!-- 위의 colspan은 몇개의 열을 잡아먹을것인가를 나타냄 -->
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width:20%">글 제목</td>
						<td colspan="2"><%= bbs.getBbsTitle().replaceAll(" ","&nbsp").replaceAll("<", "&lt;").replaceAll("\n", "<br>") %></td>
						<!-- 위의 replaceAll은 특수문자를 치환해주는것으로 스크립트 공격이나 html문자로 인식하여 출력하지 않아버리는 오류를 방지할 수 있다. -->
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2"><%= bbs.getUserID() %></td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td colspan="2"><%= bbs.getBbsDate().substring(0,11)+ bbs.getBbsDate().substring(11,13)+"시"+bbs.getBbsDate().substring(14,16)+"분" %></td>
					</tr>
					<tr>
						<td style="line-height:250px;">내용</td>
						<td colspan="2" style="min-height:200px; text-align:left;"><%= bbs.getBbsContent().replaceAll(" ","&nbsp").replaceAll("<", "&lt;").replaceAll("\n", "<br>")%></td>
					</tr>
				</tbody>
				
			</table>
			<a href="Mymenu" class="btn btn-primary">목록</a>
			<%
				if(userID != null && userID.equals(bbs.getUserID())){
			%>
				<a href="update?bbsID=<%= bbsID %>" class="btn btn-primary">수정</a>
				<a onclick="return confirm('정말로 삭제하실건가요?')" href="deleteAction?bbsID=<%= bbsID %>" class="btn btn-primary">삭제</a>
			<%
				}
			%>
		
		
	</div>
	
	
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>