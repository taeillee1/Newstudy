<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="bbs.BbsDAO" %>
<%@ page import="bbs.Bbs" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.URLEncoder"%>
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
		font-size:20px;
	}
	.navbar-nav .open .dropdown-menu > li > a:hover,
	.navbar-nav .open .dropdown-menu > li > a:focus {
	  	font-size:30px;
	  	background-color:yellow;
	    background-image: url('image/im4.png');
	}
	li{
		font-size:15px;
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
	a{
		color:black;
	}
	a:hover{
		color:red;
	}
</style>
</head>
<body>
	<% 
		request.setCharacterEncoding("UTF-8");
		String searchField="작성자";
		String searchText="";
		String userID=null;
		if(session.getAttribute("userID") != null){
			userID=(String)session.getAttribute("userID");
		}
		if(request.getParameter("searchField")!=null){
			searchField=request.getParameter("searchField");
		}
		if(request.getParameter("searchText")!=null){
			searchText=request.getParameter("searchText");
		}
		
		int pageNumber=1;
		if(request.getParameter("pageNumber")!=null){
			pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
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
	
		<form method="get" name="search" action="searchpage">
				<table class="pull-right">
					<tr>
						<td><select class="form-control" name="searchField">
								<option value="0">선택</option>
								<option value="bbsTitle">제목</option>
								<option value="userID">작성자</option>
						</select></td>
						<td><input type="text" class="form-control"
							placeholder="검색어 입력" name="searchText" maxlength="100"></td>
						<td><button type="submit" class="btn btn-success">검색</button></td>
					</tr>

				</table>

		</form>

		<table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
			<thead><!-- 테이블의 제목부분으로 가장 윗줄에 해당하여 각각의 속성을 알려줌 -->
				<tr> <!-- 테이블의 하나의 행을 의미 -->
					<th style="text-align:center; border:1px solid #eeeeee; background-color:#90EE90;">번호</th>
					<th style="text-align:center; border:1px solid #eeeeee; background-color:#90EE90;">제목</th>
					<th style="text-align:center; border:1px solid #eeeeee; background-color:#90EE90;">작성자</th>
					<th style="text-align:center; border:1px solid #eeeeee; background-color:#90EE90;">작성일</th>
				</tr>
			</thead>
			<tbody>
					<%
						BbsDAO bbsDAO = new BbsDAO();
						String a= request.getParameter("searchField");
						String b= request.getParameter("searchText");
						ArrayList<Bbs> list = bbsDAO.getSearch(pageNumber,a,b);
						
						
						if (list.size() == 0) {
							PrintWriter script = response.getWriter();
							script.println("<script>");
							script.println("alert('검색결과가 없습니다.')");
							script.println("history.back()");
							script.println("</script>");
						}
						
						for (int i = 0; i < list.size(); i++) {
					%>
					<tr>
						<td><%=list.get(i).getBbsID()%></td>
						<%--현재 게시글에 대한 정보 --%>
						<td><a href="view?bbsID=<%=list.get(i).getBbsID()%>"><%=list.get(i).getBbsTitle().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;")
						.replaceAll(">", "&gt;").replaceAll("\n", "<br>")%></a></td>
						<td><%=list.get(i).getUserID()%></td>
						<td><%=list.get(i).getBbsDate().substring(0, 11) + list.get(i).getBbsDate().substring(11, 13) + "시"
						+ list.get(i).getBbsDate().substring(14, 16) + "분"%></td>
					</tr>
					<%
						}
					%>
				</tbody>
		</table>
		<div class=container style="text-align: center; font-size:20px; padding:30px;">
				<%
					if (pageNumber <= 1) {//이전페이지로
				%>
					
				<%
					}else{
				%>
				<a class = "btn btn-success btn-arraw-left"  href="searchpage?searchField=<%=URLEncoder.encode(searchField,"UTF-8") %>&searchText=
				<%=URLEncoder.encode(searchText, "UTF-8")%>&pageNumber=<%=pageNumber - 1%>">이전</a>
				<% 
					}
				%>
				<%
					int n = (int) (bbsDAO.getCount(a,b) / 10 + 1);
					for (int i = 1; i <= n; i++) {
				%>
				<a href="searchpage?searchField=<%=URLEncoder.encode(searchField,"UTF-8") %>&searchText=
				<%=URLEncoder.encode(searchText, "UTF-8")%>&pageNumber=<%=i%>"class = "btn btn-success btn-arraw-left" ><%=i%>
				</a>
				<%
					}
				%>
				
				<%
					if (list.size()<10) {
				%>
				
				<%
					}else{
				%>
				<a class = "btn btn-success btn-arraw-left"  href="searchpage?searchField=<%=URLEncoder.encode(searchField,"UTF-8") %>&searchText=
				<%=URLEncoder.encode(searchText, "UTF-8")%>&pageNumber=<%=pageNumber + 1%>">다음</a>

				<%
					}
				%>
				<a href="write" class="btn btn-success pull-right">글쓰기</a>
			</div>
		
	</div>
	
	
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>