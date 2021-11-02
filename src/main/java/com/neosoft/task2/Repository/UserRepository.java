package com.neosoft.task2.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neosoft.task2.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="from User where name=:name")
	public List<User> findByName(String name);
	
	
	@Query(value="select * from User where pincode=:pincode", nativeQuery = true)
	public List<User> findByPincode(long pincode);
	
	


}
