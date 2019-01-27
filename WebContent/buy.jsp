<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome shopping!</title>
</head>
<body>

<h3>isko さん、以下の内容で注文が確定しました。</h3>


<h3>ご注文ありがとうございました。</h3>

<table border="1">
<tr><td>商品名</td><td>単価</td><td>個数</td><td>小計</td></tr>
<c:forEach items="${cart}" var="item" varStatus="stat">
<tr>
	<td align="center">${item.title}</td>
	<td align="right">${item.price}円</td>
	<td align="right">${item.quantity}</td>
	<td align="right">${item.price * item.quantity}円</td>
</tr>
</c:forEach>
<tr><td align="right" colspan="6">総計：${totalprice}円</td></tr>
</table>
<form action="/ISKO2/top.jsp" method="post">
<input type="submit" value="topページへ">
</form>

</body>
</html>

