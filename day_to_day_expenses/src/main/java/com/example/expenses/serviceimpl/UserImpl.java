package com.example.expenses.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expenses.entities.User;
import com.example.expenses.expectation.ResourceNotFoundException;
import com.example.expenses.repository.UserRepo;
import com.example.expenses.service.UserService;

@Service

public class UserImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	
	public User loginuser(String userName, String password) {
		User s = userRepo.findByUserName(userName);

		 
		 if(s!=null) {
			 if(s.getPassword().equals(password)) {
				 return s;
			 }else {
				throw new ResourceNotFoundException();
			}
		 }else {
			 throw new ResourceNotFoundException();
		 }
	  
	}

	public User addUser( User user) {
		return userRepo.save( user);
	}

	public User updateDb(String userName,User user) {
		
		
		User s1 = userRepo.findByUserName(userName);
		
		if(s1!=null) {
			  
			s1.setId(user.getId());
			s1.setPassword(user.getPassword());
		return 	userRepo.save(s1);
		} 
		else 
		{
			throw new ResourceNotFoundException();
		} 
	}

	public void deleteDb(String userName) {
	
		
		User s2 = userRepo.findByUserName(userName);
		
		if(s2!=null) {
			userRepo.delete(s2);
		}
		else {
			throw new ResourceNotFoundException();
		}		 
	}
}
