<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = CmmUtil.nvl((String)session.getAttribute("user_name"));    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="background-color: blue;">
		top~~~~~~~~
		<div>
			<ul>
				<li>
					<%if(name.isEmpty()){ %>
						<a href="/user/userLogin.do">
						로그인
						</a>
						<%} else {%>
							<%=name %>님 환영합니다.
							<a href="/user/userLogout.do">
								로그아웃							
							</a>
							<%} %>
				</li>
			</ul>
		</div>
	</div>


</body>
</html>