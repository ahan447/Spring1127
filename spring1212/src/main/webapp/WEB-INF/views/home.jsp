<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- header.jsp 파일을 추가 -->
<%@ include file="include/header.jsp"%>

<section class="content">
	<!-- 주소 출력 영역 -->
	<div class="box">
		<p id='addr'></p>
	</div>
	<div class="box">
		<!-- 로그인이 안된 경우 -->
		<c:if test="${user == null}">

			<div class="box-header with-border">
				<a href="user/login"><h3 class='box-title'>로그인</h3></a>
			</div>
		</c:if>
		<!-- 로그인이 된 경우 -->
		<c:if test="${user != null}">
			<div class="box-header with-border">
				<a href="user/logout"><h3 class='box-title'>로그아웃</h3></a>
			</div>
			<div class="box-header with-border">
				<a href="board/write"><h3 class='box-title'>게시글 작성</h3></a>
			</div>
		</c:if>
		<div class="box-header with-border">
			<a href="user/join"><h3 class='box-title'>회원가입</h3></a>
		</div>
	</div>
</section>
<!-- footer.jsp 파일을 추가 -->
<%@ include file="include/footer.jsp"%>
<!-- 
<script>
	navigator.geolocation.getCurrentPosition(function(position) {
		var latitude = position.coords.latitude
		var longitude = position.coords.longitude
		alert(latitude + " : " + longitude);
		//jquery의 ajax
		$.ajax({
			//컨트롤러 
			url : 'address',
			//서비스 아이엠피엘에서 파라미터
			data : {
				'longitude' : longitude,
				'latitude' : latitude
			},
			//기본 컨트롤러
			dataType : 'json',
			success : function(data) {
				//addrDMS 
				document.getElementById('addr').innerHTML =
				//서비스 map.put result;
				data.address;
			}
		});
	});
</script>
 -->
