package test;

import java.sql.Connection;

import dao.MessageDao;
import dao.impl.MessageDaoImpl;
import entity.Message;
import util.ConnectionFactory;

public class MessageDaoTest {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			MessageDao msgDao = new MessageDaoImpl();
			Message msg = new Message();
			
			msg.setTitle("留言1");
			msg.setContent("这条留言用于测试.");
			msg.setTime();
			msg.setStuNo("13030990011");

			msgDao.save(conn, msg);
			conn.commit();
			System.out.println("======================Message数据存入数据库成功======================");
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
