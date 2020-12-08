package com.manipal.demo.service;

import com.manipal.demo.exception.UserNotFoundException;
import com.manipal.demo.model.User;

public interface UserService {
	
	public User addDetails(User user) throws UserNotFoundException;
	public User checkDetails(String userId, String password);
	public User updateDetails(User user) throws UserNotFoundException;
	public void deleteAccount(String userId);
	public User getUserById(String userId) throws UserNotFoundException;
	public Boolean validateUserId(String userId);
}
