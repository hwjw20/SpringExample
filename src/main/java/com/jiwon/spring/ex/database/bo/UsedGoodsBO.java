package com.jiwon.spring.ex.database.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiwon.spring.ex.database.dao.UsedGoodsDAO;
import com.jiwon.spring.ex.database.model.UsedGoods;

@Service
public class UsedGoodsBO {

	@Autowired // 스프링이 멤버변수로 선언된 객체를 호출만하면 직접 생성해준다.
	private UsedGoodsDAO usedGoodsDAO;
	
	// used_goods 테이블 전체 데이터 조회 기능
	public List<UsedGoods> getUsedGoodsList() {
		List<UsedGoods> usedGoodsList = usedGoodsDAO.selectUsedGoodsList();
		
		return usedGoodsList;
	}
}
