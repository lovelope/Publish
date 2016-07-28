package service;

import java.sql.Connection;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import util.ConnectionFactory;

/**
 * 添加用户到数据库
 * @author lovelope.github.io
 *
 */
public class AddUserService {
private UserDao userDao = new UserDaoImpl();
	
	public boolean add(User user){
		Connection conn = null;
		
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			userDao.save(conn, user);
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
