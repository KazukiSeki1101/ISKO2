<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome shopping!</title>
</head>
<body>

<p align="right">さん、こんにちは</p><br>
<h3>ご注文商品</h3>

<c:if test="${not empty cart.items}">
<table border="1">
<tr><td>商品名</td><td>単価(税込)</td><td>個数</td><td>小計</td></tr>

<c:forEach items="${cart.items}" var="item">
<tr>
	<td align="center">${item.value.name}</td>
	<td align="right">${item.value.price}円</td>
	<td align="right">1</td>
	<td align="right">${item.value.price * 1}円</td>
</tr>
</c:forEach>
<tr><td align="right" colspan="6">総計：${cart.total}円</td></tr>
</table>
<br>

<form action="/ISKO2/OrderServlet" method="post">
<p>お支払い方法を選択してください。</p>
<input type="radio" name="pay" value="cash">現金
<input type="radio" name="pay" value="card">クレジットカード
</form>

<a href="/ISKO2/buy.jsp" method="post">
<input type="submit" value="確定">
</a>

</c:if>

</body>
</html>