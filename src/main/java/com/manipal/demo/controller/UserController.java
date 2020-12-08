package com.manipal.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.demo.exception.UserNotFoundException;
import com.manipal.demo.model.User;
import com.manipal.demo.service.impl.UserServiceImpl;
import com.manipal.demo.service.impl.UserWishlistServiceImpl;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:3000")
@ApiOperation(value = "/users", tags = "User Controller")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
    private UserServiceImpl userService;
	
	@Autowired
    private UserWishlistServiceImpl userWishlistService;

    public Boolean validateUserId( String userId) {
        return userService.validateUserId(userId);
    }


    @ApiOperation(value = "User Registration", response = User.class)
    @PostMapping()
    public User addDetails(@RequestBody User user) throws UserNotFoundException {
        return userService.addDetails(user);
    }

    @ApiOperation(value = "User Login")
    @GetMapping("/validate/{userId}/{userPassword}")
    public String checkDetails(@PathVariable String userId, @PathVariable String userPassword) throws UserNotFoundException {
    	if(userService.checkDetails(userId, userPassword) != null) {
    		return "Login Successful";
    	}
    	return "Wrong Credentials";
    }

    @ApiOperation(value = "Update User Details", response = User.class)
    @PutMapping("/{userId}")
    public User updateDetails(@PathVariable String userId, @RequestBody User userDetails) throws UserNotFoundException {
        User user = userService.getUserById(userId);
        user.setUserName(userDetails.getUserName());
        user.setUserPassword(userDetails.getUserPassword());
        User updatedUser = userService.updateDetails(user);
        return updatedUser;
    }

    @ApiOperation(value = "Delete User Account", response = User.class)
    @DeleteMapping("/{userId}")
    public String deleteAccount(@PathVariable String userId) throws UserNotFoundException {
        User user = userService.getUserById(userId);
        userWishlistService.deleteAllSongsByUserId(userId);
        userService.deleteAccount(userId);
        return "Account Deleted Succesfully";
    }
}
