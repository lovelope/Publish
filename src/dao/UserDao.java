package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public interface UserDao {
	public void save(Connection conn, User user) throws SQLException;
	
	public void update(Connection conn, String stuNo, User user) throws SQLException;
	
	public void delete(Connection conn, String stuNo) throws SQLException;
	
	public ResultSet get(Connection conn, User user) throws SQLException;

	public ResultSet getByNo(Connection conn, String content) throws SQLException;

	public ResultSet getByName(Connection conn, String content) throws SQLException;
}
