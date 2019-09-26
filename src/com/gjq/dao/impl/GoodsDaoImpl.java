package com.gjq.dao.impl;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gjq.dao.GoodsDao;
import com.gjq.pojo.Goods;
import com.gjq.util.DBUtil;


public class GoodsDaoImpl implements GoodsDao{
	//QueryRunner:SQL语句的操作对象，可以设置查询结果集的封装策略，线程安全
	private QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
	@Override
	public List<Goods> findAll() {
		String sql = "select * from goods";
		try {
			return qr.query(sql,new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("商品查询失败");
		}
		
		
	}
	@Override
	public void updateNumber(Connection conn, int number,int id) {
		System.out.println(id+"jhhh"+number);
		String sql = "update goods set number=? where id=?";
		try {
			qr.update(conn, sql,number, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("更新数据失败");
		}
		
	}
	@Override
	public Goods findNumber(int id) {
		String sql = "select * from goods where id=?";
		Goods goods;
		try {
			goods = qr.query(sql,new BeanHandler<Goods>(Goods.class),id);
			return goods;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败");
		}
		
	}

}
