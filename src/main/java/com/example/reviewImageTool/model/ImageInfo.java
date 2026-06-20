package com.example.reviewImageTool.model;

public class ImageInfo {
	// 画像情報を入れておくための変数
	private String fileName;    // ファイル名
    private int width;          // 横幅
    private int height;         // 高さ
    private long size;          // 容量
    private String extension;   // 拡張子
    
    private String base64Image;
    
	
    public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
	//右クリック → ソース → ゲッターおよびセッターの生成　便利
    public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}

}
