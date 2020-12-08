package com.manipal.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manipal.demo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	
	@Query(value = "SELECT u FROM User u WHERE u.userId = :userId AND u.userPassword = :userPassword")
	public User checkDetails(@Param("userId") String userdId, @Param("userPassword") String userPassword);

	@Query(value = "SELECT u FROM User u WHERE u.userId = :userId")
	public  User searchUser(@Param("userId") String userId);
}
