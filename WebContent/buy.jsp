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
<h3>ご注文ありがとうございました。</h3>

<table border="1">
<tr><td>商品名</td><td>単価(税込)</td><td>個数</td><td>小計</td></tr>

<c:forEach items="${cart.items}" var="item">
<tr>
	<td align="center">${item.value.name}</td>
	<td align="right">${item.value.price}円</td>
	<td align="right">${item.value.quantity}</td>
	<td align="right">${item.value.price * item.value.quantity}円</td>
</tr>
</c:forEach>
<tr><td align="right" colspan="6">総計：${cart.total}円</td></tr>
</table>

<input type="submit" value="topページへ">

</body>
</html>

