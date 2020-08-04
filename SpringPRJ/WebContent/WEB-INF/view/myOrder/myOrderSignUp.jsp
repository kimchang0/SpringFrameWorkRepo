<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>myOrderSignUp</title>
</head>
<body>
	<div>
		myOrder에 가입해주셔서 진심으로 감사합니다. 한결같은 서비스로 보답하겠습니다.
		<form action="/myOrder/myOrderSignUpProc.do" method="post" onsubmit="return check()">
		
			이름 : <input type="text" name="name" required autofocus><br>
			
			아이디 :<input type="text" id="userId" name="id" placeholder="id" ><button type="button" class="idCheck">중복확인</button><br>
			<span class="msg">중복확인을 눌러주세요.</span><br>
			비밀번호 : <input type="password" name="pwd" required id="password_1" class="pw" placeholder="8~15자 영문,숫자,특수문자"><br>
			
			비밀번호 확인 :  <input type="password" required id="password_2" class="pw" placeholder="비밀번호 확인">
    		<span class="alert-success" style="display: none;">비밀번호가 일치합니다.</span>
    		<span id="alert-danger" style="display: none; color: #d92742; font-weight: bold; ">비밀번호가 일치하지 않습니다.</span>
			<br><hr>

			<button type="submit" class="alert-success">가입하기</button>
		</form>
	</div>
</body>
<script>
var doCheck = 'N'

$(".idCheck").click(function(){
 var query = {userId : $("#userId").val()};
 
 $.ajax({
  url : "idCheck.do",
  type : "post",
  data : query,
  success : function(data) {
   if(data == 1) {
	$('#userId').val('');
    $('#userId').focus();
    $(".msg").text("이미 사용하고 있는 아이디입니다.");
    $(".msg").attr("style", "color:#f00");
    doCheck = 'N'
   } else {
    $(".msg").text("사용 가능한 아이디입니다.");
    $(".msg").attr("style", "color:#00f");
    $('#userId').attr("check_result", "success");
    doCheck = 'Y'
   }
  }
 });  // ajax 끝
});

    $('.pw').focusout(function () {
        var pwd1 = $("#password_1").val();
        var pwd2 = $("#password_2").val();
 
        if ( pwd1 != '' && pwd2 == '' ) {
            null;
        } else if (pwd1 != "" || pwd2 != "") {
            if (pwd1 == pwd2) {
                $(".alert-success").css('display', 'inline-block');
                $("#alert-danger").css('display', 'none');
            } else {
                $(".alert-success").css('display', 'none');
                $("#alert-danger").css('display', 'inline-block');
            }
        }
    });
    
   function check() {
	   if(doCheck == 'N') {
		   alert("중복확인을 눌러주세요.")
		  return false;
	   }
   }
   
</script>

</html>