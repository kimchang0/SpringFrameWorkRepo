<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myOrderSignUp</title>
</head>
<body>
	<div>
		myOrder에 가입해주셔서 진심으로 감사합니다. 한결같은 서비스로 보답하겠습니다.
		<form action="/myOrder/myOrderSignUpProc.do" method="post">
		
			이름 : <input type="text" name="name"><br>
			
			아이디 : <input type="text" name="id"><br>
			
			비밀번호 : <input type="password" name="pwd"><br><hr>
			
			<button type="submit">가입하기</button>
		</form>
	</div>
</body>
</html>