package com.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.demo.model.Blog;
import com.demo.repository.*;

@Service("service")
public class ServiceImpl implements BlogService{
	
	@Autowired
	private RepositoryImpl rep = new RepositoryImpl(); 
	
	public List<Blog> findAll() {
		return rep.findAll();
	}
}
