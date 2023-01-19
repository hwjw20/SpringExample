package com.jiwon.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiwon.spring.ex.database.bo.UsedGoodsBO;
import com.jiwon.spring.ex.database.model.UsedGoods;

// request를 전달 받아서 처리하고,
// response를 정돈하는 역할
@Controller
public class UsedGoodsController {
	
	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	@ResponseBody
	@RequestMapping("/database/ex01")
	public List<UsedGoods> ex01() {
		
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		
		return usedGoodsList;
		
	}
}
