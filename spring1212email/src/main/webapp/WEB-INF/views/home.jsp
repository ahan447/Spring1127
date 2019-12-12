<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>웹 소켓과 AOP</title>
<style>
#chatarea{
	width:200px;
	height:100px;
	overflow-y: auto;
	border:1px solid black;
	}

</style>
</head>
<body>
	<!-- <input type="button" value="ECHO 테스트" id="btn" /><br/> -->
	
	<div>
		<h2>이메일 주소 합치기</h2>
		
		아이디 : <input onkeyup="enterkey();" type='text' id='msg' />
		<br/>
		이메일 : <input onkeyup="enterkey();" type='text' id="name"/>@는 생략
		
		
		<br/>
		<input type="button" value="완료" id="sendbtn" /><br/>
		naver.com<br/>
		gmail.com<br/>
		kakao.com<br/>
		nate.com<br/>
		hanmail.net<br/>
		
		<br/>
		<br/>
		<h3>합친것</h3>
		<br/>
		<br/>
		<div id="chatarea">
				<div id="chatmessagearea"></div>
			</div>
	</div>
	
</body>
<!-- 채팅 관련 스크립트  -->
<script>
	//
	function enterkey() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
        	//메시지 만들기
    		var msg= '';
    		//이름 가져오기
    		msg = document.getElementById("msg").value;
    		//메시지 결합
    		msg = msg + "@" +document.getElementById("name").value;
    		document.getElementById("msg").value = "";
    		//메시지 전송
    		socket.send(msg);
        }
}


	//웹 소켓 연결
	var socket = new WebSocket("ws://localhost:8080/web/chatting-ws");
	//채팅 내용을 출력할 영역
	var chatmessagearea = document.getElementById("chatmessagearea");
	//웹 소켓 서버에 연결되었을 때 호출될 메소드
	
	//웹 소켓 서버에서 메시지가 왔을 때 호출될 메소드
	socket.addEventListener("message" , function(e){
		chatmessagearea.innerHTML =
			e.data +"<Br/>" + chatmessagearea.innerHTML;
	});
	
	
	//전송 버튼을 눌렀을 때 수행할 내용
	document.getElementById("sendbtn").addEventListener(
			'click' , function(e) {
		//메시지 만들기
		var msg= '';
		//이름 가져오기
		msg = document.getElementById("msg").value;
		//메시지 결합
		msg = msg + "@" +document.getElementById("name").value;
		document.getElementById("msg").value = "";
		//메시지 전송
		socket.send(msg);
	
	});
	
	
	
	
	

</script>

<script>

</script>
</html>