package com.jiwon.spring.ex.mybatis.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiwon.spring.ex.mybatis.dao.ReviewDAO;
import com.jiwon.spring.ex.mybatis.model.Review;

@Service
public class ReviewBO {

	@Autowired
	private ReviewDAO reviewDAO;
	
	// 파라미터로 전달 받은 id 데이터 조회
	public Review getReview(int id) {
		Review review = reviewDAO.selectReview(id);
		return review;
	}
	
}
