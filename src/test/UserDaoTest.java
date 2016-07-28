package test;

import java.sql.Connection;
import java.text.SimpleDateFormat;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import util.ConnectionFactory;

public class UserDaoTest {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			UserDao userDao = new UserDaoImpl();
			User tom = new User();

			tom.setStuNo("13030990011");
			tom.setPassword("123456");
			tom.setName("Tom");
			tom.setEmail("tom@gmail.com");
			tom.setPhone("18822221111");
			tom.setSex("男");

			String s = "2012-06-21 00:10:00";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date d1 = sdf.parse(s); // 先把字符串转为util.Date对象
			java.sql.Date d2 = new java.sql.Date(d1.getTime()); // 再转换为sql.Date对象
			tom.setBirthday(d2);

			tom.setJob("班长");

			userDao.save(conn, tom);
			conn.commit();
			System.out.println("======================User数据存入数据库成功======================");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("======================回滚======================");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
