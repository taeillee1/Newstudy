/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.56
 * Generated at: 2022-01-18 09:22:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import bbs.BbsDAO;
import bbs.Bbs;
import java.util.ArrayList;
import java.net.URLEncoder;

public final class searchpage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.io.PrintWriter");
    _jspx_imports_classes.add("bbs.Bbs");
    _jspx_imports_classes.add("java.net.URLEncoder");
    _jspx_imports_classes.add("bbs.BbsDAO");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width\",initial-scale=\"1\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/onlymine.css\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("	.hi{\r\n");
      out.write("		font-size:20px;\r\n");
      out.write("	}\r\n");
      out.write("	.navbar-nav .open .dropdown-menu > li > a:hover,\r\n");
      out.write("	.navbar-nav .open .dropdown-menu > li > a:focus {\r\n");
      out.write("	  	font-size:30px;\r\n");
      out.write("	  	background-color:yellow;\r\n");
      out.write("	    background-image: url('image/im4.png');\r\n");
      out.write("	}\r\n");
      out.write("	li{\r\n");
      out.write("		font-size:15px;\r\n");
      out.write("	}\r\n");
      out.write("	.bye{\r\n");
      out.write("		display:block;\r\n");
      out.write("	    width:80px;\r\n");
      out.write("	    line-height:30px;\r\n");
      out.write("	    text-align:center;\r\n");
      out.write("	    background-color:#222;\r\n");
      out.write("	    color:#fff;\r\n");
      out.write("	    float:right;\r\n");
      out.write("	}\r\n");
      out.write("	a{\r\n");
      out.write("		color:black;\r\n");
      out.write("	}\r\n");
      out.write("	a:hover{\r\n");
      out.write("		color:red;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
 
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
	
      out.write(" \r\n");
      out.write("	<nav class=\"navbar navbar-inverse\">\r\n");
      out.write("		<div class=\"navbar-header\">\r\n");
      out.write("			<a class=\"navbar-brand\" href =\"mainpage\" style=\"font-size:25px;\">JSP활용한 페이지 만들기</a>\r\n");
      out.write("			<button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" \r\n");
      out.write("			data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\"> <!-- collapse는 숨기기 기능  -->\r\n");
      out.write("				<span class=\"icon-bar\"></span>\r\n");
      out.write("				<span class=\"icon-bar\"></span>\r\n");
      out.write("				<span class=\"icon-bar\"></span>\r\n");
      out.write("				\r\n");
      out.write("			</button>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"collapse navbar-collapse\" id =bs-example-navbar-collapse-1>\r\n");
      out.write("			<ul class=\"nav navbar-nav\">\r\n");
      out.write("				<li style=\"font-size:15px;\"><a href=\"mainpage\">메인</a></li>\r\n");
      out.write("				<li style=\"font-size:15px;\"><a href=\"Mymenu\">내가 만들 메뉴</a></li>\r\n");
      out.write("			</ul>\r\n");
      out.write("			\r\n");
      out.write("			");

			if(userID==null){
			
      out.write("\r\n");
      out.write("			<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("				<li class=\"dropdown\">\r\n");
      out.write("					<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("					aria-expanded=\"false\">접속하기<span class=\"caret\"></span></a>\r\n");
      out.write("					<ul class=\"dropdown-menu\">\r\n");
      out.write("						<li><a href=\"login\">로그인</a></li>\r\n");
      out.write("						<li><a href=\"join\">회원가입</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</li>\r\n");
      out.write("			</ul>\r\n");
      out.write("			");

				}else{
			
      out.write("\r\n");
      out.write("			<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("				<li class=\"dropdown\">\r\n");
      out.write("					<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("					aria-expanded=\"false\">회원관리<span class=\"caret\"></span></a>\r\n");
      out.write("					<ul class=\"dropdown-menu\">\r\n");
      out.write("						<li class=\"hi\"><a href=\"#\">");
      out.print( userID );
      out.write("</a></li>\r\n");
      out.write("						<li><a href=\"logoutAction\">로그아웃</a></li>\r\n");
      out.write("						\r\n");
      out.write("					</ul>\r\n");
      out.write("				</li>\r\n");
      out.write("			</ul>\r\n");
      out.write("			");

				}
			
      out.write("\r\n");
      out.write("			\r\n");
      out.write("		</div>	\r\n");
      out.write("	</nav>\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("	\r\n");
      out.write("		<form method=\"get\" name=\"search\" action=\"searchpage\">\r\n");
      out.write("				<table class=\"pull-right\">\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td><select class=\"form-control\" name=\"searchField\">\r\n");
      out.write("								<option value=\"0\">선택</option>\r\n");
      out.write("								<option value=\"bbsTitle\">제목</option>\r\n");
      out.write("								<option value=\"userID\">작성자</option>\r\n");
      out.write("						</select></td>\r\n");
      out.write("						<td><input type=\"text\" class=\"form-control\"\r\n");
      out.write("							placeholder=\"검색어 입력\" name=\"searchText\" maxlength=\"100\"></td>\r\n");
      out.write("						<td><button type=\"submit\" class=\"btn btn-success\">검색</button></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("\r\n");
      out.write("				</table>\r\n");
      out.write("\r\n");
      out.write("		</form>\r\n");
      out.write("\r\n");
      out.write("		<table class=\"table table-striped\" style=\"text-align:center; border:1px solid #dddddd\">\r\n");
      out.write("			<thead><!-- 테이블의 제목부분으로 가장 윗줄에 해당하여 각각의 속성을 알려줌 -->\r\n");
      out.write("				<tr> <!-- 테이블의 하나의 행을 의미 -->\r\n");
      out.write("					<th style=\"text-align:center; border:1px solid #eeeeee; background-color:#90EE90;\">번호</th>\r\n");
      out.write("					<th style=\"text-align:center; border:1px solid #eeeeee; background-color:#90EE90;\">제목</th>\r\n");
      out.write("					<th style=\"text-align:center; border:1px solid #eeeeee; background-color:#90EE90;\">작성자</th>\r\n");
      out.write("					<th style=\"text-align:center; border:1px solid #eeeeee; background-color:#90EE90;\">작성일</th>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</thead>\r\n");
      out.write("			<tbody>\r\n");
      out.write("					");

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
					
      out.write("\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td>");
      out.print(list.get(i).getBbsID());
      out.write("</td>\r\n");
      out.write("						");
      out.write("\r\n");
      out.write("						<td><a href=\"view?bbsID=");
      out.print(list.get(i).getBbsID());
      out.write('"');
      out.write('>');
      out.print(list.get(i).getBbsTitle().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;")
						.replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
      out.write("</a></td>\r\n");
      out.write("						<td>");
      out.print(list.get(i).getUserID());
      out.write("</td>\r\n");
      out.write("						<td>");
      out.print(list.get(i).getBbsDate().substring(0, 11) + list.get(i).getBbsDate().substring(11, 13) + "시"
						+ list.get(i).getBbsDate().substring(14, 16) + "분");
      out.write("</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					");

						}
					
      out.write("\r\n");
      out.write("				</tbody>\r\n");
      out.write("		</table>\r\n");
      out.write("		<div class=container style=\"text-align: center; font-size:20px; padding:30px;\">\r\n");
      out.write("				");

					if (pageNumber <= 1) {//이전페이지로
				
      out.write("\r\n");
      out.write("					\r\n");
      out.write("				");

					}else{
				
      out.write("\r\n");
      out.write("				<a class = \"btn btn-success btn-arraw-left\"  href=\"searchpage?searchField=");
      out.print(URLEncoder.encode(searchField,"UTF-8") );
      out.write("&searchText=\r\n");
      out.write("				");
      out.print(URLEncoder.encode(searchText, "UTF-8"));
      out.write("&pageNumber=");
      out.print(pageNumber - 1);
      out.write("\">이전</a>\r\n");
      out.write("				");
 
					}
				
      out.write("\r\n");
      out.write("				");

					int n = (int) (bbsDAO.getCount(a,b) / 10 + 1);
					for (int i = 1; i <= n; i++) {
				
      out.write("\r\n");
      out.write("				<a href=\"searchpage?searchField=");
      out.print(URLEncoder.encode(searchField,"UTF-8") );
      out.write("&searchText=\r\n");
      out.write("				");
      out.print(URLEncoder.encode(searchText, "UTF-8"));
      out.write("&pageNumber=");
      out.print(i);
      out.write("\"class = \"btn btn-success btn-arraw-left\" >");
      out.print(i);
      out.write("\r\n");
      out.write("				</a>\r\n");
      out.write("				");

					}
				
      out.write("\r\n");
      out.write("				\r\n");
      out.write("				");

					if (list.size()<10) {
				
      out.write("\r\n");
      out.write("				\r\n");
      out.write("				");

					}else{
				
      out.write("\r\n");
      out.write("				<a class = \"btn btn-success btn-arraw-left\"  href=\"searchpage?searchField=");
      out.print(URLEncoder.encode(searchField,"UTF-8") );
      out.write("&searchText=\r\n");
      out.write("				");
      out.print(URLEncoder.encode(searchText, "UTF-8"));
      out.write("&pageNumber=");
      out.print(pageNumber + 1);
      out.write("\">다음</a>\r\n");
      out.write("\r\n");
      out.write("				");

					}
				
      out.write("\r\n");
      out.write("				<a href=\"write\" class=\"btn btn-success pull-right\">글쓰기</a>\r\n");
      out.write("			</div>\r\n");
      out.write("		\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<script src=\"http://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("	<script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
