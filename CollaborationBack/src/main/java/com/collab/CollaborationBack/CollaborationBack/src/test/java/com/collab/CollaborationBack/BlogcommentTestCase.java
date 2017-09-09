package com.collab.CollaborationBack;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.collab.CollaborationBack.Dao.BlogcommentDao;
import com.collab.CollaborationBack.model.BlogComment;

public class BlogcommentTestCase {

	
	static BlogcommentDao blogcommentDao; 
	
	@BeforeClass
	public static void initialize()
	{		
		AnnotationConfigApplicationContext annotationConfigApplicationContext =new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collab");
		annotationConfigApplicationContext.refresh();
		blogcommentDao=(BlogcommentDao)annotationConfigApplicationContext.getBean("blogcommentDao");
		
	}
	
	@Test
	public void createblogcommenttest() {
	BlogComment blogcomment=new BlogComment();
	blogcomment.setBlogcommentId(123);
	blogcomment.setBlogId(111);
	blogcomment.setBlogComment("this is my first comment");
	blogcomment.setCommentDate(new java.util.Date());
	blogcomment.setUserId(222);
	blogcomment.setUserName("sakshi");
	blogcommentDao.createBlogcomment(blogcomment);
	
	assertTrue("problem in blogcomment creation",blogcommentDao.createBlogcomment(blogcomment));
		
	}
	
	
}
