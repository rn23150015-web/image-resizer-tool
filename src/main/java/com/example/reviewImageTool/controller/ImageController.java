package com.example.reviewImageTool.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.reviewImageTool.model.ImageInfo;
import com.example.reviewImageTool.model.ResizeSetting;
import com.example.reviewImageTool.service.ImageService;

@Controller
public class ImageController {
	
	//ControllerからServiceに画像情報を引き渡す
	@Autowired
	private ImageService imageService;

	@GetMapping("/")
	public String shouUploadPage() {
		return "upload";
	}
	
	@PostMapping("/confirm")
	public String showConfirmPage(
			@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("targetWidth") int targetWidth,
			Model model,
			HttpSession session
			) {
		
		//Serviceに画像を渡して、ImageInfoインスタンスを作る
				ImageInfo info = imageService.analyzeImage(imageFile);
			
				//Controllerに元の横幅・元の高さ・変更後の横幅を伝えて、高さを計算
				ResizeSetting setting = imageService.calculateResizeSetting(info.getWidth(), info.getHeight(), targetWidth);
				
				//セッションにデータを入れる
				session.setAttribute("sessionImageInfo", info);
				session.setAttribute("sessionResizeSetting", setting);
				
				//Modelにデータを入れる
				model.addAttribute("imageInfo", info);
				model.addAttribute("targetWidth", targetWidth);
				model.addAttribute("resizeSetting", setting);
				
	    return "confirm";
	}
	
	@PostMapping("/resize")
	public String executeResize(HttpSession session, Model model) { 
		
		//セッションからデータを引き出す
		ImageInfo info = (ImageInfo) session.getAttribute("sessionImageInfo");
		ResizeSetting setting = (ResizeSetting) session.getAttribute("sessionResizeSetting");
		
		System.out.println("リサイズOK");
		System.out.println("対象ファイル: " + info.getFileName());
		System.out.println("目標の横幅: " + setting.getTargetWidth() + " px");
		System.out.println("目標の高さ: " + setting.getTargetHeight() + " px");
		
		//Serviceで処理しデータを受け取る
		String resizedBase64 = imageService.resizeImage(info, setting);
		
		model.addAttribute("resultImage", resizedBase64);
		
		return "result";
	}
}
