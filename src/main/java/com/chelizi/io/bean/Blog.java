package com.chelizi.io.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 博客表
 * @author Eddie
 *
 */
@Entity
@Table(name="dl_blog")
public class Blog implements Serializable{
	
	private static final long serialVersionUID = 6762742628959258802L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	@Lob
	private String content;
	private String imageUrl;
	private String author;
	private String createdAt;
	private String updatedAt;
	private String origin;
	private int loveCount;//赞的数量
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public int getLoveCount() {
		return loveCount;
	}
	public void setLoveCount(int loveCount) {
		this.loveCount = loveCount;
	}
	
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", imageUrl=" + imageUrl + ", author="
				+ author + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", origin=" + origin
				+ ", loveCount=" + loveCount + "]";
	}

	
	
}
