package com.jiwon.spring.ex.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jiwon.spring.ex.mybatis.model.Review;

@Repository
public interface ReviewDAO {

	// id가 3인 데이터 조회
	public Review selectReview(@Param("id") int id);
	
}
