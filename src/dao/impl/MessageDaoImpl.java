package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.mysql.jdbc.PreparedStatement;

import dao.MessageDao;
import entity.Message;

public class MessageDaoImpl implements MessageDao{

	/**
	 * 添加一个Message
	 */
	public void save(Connection conn, Message msg) throws SQLException {
		String saveSql = "INSERT INTO message(mesNo, title, content, time, stuNo) VALUES (?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) conn.prepareCall(saveSql);
		
		ps.setInt(1, msg.getMesNo());
		ps.setString(2, msg.getTitle());
		ps.setString(3, msg.getContent());
		ps.setTimestamp(4, new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));//获取当前时间
		ps.setString(5, msg.getStuNo());

		ps.execute();
	}

	/**
	 * 按mesNo修改Message
	 */
	public void update(Connection conn, long id, Message msg) throws SQLException {
		String saveSql = "UPDATE message SET title = ?, content = ?, time = ?, stuNo = ? WHERE mesNo = ?";
		PreparedStatement ps = (PreparedStatement) conn.prepareCall(saveSql);
		
		ps.setString(1, msg.getTitle());
		ps.setString(2, msg.getContent());		
		ps.setTimestamp(3, new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));//获取当前时间
		ps.setString(4, msg.getStuNo());
		ps.setInt(5, msg.getMesNo());

		ps.execute();
	}

	/**
	 * 按mesNo删除Message
	 */
	public void delete(Connection conn, Message msg) throws SQLException {
		String updateSql = "DELETE FROM message WHERE mesNo = ?";
		PreparedStatement ps = (PreparedStatement) conn.prepareCall(updateSql);
		
		ps.setInt(1, msg.getMesNo());
		ps.execute();
	}

	/**
	 * 按stuNo查找该用户的Message
	 */
	public ResultSet get(Connection conn, Message msg) throws SQLException {
		String getSql = "SELECT * FROM message WHERE stuNo = ?";
		PreparedStatement ps = (PreparedStatement) conn.prepareCall(getSql);
		
		ps.setString(1, msg.getStuNo());

		return ps.executeQuery();
	}
	
	/**
	 * 按stuNo删除该用户的所有Message
	 */
	public void delAll(Connection conn, String stuNo) throws SQLException {
		String getSql = "DELETE FROM message WHERE stuNo = ?";
		PreparedStatement ps = (PreparedStatement) conn.prepareCall(getSql);
		
		ps.setString(1, stuNo);

		ps.execute();
	}
	
	/**
	 * 查找所有Message
	 */
	public static ResultSet getAll(Connection conn) throws SQLException {
		String getSql = "SELECT * FROM message";
		PreparedStatement ps = (PreparedStatement) conn.prepareCall(getSql);

		return ps.executeQuery();
	}
}
