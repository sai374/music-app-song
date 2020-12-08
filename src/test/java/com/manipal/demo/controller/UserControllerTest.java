package com.manipal.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manipal.demo.model.User;
import com.manipal.demo.service.impl.UserServiceImpl;
import com.manipal.demo.service.impl.UserWishlistServiceImpl;

@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	private UserServiceImpl userService;
	
	@MockBean
	private UserWishlistServiceImpl userWishlistService;
	
	/*@Test
	void checkDetailsTest() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		User user = new User("U101", "Sai", "Sai@1234");
		mvc.perform(MockMvcRequestBuilders
				.post("/users/validate")
				.content(objectMapper.writeValueAsString(user))
				.accept(MediaType.APPLICATION_JSON)
		        .contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}*/
	
	@Test
	void addDetailsTest() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		User user = new User("U101", "Sai", "Sai@1234");
		mvc.perform(post("/users")
				.content(objectMapper.writeValueAsString(user))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	void updateDetailsTest() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		User user = new User("U101", "Sai chaitanya", "Sai@1234");
		mvc.perform(MockMvcRequestBuilders
				.post("/users")
				.content(objectMapper.writeValueAsString(user))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
