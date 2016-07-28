package test;

import java.sql.Connection;
import java.sql.ResultSet;

import dao.impl.UserDaoImpl;
import util.ConnectionFactory;

public class OutUser {
	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			new UserDaoImpl();
			rs = UserDaoImpl.getAll(conn);

			System.out.println("======================Student数据读出数据库开始======================");

			while (rs.next()) {

				System.out.println("学号：" + rs.getString("stuNo"));
				System.out.println("姓名：" + rs.getString("name"));
				System.out.println("手机：" + rs.getString("phone"));
				System.out.println("邮箱：" + rs.getString("email"));

				System.out.println();
			}

			System.out.println("======================Student数据读出数据库结束======================");
		} catch (Exception e) {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
