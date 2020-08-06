<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>myOrderEmailCheck</title>
</head>
<body>
	<div>
		<form action="/myOrder/myOrderIndex.do" method="post" onsubmit="return check()">

			이메일 : <input type="email" name="email" id="email" placeholder="이메일 입력" required> <button type="button" id="send">인증코드 보내기</button> <br>
			인증코드 입력 : <input type="number" name="auth" max="6">
			<span class="auth-success" style="display: none;">인증코드가 일치합니다.</span> 
			<span class="auth-error" style="display: none; color: #d92742; font-weight: bold;">인증코드가 일치하지 않습니다.</span> <br> 
			
			<button type="submit">인증 완료</button>
		</form>
	</div>
</body>
<script>
	
	$('#send').click(function() {
		var query = {
				email : $("#email").val()
			};

			$.ajax({
				url : "emailCheck.do",
				type : "post",
				data : query,
				success : function(data) {
					
				}
			}); // ajax 끝
	});

</script>

</html>