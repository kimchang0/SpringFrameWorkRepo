<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="static poly.util.CmmUtil.nvl"%>
<%@page import="java.util.List"%>
<%@page import="poly.dto.myOrderDTO"%>
<%

 List<myOrderDTO> rList = (List<myOrderDTO>)request.getAttribute("rList");
 String name = (String)session.getAttribute("user_name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myOrderList</title>
</head>
<body>
<%=nvl(name) %>님의 주문 내역입니다.
	<table border="1">
		<tr>
			<td>메뉴</td>
			<td>가격</td>
			<td>주문일</td>
		</tr>
		<%for(myOrderDTO e : rList) {%>
		<tr>
			<td><%=nvl(e.getUser_menu())%></td>
			<td><%=nvl(e.getUser_price())%></td>
			<td><%=nvl(e.getUser_odt())%></td>
		</tr>
		<%} %>

	</table>
</body>
</html>