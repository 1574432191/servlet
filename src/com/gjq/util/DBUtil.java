package com.gjq.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBUtil {
	private static ComboPooledDataSource cpd;
	static {
		cpd=new ComboPooledDataSource();
	}
	public static DataSource getDataSource() {
		return cpd;
	}
	public static Connection getConnection() throws SQLException {
		
		return cpd.getConnection();
	}
	
	public static void release(Statement stmt,Connection conn) {
		try {
			if(stmt!=null) {
				stmt.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void release(ResultSet rs,Statement stmt,Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		release(stmt, conn);
	}
}
