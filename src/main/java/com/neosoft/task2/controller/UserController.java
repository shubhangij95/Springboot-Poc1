package com.neosoft.task2.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.task2.ServiceI.UserServiceI;
import com.neosoft.task2.model.User;

@RestController
public class UserController 
{
	@Autowired
	UserServiceI si;
	
	@PostMapping("/register")
	public String create(@Valid @RequestBody User user)
	{
	    System.out.println(user);
	    
		
		  si.saveData(user);
		  
		  return "Succesfully registered";
	}
	
	
	@GetMapping("/getuser/{name}")
	public List<User> getUserByName(@PathVariable String name)
	{
		List<User> u=si.getSingleUserByName(name);
		return u;
	}

	
	@GetMapping("/get/{pincode}")
	public List<User> getUserByPincode(@PathVariable long pincode)
	{
		List<User> u=si.getSingleUserByPincode(pincode);
		return u;
	}
	
	
	 @GetMapping(value = "/sortByDob")
	    public List<User> sortByDob()
	 {
	        return si.findAllUser();
	 }
	 
	 @GetMapping(value = "/sortByJoiningDate")
	    public List<User> sortByJoiningDate() 
	 {
	        return si.findUserByJoiningDate();
	 }
	 
	 
	 @GetMapping(value = "/edit/{id}")
	 public User editUserById(@PathVariable int id,Model m)
	 {
		return si.editUser(id);
	 }
	 
	 
	 @PutMapping(value = "/update")
	 public List<User> updateUser(@RequestBody User user)
	 {
		List<User> u=si.updateData(user);
		return u ;
	 }
	 
	 
	 @DeleteMapping(value = "/delete/{id}")
	 public List<User> remove(@PathVariable int id)
	 {
		 List<User> u=si.deleteUser(id);
		 return u;
	 }
	
	 @GetMapping(value = "/list")
	 public List<User> getAllUser()
	 {
	        List<User> users = si.allUser();
	        return users;
	    }
	 
}
