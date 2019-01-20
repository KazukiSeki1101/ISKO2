<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
</head>
<body>

<jsp:include page="/LoginPage.jsp"/>

<p>商品名：${items.title2}</p>
<p>作者：${items.author2}</p>
<p>出版社：${items.publisher2}</p>
<p>カテゴリー：${items.category}2</p>
<p>おすすめ：${items.recommend2}</p>
<form action="/ISKO2/BookServlet" method="post">
	<input type="submit" value="検索結果へ戻る">
</form>

<form action="/ISKO2/CartServlet?action=add" method="post">
	<input type="submit" value="カートに入れる">
</form>

</body>
</html>