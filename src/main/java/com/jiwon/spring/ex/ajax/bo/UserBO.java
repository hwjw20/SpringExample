package com.jiwon.spring.ex.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiwon.spring.ex.ajax.dao.UserDAO;
import com.jiwon.spring.ex.jsp.model.NewUser;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;
	
	public List<NewUser> getUserList(){
		return userDAO.selectUserList();
	}
	
	public int addUser(String name, String yyyymmdd, String email) {
		return userDAO.insertUser(name, yyyymmdd, email);
	}
	
	// 이메일 중복 여부를 알려주는 기능
	public boolean isDulicateEmail(String email) {
		int count = userDAO.selectCountEmail(email);

		if(count == 0) {
			// count 가 0이면 중복 아님
			return false;
		} else {
			// count 가 0이 아니면 중복
			return true;
		}
	}
}
