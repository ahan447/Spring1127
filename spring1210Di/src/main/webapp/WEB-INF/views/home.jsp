<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<a href="birth">birth</a>
<form action="upload" method="post"
enctype="multipart/form-data">
	file<input type="file" name="file" /> <br/>
	<input type="submit" value="send"/><br/>
</form>
</body>
</html>
