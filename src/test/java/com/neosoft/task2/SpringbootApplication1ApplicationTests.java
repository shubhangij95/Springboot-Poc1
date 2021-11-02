package com.neosoft.task2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.neosoft.task2.Repository.UserRepository;
import com.neosoft.task2.model.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SpringbootApplication1ApplicationTests {

	 Date date = new Date();
	 

	 @Autowired
	 UserRepository uRepo;
	
	@Test
	@Order(1)
	public void testCreate()
	{
		
		User user= new User();
		//user.setId(6);
		user.setName("Shubhangi");
		user.setSurname("Jadhav");
		user.setCity("Pune");
		user.setPincode(412102);
		user.setEmail("shubangi@gmail.com");
		user.setDob(date);
		user.setJoiningDate(date);
		user.setIncome(40000);
		user.setDeleted(false);  
		
		uRepo.save(user);
		Boolean actualResult=uRepo.existsById(user.getId());
		assertThat(actualResult).isTrue();
		
	}
	
	
	@Test
	@Order(2)
	public void testReadAll()
	{
		List<User> list=uRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	

	@Test
	@Order(3)
	public void testSingleUser()
	{
		User user1=uRepo.findById(6).get();
		assertEquals("Shubhangi",user1.getName());
		assertEquals(412102, user1.getPincode());
		
	}
	
	
	@Test
	@Order(4)
	public void testUpdate()
	{
		User u=uRepo.findById(6).get();
		u.setCity("Satara");
		uRepo.save(u);
		assertNotEquals("Pune", uRepo.findById(6).get().getCity());
	}
	
	
	@Test
	@Order(5)
	public void testDelete()
	{
		uRepo.deleteById(6);
		assertThat( uRepo.existsById(6)).isFalse();
	}
	
	
}
