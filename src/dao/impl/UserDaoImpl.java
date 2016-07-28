package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import dao.UserDao;
import entity.User;

public class UserDaoImpl implements UserDao{
	/**
	 * 保存用户信息
	 */
	public void save(Connection conn, User user) throws SQLException {
		String saveSql = "INSERT INTO student(stuNo, password, name, email, phone, sex, birthday, job) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps =(PreparedStatement) conn.prepareStatement(saveSql);
		
		ps.setString(1, user.getStuNo());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getName());		
		ps.setString(4, user.getEmail());
		ps.setString(5, user.getPhone());
		ps.setString(6, user.getSex());
		ps.setDate(7, (Date) user.getBirthday());
		ps.setString(8, user.getJob());
		
		int lines = ps.executeUpdate();
		System.out.println("本次执行影响了" + lines + "行");
	}
	
	/**
	 * 根据用户指定的stuNo更新用户信息
	 */
	public void update(Connection conn, String stuNo, User user) throws SQLException {
		String updateSql = "UPDATE student SET password = ?, name = ?, email = ?, phone = ?, sex = ?,birthday = ?, job = ? WHERE stuNo = ?";
		PreparedStatement ps = (PreparedStatement) conn.prepareCall(updateSql);
		
		ps.setString(1, user.getPassword());
		ps.setString(2, user.getName());		
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getPhone());
		ps.setString(5, user.getSex());
		ps.setDate(6, (Date) user.getBirthday());
		ps.setString(7, user.getJob());
		ps.setString(8, stuNo);
		
		int lines = ps.executeUpdate();
		System.out.println("本次执行影响了" + lines + "行");
	}

	/**
	 * 删除指定的用户信息
	 */
	public void delete(Connection conn, String stuNo) throws SQLException {
		String updateSql = "DELETE FROM student WHERE stuNo = ?";
		PreparedStatement ps = (PreparedStatement) conn.prepareCall(updateSql);
		
		ps.setString(1, stuNo);
		
		int lines = ps.executeUpdate();
		System.out.println("本次执行影响了" + lines + "行");
	}

	/**
	 * 按学号和密码查找student
	 */
	public ResultSet get(Connection conn, User user) throws SQLException {
		String getSql = "SELECT * FROM student WHERE stuNo = ? AND password = ?";
		PreparedStatement ps = (PreparedStatement) conn.prepareCall(getSql);
		
		ps.setString(1, user.getStuNo());
		ps.setString(2, user.getPassword());

		return ps.executeQuery();
	}
	
	/**
	 * 按学号查找student
	 */
	public ResultSet getByNo(Connection conn, String stuNo) throws SQLException {
		String getSql = "SELECT * FROM student WHERE stuNo = ?";
		PreparedStatement ps = (PreparedStatement) conn.prepareCall(getSql);
		
		ps.setString(1, stuNo);

		return ps.executeQuery();
	}
	
	/**
	 * 按姓名查找student
	 */
	public ResultSet getByName(Connection conn, String name) throws SQLException {
		String getSql = "SELECT * FROM student WHERE name = ?";
		PreparedStatement ps = (PreparedStatement) conn.prepareCall(getSql);
		
		ps.setString(1, name);

		return ps.executeQuery();
	}
	
	/**
	 * 查询所有student
	 */
	public static ResultSet getAll(Connection conn) throws SQLException {
		String getSql = "SELECT * FROM student";
		PreparedStatement ps = (PreparedStatement) conn.prepareCall(getSql);

		return ps.executeQuery();
	}
}
