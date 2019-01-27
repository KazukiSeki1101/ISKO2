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

<p align="right">isko さん、こんにちは</p><br>
<h3>ご注文商品</h3>

<c:if test="${not empty cart}">
<table border="1">
<tr><td>商品名</td><td>単価</td><td>個数</td><td>小計</td><td colspan="2"></tr>
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
<br>
<form action="/ISKO2/OrderServlet" method="post">
	<input type="hidden" name="action" value="end">
	<input type="submit" value="注文する">
</form>
<input type="submit" value="確定">
</c:if>

</body>
</html>