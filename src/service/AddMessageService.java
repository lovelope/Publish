package service;

import java.sql.Connection;

import dao.MessageDao;
import dao.impl.MessageDaoImpl;
import entity.Message;
import util.ConnectionFactory;

/**
 * 添加留言到数据库
 * @author lovelope.github.io
 *
 */
public class AddMessageService {
private MessageDao msgDao = new MessageDaoImpl();
	
	public boolean add(Message msg){
		Connection conn = null;
		
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			msgDao.save(conn, msg);
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
