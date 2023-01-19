package com.jiwon.spring.ex.database.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jiwon.spring.ex.database.model.UsedGoods;

@Repository
public interface UsedGoodsDAO {

	// used_goods 테이블 전체 조회
	public List<UsedGoods> selectUsedGoodsList(); 
}
