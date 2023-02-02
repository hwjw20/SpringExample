package com.jiwon.spring.ex.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiwon.spring.ex.ajax.bo.UserBO;
import com.jiwon.spring.ex.jsp.model.NewUser;

@Controller
@RequestMapping("/ajax/user")
public class UserController {

	@Autowired
	private UserBO userBO;
	
	@GetMapping("/list")
	public String userList(Model model) {
		List<NewUser> userList = userBO.getUserList();
		
		model.addAttribute("userList", userList);
		
		return "ajax/user/list";
	}
	
	@GetMapping("/add")
	@ResponseBody
	public Map<String, String> addUser(
			@RequestParam("name") String name
			, @RequestParam("yyyymmdd") String yyyymmdd
			, @RequestParam("email") String email) {
		
		int count = userBO.addUser(name, yyyymmdd, email);
		
		// insert 성공 여부를 데이터로 만든다
		// {"result":"success"} or {"result":"fail"}
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
		
//		return "redirect:/ajax/user/list";
	}
	
	@GetMapping("/input")
	public String userInput() {
		return "ajax/user/input";
	}
	
	// email 주소를 전달 받고
	// 해당 주소가 new_user 테이블에 존재하는지 확인하는 API(리퀘스트 전달 받아 그 데이터를 json 형태의 리스펀스로 처리하는 화면. api 말고 다른 화면인 view는 html로 처리함)
	// 이메일 중복 여부 확인 API
	@GetMapping("/is_duplicate")
	@ResponseBody
	public Map<String, Boolean> isDuplicateEmail(@RequestParam("email") String email) {
		
		// {"is_duplicate":true} or {"is_duplicate":false}
		Map<String, Boolean> result = new HashMap<>();
		
		if(userBO.isDulicateEmail(email)) {
			// 중복된 경우
			result.put("is_duplicate", true);
		} else {
			// 중복되지 않은 경우
			result.put("is_duplicate", false);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
