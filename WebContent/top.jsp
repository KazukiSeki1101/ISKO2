<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>ISKO MANGA</h1>
	<h3>検索機能</h3>
	<form action="/ISKO2/BookServlet" method="post">
		<p>タイトル</p>
		<input type="text" name="title"><br>
		<p>作者</p>
		<input type="text" name="author"><br>
		<p>出版社</p>
		<input type="text" name="publisher"><br> <select
			name="category_name">
			<option value="1">ジャンプ</option>
			<option value="2">マガジン</option>
			<option value="3">サンデー</option>
			<option value="4">スピリッツ</option>
		</select> <br> <select name="recommend_code">
			<option value="1">王道系マンガ！</option>
			<option value="2">バイオレンス×ヤクザで新境地マンガ！</option>
			<option value="3">週末に冒険したくなったらこれマンガ！</option>
			<option value="4">2019年に流行るスポーツマンガ！</option>
			<option value="5">ファッション好きに進めたいオサレなマンガ！</option>
		</select> <br> <input type="submit" value="検索">
		<input type="hidden" name="action" value="search">
	</form>
</body>
</html>