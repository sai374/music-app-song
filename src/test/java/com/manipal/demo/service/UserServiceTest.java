package com.manipal.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.manipal.demo.exception.UserNotFoundException;
import com.manipal.demo.model.User;
import com.manipal.demo.repository.UserRepo;
import com.manipal.demo.service.impl.UserServiceImpl;

@SpringBootTest
public class UserServiceTest {

	@InjectMocks
	UserServiceImpl userService;

	@Mock
	private UserRepo userRepo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getUserByIdTest() throws UserNotFoundException {		
		String id = "U101";
		User user = new User("U101", "Sai", "Sai@1234");
		//List<User> users = new ArrayList<>();
		//users.add(user);
		when(userRepo.findById(id)).thenReturn(Optional.of(user));
		User expected = userService.getUserById(id);
		assertEquals(user, expected);
		//assertSame("Sai", expected.get().getUserName());
	}
	
	@Test
	public void addDetailsTest() throws UserNotFoundException {		
		User user = new User("U101", "Sai", "Sai@1234");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user, userService.addDetails(user));
	}
	
	@Test
	public void addDetailsVerificationTest() throws UserNotFoundException {		
		User user = new User("U101", "Sai", "Sai@1234");
		//userRepository.save(user);
		userService.addDetails(user);
		//verify(userRepo, times(1)).save(user);
		verify(userRepo, atLeastOnce()).save(user);
	}
	
	@Test
	public void deleteAccountTest() {		
		User user = new User("U101", "Sai", "Sai@1234");
		userService.deleteAccount("U101");
		verify(userRepo, atLeastOnce()).deleteById("U101");
	}
	
	
	@Test
	public void updateDetailsTest() throws UserNotFoundException {	
		String id = "U102";
		User user = new User("U102", "Sai Chaitanya", "Sai@1234");
		when(userRepo.findById(id)).thenReturn(Optional.of(user));
		//User actual = userService.getUserById(id);
		when(userRepo.save(user)).thenReturn(user);		
		User expected = userService.updateDetails(user);		
		assertEquals(user, expected);		
	}
}
