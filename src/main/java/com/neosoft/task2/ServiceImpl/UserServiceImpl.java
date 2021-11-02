package com.neosoft.task2.ServiceImpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.neosoft.task2.Repository.UserRepository;
import com.neosoft.task2.ServiceI.UserServiceI;
import com.neosoft.task2.model.User;
import org.hibernate.Filter;
import org.hibernate.Session;

@Service
public class UserServiceImpl implements UserServiceI
{

	@Autowired
	UserRepository ur;
	
    @Autowired 
    EntityManager entityManager;

	
	@Override
	public void saveData(User u) {

		ur.save(u);
	}

	@Override
	public List<User> getSingleUserByName(String name) 
	{
		List<User> u=ur.findByName(name);
		return u;
	}

	@Override
	public List<User> getSingleUserByPincode(long pincode) 
	{
		
		List<User> u=ur.findByPincode(pincode);
		return u;
	}

	@Override
	public List<User> findAllUser() {

		 List<User> u = ur.findAll(Sort.by(Sort.Direction.ASC, "dob"));

		return u;
	}

	@Override
	public List<User> findUserByJoiningDate()
	{
		 List<User> u = ur.findAll(Sort.by(Sort.Direction.ASC, "joiningDate"));
		return u;
	}

	@Override
	public User editUser(int id) {
		User u=ur.findById(id).get();
		return u;
	}

	@Override
	public List<User> updateData(User user) {
		ur.save(user);
		List<User> u=ur.findAll();
		return u;
	}

	@Override
	public List<User> deleteUser(int id) {
		ur.deleteById(id);
		List<User> u=ur.findAll();
		return u;
	}

	@Override
	public List<User> allUser()
	{
		List<User> u=ur.findAll();
		return u;
	}
	
	
	

}
