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
import com.manipal.demo.model.Song;
import com.manipal.demo.model.User;
import com.manipal.demo.repository.UserWishlistRepo;
import com.manipal.demo.service.impl.UserServiceImpl;
import com.manipal.demo.service.impl.UserWishlistServiceImpl;

@WebMvcTest(UserController.class)
public class UserWishlistControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	private UserWishlistServiceImpl userWishlistService;
	
	@MockBean
	private UserServiceImpl userService;
	
	@MockBean
	private UserWishlistRepo userWishlistRepo;
	
	/*@Test
	void findSongByTitleFromWishlistTest() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		User user = new User("U101", "Sai chaitanya", "Sai@1234");
		Song song = new Song("S106","Ee petaku nene mestri","SP Balasubramanyam","Muta Mestri","https://www.youtube.com/watch?v=c16sIwFhVgQ");
		mvc.perform(MockMvcRequestBuilders
				.get("/users/U101/songs/title/Ee petaku nene mestri")
				.content(objectMapper.writeValueAsString(song))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}*/
	
	
}
