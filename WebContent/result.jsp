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
<jsp:include page="/LoginPage.jsp">

<c:forEach items="${items}" var="item">
商品名：<a href="/ListServlet?detail=${item.code}"><b>${item.name}</b></a><br>
価格：<b>${item.price}</b><br>
</c:forEach>
</body>
</html>