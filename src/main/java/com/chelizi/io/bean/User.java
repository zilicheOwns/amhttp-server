package com.chelizi.io.bean;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="dl_user")
public class User implements Serializable{
	private static final long serialVersionUID = 7769467736406744177L;
	@Id
	@GeneratedValue
	private int userId;
	@Column(nullable=false,length=20)
	private String userName;
	@Column(nullable=false)
	private String password;
	private String academy;
	private String major;
	private String classNumber;
	private String phoneNumber;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
