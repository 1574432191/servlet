package com.gjq.dao;

import java.sql.Connection;
import java.util.List;

import com.gjq.pojo.Goods;

public interface GoodsDao {
	//查找所有商品
	List<Goods> findAll();
	//购买商品时,修改厂库中商品的数量
	void updateNumber(Connection conn,int id,int number);
	//根据id查看商品的库存数
	Goods findNumber(int id);
	
}
