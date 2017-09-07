package com.collab.Collaboration.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class BlogComment {
	
	private Integer bcId;
	private Integer blogId;
	private String comment;
	private Date commentDate;
	private Integer userId;
	public Integer getBcId() {
		return bcId;
	}
	public void setBcId(Integer bcId) {
		this.bcId = bcId;
	}
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private String userName;
	
	

}
