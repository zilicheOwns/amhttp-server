package com.chelizi.io.service;

import com.chelizi.io.bean.Blog;
import com.chelizi.io.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	public Blog getBlogById(Long i) {
		return blogRepository.getBlogById(i);
	}

	public List<Blog> findAllData() {
		
		return (List<Blog>) blogRepository.findAll();
	}

	public boolean save(Blog blog) {
		try {
			blogRepository.save(blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Page<Blog> findAll(Pageable pageable) {
		return blogRepository.findAll(pageable);
	}

	public boolean delete(Long id) {
		try {
			blogRepository.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		   return false;
		}
	}

}
