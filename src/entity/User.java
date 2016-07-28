package entity;

import java.util.Date;

public class User extends IdEntity {
	private String stuNo;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String sex;
	private Date birthday;
	private String job;

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "User [stuNo=" + stuNo + ", password=" + password + ", name=" + name + ", email=" + email + ", phone="
				+ phone + ", sex=" + sex + ", birthday=" + birthday + ", job=" + job + "]";
	}

}
