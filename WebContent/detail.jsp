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

<jsp:include page="/LoginPage.jsp">

<p>商品名：${items.title}</p>
<p>作者：${items.author}</p>
<p>出版社：${items.publisher}</p>
<p>カテゴリー：${items.category}</p>
<p>おすすめ：${items.recommend}</p>
[検索結果へ戻る]<br>
[カートに入れる]<br>

</body>
</html>