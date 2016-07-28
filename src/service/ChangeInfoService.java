package service;

import java.sql.Connection;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import util.ConnectionFactory;

/**
 * 修改个人信息
 * @author lovelope.github.io
 *
 */
public class ChangeInfoService {
private UserDao userDao = new UserDaoImpl();
	
	public boolean changeInfo(String stuNo, User user){
		Connection conn = null;
		
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			userDao.update(conn, stuNo, user);
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
