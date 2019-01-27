<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>商品検索結果一覧</title>
</head>
<body>

<jsp:include page="/LoginPage.jsp"/>
<c:forEach items="${items}" var="item">

商品名：<a href="/ISKO2/ListServlet?action=detail&item_code=${item.code}">
<b>${item.title}</b></a><br>
価格：<b>${item.price}</b><br>


<form action="/ISKO2/CartServlet" method="post">
<input type="hidden" name="action" value="add">
<input type="hidden" name="title" value="${item.title}">
<input type="hidden" name="price" value="${item.price}">
<input type="hidden" name="code" value="${item.code}">
<input type="hidden" name="quantity" value="1">

商品名：<a href="/ISKO2/ListServlet?action=detail&item_code=${item.code}">
<b>${item.title}</b></a><br>
価格：<b>${item.price}</b><br>

<input type="submit" value="カートに入れる">
</form>
</c:forEach>

</body>
</html>