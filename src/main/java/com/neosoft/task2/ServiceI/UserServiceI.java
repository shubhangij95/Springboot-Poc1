package com.neosoft.task2.ServiceI;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;

import com.neosoft.task2.model.User;

public interface UserServiceI {
	
	public void saveData(User u);
	
     public List<User> getSingleUserByName(String name);
     
     public List<User> getSingleUserByPincode(long pincode);
     
     public List<User> findAllUser();
     
     public List<User> findUserByJoiningDate();

     public User editUser(int id);
     
     public List<User> updateData(User user);
     
     public List<User> deleteUser(int id);
     
     public List<User> allUser();
		      
}
