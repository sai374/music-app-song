package com.manipal.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.demo.exception.UserNotFoundException;
import com.manipal.demo.model.User;
import com.manipal.demo.repository.UserRepo;
import com.manipal.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserRepo userRepo;

	@Override
	public User addDetails(User user) throws UserNotFoundException {
		
		if(userRepo.searchUser(user.getUserId()) != null) {
			throw new UserNotFoundException("User Id is taken. Use a new one.");
		}
		return userRepo.save(user);
	}

	@Override
    public User checkDetails(String userId, String userPassword) {
        return userRepo.checkDetails(userId, userPassword);
    }

	@Override
    public User updateDetails(User user) throws UserNotFoundException {
    	getUserById(user.getUserId());
        return userRepo.save(user);
    }

	@Override
    public void deleteAccount(String userId) {
        userRepo.deleteById(userId);
    }

	@Override
    public User getUserById(String userId) throws UserNotFoundException {
        return userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User with user id not found"));
    }

	@Override
    public Boolean validateUserId(String userId) {
        if(userId.length() ==3  || userId.length() == 4) {
            return true;
        }
        return false;
    }

}
