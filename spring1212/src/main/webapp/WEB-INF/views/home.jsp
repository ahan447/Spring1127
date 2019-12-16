<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header.jsp 파일을 추가 -->
<%@ include file="include/header.jsp" %>

<section class="content">
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
	
	
		</c:if>
		
	
		<div class="box-header with-border">
			<a href="user/join"><h3 class='box-title'>회원가입</h3></a>		
		</div>
	</div>
</section>

<!-- footer.jsp 파일을 추가 -->
<%@ include file="include/footer.jsp" %>



