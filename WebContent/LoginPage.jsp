<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginPage</title>
</head>
<body>

<form action="/ISKO/LogiServlet" method="post">

<input type="hidden"name="action" value="logout">
<input type="submit" value="ログアウト">

</form>

</body>
</html>