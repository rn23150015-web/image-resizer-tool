<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>画像リサイズアプリ - 確認</title>
</head>

<body>
	<h1>画像リサイズ前の確認画面</h1>

	<h2>■ アップロードされた元の画像（プレビュー）</h2>
	<div>
		<img src="data:image/png;base64,${imageInfo.base64Image}" width="300"
			alt="プレビュー画像">
	</div>

	<h2>■ アップロードされた元の画像情報</h2>
	<ul>
		<li>ファイル名： ${imageInfo.fileName}</li>
		<li>容量（サイズ）： ${imageInfo.size} バイト</li>
		<li>元の横幅： ${imageInfo.width} px</li>
		<li>元の高さ： ${imageInfo.height} px</li>
	</ul>

	<h2>■ リサイズ後の条件</h2>
	<ul>
		<li>変換後の横幅： ${targetWidth} px</li>
		<li>変換後の高さ（自動計算）： ${resizeSetting.targetHeight} px</li>
	</ul>
	
	
	<form action="/resize" method="post">
        <button type="submit" style="font-size: 1.2em; padding: 10px 20px; background-color: #ff9900; color: white; border: none; border-radius: 5px; cursor: pointer;">
            リサイズを実行する
        </button>
    </form>

	<br>
	<a href="/">最初の画面に戻る</a>

</body>
</html>