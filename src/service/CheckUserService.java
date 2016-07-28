package service;

import java.sql.Connection;
import java.sql.ResultSet;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import util.ConnectionFactory;

/**
 * 检测用户是否已注册
 * @author lovelope.github.io
 *
 */
public class CheckUserService {
	private UserDao userDao = new UserDaoImpl();
	
	public boolean check(User user){
		Connection conn = null;
		
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet resultSet = userDao.get(conn, user);
			
			while(resultSet.next()){
				return true;
			}
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
