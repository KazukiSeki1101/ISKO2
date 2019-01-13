<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>商品検索結果一覧</title>
</head>
<body>
<jsp:include page="/Login.jsp">

 <form action="/ISKO2/CartServlet?action=add" method="post">
 <input type="hidden" name="item_code" value="${item.code}">
 商品名：<b>${item.name}</b><br>
 価格：<b>${item.price}</b><br>
 <input type="submit" value="カートに入れる">

</form>
</body>
</html>