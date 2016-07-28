package service;

import java.sql.Connection;
import java.sql.ResultSet;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import util.ConnectionFactory;

/**
 * 查询学生信息
 * @author lovelope.github.io
 *
 */
public class SearchService {
	private UserDao userDao = new UserDaoImpl();
	
	public ResultSet get(int type, String content){
		Connection conn = null;
		ResultSet resultSet = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			if(type == 0){//按学号查询
				resultSet = userDao.getByNo(conn, content);
			}else{//按姓名查询
				resultSet = userDao.getByName(conn, content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
/*			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}*/
		}
		return resultSet;
	}
}
