package com.collab.CollaborationBack.Dao;

import java.util.List;

import com.collab.CollaborationBack.model.Blog;

public interface BlogDao {

	
	public boolean createBlog(Blog blog);
	public boolean editBlog(int blogID);
	public boolean deleteBlog(int blogID);
	public Blog getBlog(int blogID);
	public List<Blog> getAllBlogs();
	public boolean approveBlog(Blog blog);
}
