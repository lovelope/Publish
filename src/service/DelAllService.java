package service;

import java.sql.Connection;

import dao.MessageDao;
import dao.UserDao;
import dao.impl.MessageDaoImpl;
import dao.impl.UserDaoImpl;
import util.ConnectionFactory;

/**
 * 删除所有个人信息
 * @author lovelope.github.io
 *
 */
public class DelAllService {
	private UserDao userDao = new UserDaoImpl();
	private MessageDao msgDao = new MessageDaoImpl();
	public boolean delAll(String stuNo){
		Connection conn = null;
		
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			userDao.delete(conn, stuNo);
			msgDao.delAll(conn, stuNo);
			
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return false;
	}
}
