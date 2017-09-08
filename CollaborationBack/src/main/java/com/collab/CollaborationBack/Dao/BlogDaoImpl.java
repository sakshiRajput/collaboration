package com.collab.CollaborationBack.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collab.CollaborationBack.model.Blog;

@Repository("blogDao")
public class BlogDaoImpl implements BlogDao{

	
	@Autowired
	SessionFactory sessionFactory;
	

	
	public BlogDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("session created");
	}
	

//	@Override
	@Transactional
	public boolean createBlog(Blog blog) {
		try 
		{
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
		
	}
	public boolean editBlog(int blogId) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean deleteBlog(int blogId) {
		// TODO Auto-generated method stub
		return false;
	}
	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Blog> getAllBlogs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog where status='A'");
		List<Blog> listblog=query.list();
		return listblog;
	}
	@Transactional
	public boolean approveBlog(Blog blog) {
		try{
		blog.setStatus("A");
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		return true ;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
		
	}

}
