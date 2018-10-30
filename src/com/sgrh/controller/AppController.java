package com.sgrh.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.base.Strings;

@Controller
public class AppController {
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("form_submission")
	public String form_submit(Model model, @RequestParam("img") String img, HttpServletRequest request) {
		String image = img.substring(img.indexOf(",")+1);
		Decoder decoder = Base64.getDecoder();
		byte [] imageBytes = decoder.decode(image);
		System.out.println(request.getCharacterEncoding());
		try {
			BufferedImage bfImage = ImageIO.read(new ByteArrayInputStream(imageBytes));
			File file = Paths.get(request.getServletContext().getRealPath(File.separator),"/resources/test.png").toFile();
			ImageIO.write(bfImage, "png", file);
			bfImage.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "result_page";
	}
}
