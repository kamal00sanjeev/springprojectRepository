package com.qrc.demo;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.zxing.WriterException;

@Controller
@RequestMapping("/app")
public class SecureController {

	private static final String QR_CODE_IMAGE_PATH = "src/main/resources/image/MyQRCode.png";

	@GetMapping("/test")
	@ResponseBody
	public String secured() {
		System.out.println("Inside secured()");
		return "Hello user !!! : " + new Date();
	}

	@RequestMapping(value = "/qrcode", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public void getImage(HttpServletResponse response) throws IOException {

		try {
			QRCodeGenerator.generateQRCodeImage("Hello Sanjeev!", 300, 300, QR_CODE_IMAGE_PATH);
		} catch (WriterException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("QRCode generated!");
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(new ClassPathResource("image/MyQRCode.png").getInputStream(), response.getOutputStream());
	}

}
