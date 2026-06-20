package com.example.reviewImageTool.service;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.reviewImageTool.model.ImageInfo;
import com.example.reviewImageTool.model.ResizeSetting;

@Service
public class ImageService {

	public ImageInfo analyzeImage(MultipartFile file) {

		//空のインスタンスを作成
		ImageInfo info = new ImageInfo();

		//アップロードされた画像から名前と容量を調べて、インスタンスに書き込む
		info.setFileName(file.getOriginalFilename());
		info.setSize(file.getSize());

		// 画像の 横幅 と 高さ を測る
		try (InputStream is = file.getInputStream()) {

			BufferedImage image = ImageIO.read(is);

			// 画像として読み込めたら（nullでないならば）
			if (image != null) {
				// 横幅と高さをインスタンスに書き込む
				info.setWidth(image.getWidth());
				info.setHeight(image.getHeight());
			}
			//画像をBase64に変換する
			byte[] bytes = file.getBytes();// 画像をバイトにする
			String base64 = Base64.getEncoder().encodeToString(bytes);// バイトを文字列に変換
			info.setBase64Image(base64);//インスタンスに書き込む

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		//書き込み終わったインスタンスを返す
		return info;
	}
	

    // 変更後の高さを計算して、ResizeSettingを作って返すメソッド
    public ResizeSetting calculateResizeSetting(int originalWidth, int originalHeight, int targetWidth) {
        
        //新しいインスタンスを作る
        ResizeSetting setting = new ResizeSetting();
        setting.setTargetWidth(targetWidth);
        
        //doubleをつけて比率を計算する
        double ratio = (double) targetWidth / originalWidth;
        
        //元の高さに比率を掛けて、新しい高さを出す
        int targetHeight = (int) (originalHeight * ratio);
        
        
        //計算した高さを計算して、完成したインスタンスを返す
        setting.setTargetHeight(targetHeight);
        return setting;
    }
    
 // 画像を小さく加工するメソッド
 	public String resizeImage(ImageInfo info, ResizeSetting setting) {
 		try {
 			
 			//Base64をバイトに戻す
 			byte[] imageBytes = Base64.getDecoder().decode(info.getBase64Image());
 			ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
 			BufferedImage originalImage = ImageIO.read(bais);

 			//新しい領域を作る
 			int newWidth = setting.getTargetWidth();
 			int newHeight = setting.getTargetHeight();
 			
 			
 			BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

 			//Graphics2Dを呼んで、リサイズする
 			Graphics2D g2d = resizedImage.createGraphics();
 			g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
 			g2d.dispose(); 
 			
 			
 			//完成した画像を、Base64で返す
 			ByteArrayOutputStream baos = new ByteArrayOutputStream();
 			ImageIO.write(resizedImage, "jpg", baos); // ひとまずJPG形式で出力
 			byte[] resizedBytes = baos.toByteArray();
 			
 			return Base64.getEncoder().encodeToString(resizedBytes);

 		} catch (Exception e) {
 			e.printStackTrace();
 			return null; 
 		}
 	}


}
