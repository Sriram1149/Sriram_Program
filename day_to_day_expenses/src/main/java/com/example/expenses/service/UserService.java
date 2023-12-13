package com.example.expenses.service;

import com.example.expenses.entities.User;

public interface UserService {
	User loginuser(String userName, String password);
	 User addUser( User user);
	 User updateDb(String userName ,User user);
	void deleteDb(String userName);

}
