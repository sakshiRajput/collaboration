package com.collab.CollaborationBack;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BlogTestCase {

	
	@BeforeClass
	public static void intialize()
	{		
		AnnotationConfigApplicationContext annotationConfigApplicationContext =new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collab.CollaborationBack");
		annotationConfigApplicationContext.refresh();
	}
	
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
