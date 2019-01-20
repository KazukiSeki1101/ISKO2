<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginPage</title>
</head>
<body>


<h1>!! ISKO MANGA !!<h1>
<br>
<br>
<br>
<br>
<form action="/ISKO2/LoginServlet" method="post">
ログインID:<input type="text" name="id"><br>
パスワード:<input type="text" name="pw"><br>
<input type="hidden" name="action" value="login">
<input type="submit" value="ログイン">

</form>
</body>
</html>