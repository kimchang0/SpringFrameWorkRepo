<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myOrderLogin</title>
</head>
<body>
	<div>
		myOrder 서비스를 이용하시려면 로그인을 해주세요
		<form action="/myOrder/myOrderLoginProc.do" method="post">
			아이디 : <input type="text" name="id">
			
			비밀번호 : <input type="password" name="pwd">
			
			<button type="submit">로그인</button>
		</form>
		<hr>
		<form action="/myOrder/myOrderSignUp.do">
			아직 myOrder에 가입하지 않으셨나요?<button type="submit">회원가입</button>
		</form>
	</div>
</body>
</html>