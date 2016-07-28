package test;

import java.sql.Connection;
import java.sql.ResultSet;

import dao.impl.MessageDaoImpl;
import util.ConnectionFactory;

public class OutMessageTest {
	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			new MessageDaoImpl();
			rs = MessageDaoImpl.getAll(conn);
			
			System.out.println("======================Message数据读出数据库开始======================");
			
			while( rs.next() ){

					System.out.println("学号：" + rs.getString("stuNo"));
					System.out.println("标题：" + rs.getString("title"));
					System.out.println("内容：" + rs.getString("content"));
					System.out.println("时间：" + rs.getString("time"));
					
					System.out.println();
			}
			
			System.out.println("======================Message数据读出数据库结束======================");
		} catch (Exception e) {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
