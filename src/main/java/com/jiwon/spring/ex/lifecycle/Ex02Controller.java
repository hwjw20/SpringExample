package com.jiwon.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {

	@RequestMapping("/lifecycle/ex02") // 브라우저 접근 위한 주소
	public String jspResponse() {
		return "lifecycle/ex02"; //내부적으로 쓰이는 경로
	}
}
