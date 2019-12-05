<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
</head>
<body>
<div align='center' class='body'>
	<h2>상품 상세 보기</h2>
	<table>
		<tr>
		<td><img src="../img/${item.pictureurl}" /></td>
		<td align="center">
			<table>
				<tr height="50">
					<td width="100">상품명</td>
					<td width="200">${item.itemname}</td>
					</tr>
				<tr height="50">
					<td width="100">가격</td>
					<td width="200">${item.price}</td>
					</tr>
				<tr height="50">
					<td width="100">설명</td>
					<td width="200">${item.description}</td>
					</tr>
				<tr height="50">
					<td colspan="2" align='center'>
					<a href="../">목록으로 돌아가기</a>
					</td>
					</tr>	
				</table>
			</td>
		</tr>
	</table>
</div>

<!-- ${item} -->
</body>
</html>