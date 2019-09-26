package com.gjq.service;

import java.util.List;

import com.gjq.pojo.Goods;

public interface GoodsService {
	List<Goods> findAll();
	void updateNumber(int id,int number);
	Goods findNumber(int id);
}
