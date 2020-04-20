package com.demo.repository;

import java.util.ArrayList;
import java.util.List;

import com.demo.model.Blog;
import org.springframework.stereotype.Repository;

@Repository("repository")
public class RepositoryImpl implements BlogRepository{
	
	public List<Blog> findAll() {
		Blog blog1 = new Blog();
		Blog blog2 = new Blog();
		Blog blog3 = new Blog();
		blog1.setTitle("Blog1");
		blog2.setTitle("Blog2");
		blog3.setTitle("Blog3");
		blog1.setSummary("Blog1's summary");
		blog2.setSummary("Blog2's summary");
		blog3.setSummary("Blog3's summary");
		List<Blog> blogs = new ArrayList<>();
		blogs.add(blog1);
		blogs.add(blog2);
		blogs.add(blog3);
		return blogs;	
	}

	
}
