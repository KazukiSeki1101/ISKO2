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
<h3>現在のカートの中身</h3>

<c:if test="${empty cart}">
現在、カートは空です。
</c:if>

<c:if test="${not empty cart}">
<table border="1">
<tr><td>商品名</td><td>単価</td>
    <td>個数</td><td>小計</td><td colspan="2">アクション</td></tr>

<c:forEach items="${cart}" var="item">
<tr>
	<td align="center">${item.title}</td>
	<td align="right">${item.price}円</td>
	<td align="right">
	<select name="quantity">
	<option <c:if test="${item.quantity eq 1}">selected</c:if> value="1">1
	<option <c:if test="${item.quantity eq 2}">selected</c:if> value="2">2
	<option <c:if test="${item.quantity eq 3}">selected</c:if> value="3">3
	<option <c:if test="${item.quantity eq 4}">selected</c:if> value="4">4
	<option <c:if test="${item.quantity eq 5}">selected</c:if> value="5">5
	</select></td>
	<td align="right">${item.price * item.quantity}円</td>
<td align="center">
<form action="/ISKO2/CartServlet?action=delete" method="post">
	<input type="hidden" name="item_code" value="${item.code}">
	<input type="submit" value="削除">
</form>
<form action="/ISKO2/CartServlet?action=update" method="post">
	<input type="hidden" name="item_code" value="${item.code}">
	<input type="submit" value="更新">
</form>
</td>
</tr>
</c:forEach>
<!-- 
<tr><td align="right" colspan="6">総計：円</td></tr>
-->
</table>

<form action="/ISKO2/BookServlet?action=search" method="post">
	<input type="submit" value="買い物を続ける">
</form>

<form action="/ISKO2/OrderServlet?action=order" method="post">
	<input type="submit" value="注文する">
</form>
</c:if>

</body>
</html>