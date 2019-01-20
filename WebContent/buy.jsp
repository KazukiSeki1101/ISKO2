<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome shopping!</title>
</head>
<body>

<h3>さん、以下の内容で注文が確定しました。</h3>

<p>お客様の注文番号は</p>
<h3><font color="red">${orderNumber}</font></h3>
<p>です</p>

<h3>ご注文ありがとうございました。</h3>

<form action="/ISKO2/top.jsp" method="post">
<input type="submit" value="topページへ">
</form>

</body>
</html>

