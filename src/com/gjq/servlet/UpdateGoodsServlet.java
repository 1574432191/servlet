package com.gjq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjq.pojo.Goods;
import com.gjq.service.GoodsService;
import com.gjq.service.impl.GoodsServiceImpl;

public class UpdateGoodsServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		int buynum= Integer.parseInt(req.getParameter("buynum"));
		synchronized (this) {
			GoodsService goodsService = new GoodsServiceImpl();
			Goods goods = goodsService.findNumber(id);
			int restnum = goods.getNumber()-buynum;
			goodsService.updateNumber(restnum, id);
			//这里商品购买完仍然要跳到list.jsp页面。
		   //resp.sendRedirect("list.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
