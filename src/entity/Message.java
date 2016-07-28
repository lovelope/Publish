package entity;

import java.util.Date;

public class Message {
	private int mesNo;
	private String title;
	private String content;
	private Date time;
	private String stuNo;

	public int getMesNo() {
		return mesNo;
	}

	public void setMesNo(int mesNo) {
		this.mesNo = mesNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	
	public void setTime() {
		this.time = new Date();
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}


	@Override
	public String toString() {
		return "Message [mesNo=" + mesNo + ", title=" + title + ", content=" + content +", time="
				+ time + ", stuNo=" + stuNo +  "]";
	}

}
