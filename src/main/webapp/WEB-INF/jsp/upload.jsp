<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>画像リサイズアプリ</title>
</head>
<body>
	<form action="/confirm" method="post" enctype="multipart/form-data">
	
	<div>
		<label for="imageFile">①：画像を選択（JPG・PNG）</label>
		<%//画像ファイルを選択するボタン %>
		<input type="file" id="imageFile" name="imageFile" accept="image/*" required>
	</div>
	
	<br>
	
	<div>
		<label for="targetWidth">②：変換後の横幅（ピクセル）</label>
		<%//横幅を入力する場所 %>
		<input type="number" id="targetWidth" name="targetWidth" min="1" max="3000" placeholder="例: 800" required> px
	</div>
	
	<br>
	
	<button type="submit">確認画面へ進む</button>
	</form>
</body>
</html>