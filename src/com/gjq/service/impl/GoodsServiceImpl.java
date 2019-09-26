package com.gjq.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gjq.dao.GoodsDao;
import com.gjq.dao.impl.GoodsDaoImpl;
import com.gjq.pojo.Goods;
import com.gjq.service.GoodsService;
import com.gjq.util.DBUtil;

public class GoodsServiceImpl implements GoodsService {
	GoodsDao goodDao = new GoodsDaoImpl();
	@Override
	public List<Goods> findAll() {
		List<Goods> list = goodDao.findAll();
		return list;
	}
	@Override
	public void updateNumber(int number, int id) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			//程序只有在调用connection.commit()的时候才会将先前执行的sql语句一起提交到数据库，实现了数据库的事务
			conn.setAutoCommit(false);//在一个方法中执行多个sql语句时使用可以保证事务的原子性
			goodDao.updateNumber(conn, number, id);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public Goods findNumber(int id) {
		Goods goods = goodDao.findNumber(id);
 		return goods;
	}

}
