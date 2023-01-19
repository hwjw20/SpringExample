package com.jiwon.spring.ex.jstl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jstl")
public class JSTLController {

	@GetMapping("/ex01")
	public String ex01() {
		return "jstl/ex01";
	}
	
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		Integer weight = 90;
		model.addAttribute("weight", weight);
		
		List<String> fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("딸기");
		fruitList.add("바나나");

		model.addAttribute("fruitList", fruitList);
		
		// List<Map> 
		// 사용자 정보를 저장하는 Map
		
		List<Map<String, Object>> userList = new ArrayList<>();
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", "황지원");
		map.put("age", 26);
		map.put("hobby", "댄스");
		userList.add(map);
		
		map = new HashMap<>();
		map.put("name", "김바다");
		map.put("age", 4);
		map.put("hobby", "사냥");
		userList.add(map);
		
		model.addAttribute("userList", userList);
		
		
		
		
		
		return "jstl/ex02";
	}
	
	
	
}
