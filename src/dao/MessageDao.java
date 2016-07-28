package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Message;

public interface MessageDao {
	public void save(Connection conn, Message msg) throws SQLException;

	public void update(Connection conn, long id, Message msg) throws SQLException;

	public void delete(Connection conn, Message msg) throws SQLException;

	public ResultSet get(Connection conn, Message msg) throws SQLException;

	public void delAll(Connection conn, String stuNo) throws SQLException;	
}
