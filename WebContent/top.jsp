<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<jsp:include page="/Youkoso.jsp" />

	<h1>ISKO MANGA</h1>
	<h3>検索機能</h3>
	<form action="/ISKO2/BookServlet" method="post">
		<p>タイトル</p>
		<input type="text" name="title" value=""><br>
		<p>作者</p>
		<input type="text" name="author" value=""><br>
		<p>出版社</p>
		<input type="text" name="publisher" value=""><br>
		<select name="category_name">
			<option value="">雑誌を選んでください</option>
			<option value="ジャンプ">ジャンプ</option>
			<option value="マガジン">マガジン</option>
			<option value="サンデー">サンデー</option>
			<option value="スピリッツ">スピリッツ</option>
		</select><br>
		<select name="recommend_code">
			<option value="">おすすめジャンルを選んでください</option>
			<option value="王道系マンガ！">王道系マンガ！</option>
			<option value="バイオレンス×ヤクザで新境地マンガ！">バイオレンス×ヤクザで新境地マンガ！</option>
			<option value="週末に冒険したくなったらこれマンガ！">週末に冒険したくなったらこれマンガ！</option>
			<option value="2019年に流行るスポーツマンガ！">2019年に流行るスポーツマンガ！</option>
			<option value="ファッション好きに進めたいオサレなマンガ！">ファッション好きに進めたいオサレなマンガ！</option>
		</select><br>
		<input type="submit" value="検索">
		<input type="hidden" name="action" value="search">
	</form>
</body>
</html>