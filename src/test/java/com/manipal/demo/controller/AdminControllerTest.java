package com.manipal.demo.controller;

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
import com.manipal.demo.model.Admin;
import com.manipal.demo.repository.AdminRepo;
import com.manipal.demo.service.impl.AdminServiceImpl;

@WebMvcTest(AdminController.class)
public class AdminControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	private AdminServiceImpl adminService;
	
	@MockBean
	private AdminRepo adminRepo;
	
	
	@Test
	void checkDetailsTest() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Admin admin = new Admin("A101", "Sai@1234");
		mvc.perform(MockMvcRequestBuilders
				.post("/admins/valid")
				.content(objectMapper.writeValueAsString(admin))
				.accept(MediaType.APPLICATION_JSON)
		        .contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	void updateDetailsTest() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Admin admin = new Admin("A101", "Sai@1235");
		mvc.perform(MockMvcRequestBuilders
				.put("/admins/A101")
				.content(objectMapper.writeValueAsString(admin))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
