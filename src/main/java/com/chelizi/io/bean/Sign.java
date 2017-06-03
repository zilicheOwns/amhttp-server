package com.chelizi.io.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="dl_sign")
public class Sign implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int signId;
	private String content;
	private Date createTime;
	private int userId;
	public int getSignId() {
		return signId;
	}
	public void setSignId(int signId) {
		this.signId = signId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
