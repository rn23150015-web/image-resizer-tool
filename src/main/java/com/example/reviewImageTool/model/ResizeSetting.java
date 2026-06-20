package com.example.reviewImageTool.model;

public class ResizeSetting {

	// ① 利用者が指定した横幅と、自動計算した高さを入れておく変数

	private int targetWidth;//変換後の横幅
	private int targetHeight;//変換後の高さ

	public int getTargetWidth() {
		return targetWidth;
	}

	public void setTargetWidth(int targetWidth) {
		this.targetWidth = targetWidth;
	}

	public int getTargetHeight() {
		return targetHeight;
	}

	public void setTargetHeight(int targetHeight) {
		this.targetHeight = targetHeight;
	}

}
