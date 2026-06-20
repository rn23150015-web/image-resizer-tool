<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>画像リサイズアプリ - リサイズ終了</title>
</head>
<body>
	<p>画像のサイズ変更が完了しました。</p>

	<h2>■ リサイズ実行後画像</h2>
	<div>
		<img src="data:image/jpeg;base64,${resultImage}" alt="リサイズされた画像"
			style="border: 2px solid #333;">
	</div>

	<br>
	<br>

	<a href="data:image/jpeg;base64,${resultImage}"
		download="resized_image.jpg"
		style="display: inline-block; padding: 15px 30px; background-color: #48bb78; color: white; text-decoration: none; border-radius: 5px; font-weight: bold; font-size: 1.1em;">
		画像をダウンロードする </a>

	<br>
	<br>
	<br>
	<a href="/">トップに戻る</a>

</body>
</html>