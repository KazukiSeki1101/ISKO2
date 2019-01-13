<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/Login.html" action="page"></jsp:include>
<h1>ISKO MANGA</h1>
<h3>検索機能</h3>
<p>タイトル</p><input type="text" name="title"><br>
<p>作者</p><input type="text" name="author"><br>
<p>出版社</p><input type="text" name="publisher"><br>
<form>
<select name="category_name">
<option value="1">カテゴリー1の名前</option>
<option value="2">カテゴリー2の名前</option>
<option value="3">カテゴリー3の名前</option>
<option value="4">カテゴリー4の名前</option>
</select>
<br>
<select name="recommend_code">
<option value="1">おすすめ1の名前</option>
<option value="2">おすすめ2の名前</option>
<option value="3">おすすめ3の名前</option>
<option value="4">おすすめ4の名前</option>
</select>
</form>
</body>
</html>