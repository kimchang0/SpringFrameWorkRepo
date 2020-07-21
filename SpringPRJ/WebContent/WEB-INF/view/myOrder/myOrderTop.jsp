<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = CmmUtil.nvl((String)session.getAttribute("user_name"));    
%>
<!DOCTYPE html>
<html>
<style>
a{
text-decoration: none;
color: blue;
}
ul{
list-style-type: none;
}
body{
float:right;
}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="background-color: none;">
		<div>
			<ul>
				<li>
					<%if(name.isEmpty()){ %>
						<a href="/myOrder/myOrderLogin.do">
							로그인
						</a>
						<a href="/myOrder/myOrderSignUp.do">
							회원가입
						</a>
					<%} else {%>
						<%=name %>님 환영합니다.
						<a href="/myOrder/myOrderLogout.do">
							로그아웃							
						</a>
						<a href="/myOrder/myOrderList.do">
							주문내역							
						</a>
						<a href="/myOrder/myOrderDoOrderList.do">
							주문하기							
						</a>
					<%} %>
				</li>
			</ul>
		</div>
	</div>


</body>
</html>