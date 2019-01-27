<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.ArrayList" %>   
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
</head>
<body>

<jsp:include page="/LoginPage.jsp"/>
<p>商品画像<p>

<c:forEach items="${items}" var="item">
<p>商品名：${item.title}</p>
<p>作者：${item.author}</p>
<p>出版社：${item.publisher}</p>
<p>カテゴリー：${item.category}</p>
<p>おすすめ：${item.recommend}</p>


<form action="/ISKO2/BookServlet" method="post">
	<input type="submit" value="検索結果へ戻る">
</form>

<form action="/ISKO2/CartServlet?action=add" method="post">
	<input type="submit" value="カートに入れる">
</form>
</c:forEach>
</body>
</html>