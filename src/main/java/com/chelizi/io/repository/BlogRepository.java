package com.chelizi.io.repository;

import com.chelizi.io.bean.Blog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {

	@Query(value="select * from dl_blog d where d.id=?1",nativeQuery=true)
	public Blog getBlogById(Long i);

	@Modifying
	@Query(value="delete from dl_blog where dl_blog.id=?1",nativeQuery=true)
	public void delete(Long id);

}
