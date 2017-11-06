package com.collab.CollaborationBack.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collab.CollaborationBack.model.Blog;

@Repository("blogDao")
@Transactional
public class BlogDaoImpl implements BlogDao{

	
	@Autowired
	SessionFactory sessionFactory;
	

	
	public BlogDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("session created");
	}
	


	
	public boolean createBlog(Blog blog) {
		try 
		{
		Session s=sessionFactory.getCurrentSession();	
		blog.setStatus("NA");
		blog.setLikes(0);
		s.save(blog);
		System.out.println("Insertion succesfull ");
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
		
	}
	
	public boolean editBlog(Blog blog) {
		
		try{
		Session session = sessionFactory.getCurrentSession();
		session.update(blog);
		System.out.println("table is updated");
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
		
	}
	
	public boolean deleteBlog(Integer blogId) {
		
		try{
		Session session= sessionFactory.getCurrentSession();
		Blog blog=(Blog)session.load(Blog.class, blogId);
		session.delete(blog);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
	}

	public Blog getBlogById(Integer blogId) {
	
		try{
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery("from Blog where blogId=?");
		query.setParameter(0, blogId);
        Blog bloglist=(Blog)query.uniqueResult();
		return bloglist;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return null;
		}
	}

	public List<Blog> getAllBlogs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog where status='A'");
		List<Blog> listblog=query.list();
		return listblog;
	}

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




	public List<Blog> getBlogs(String status) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Blog where status=?");
		query.setParameter(0, status);
		List<Blog> listblog=query.list();
		return listblog;
	}

}
