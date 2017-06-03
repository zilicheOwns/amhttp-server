package com.chelizi.io.repository;

import com.chelizi.io.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly=true)
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query(value="FROM dl_user u WHERE u.userId=?1",nativeQuery=true)
	public User getUser(int id);
	

	
}
