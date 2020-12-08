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
import com.manipal.demo.controller.SongController;
import com.manipal.demo.model.Song;
import com.manipal.demo.service.impl.SongServiceImpl;

@WebMvcTest(SongController.class)
public class SongControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	private SongServiceImpl songService;
	
	@Test
	void testFindAll() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/songs")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	void testFindSongByTitle() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Song song = new Song("S106","Ee petaku nene mestri","SP Balasubramanyam","Muta Mestri","https://www.youtube.com/watch?v=c16sIwFhVgQ");
		mvc.perform(MockMvcRequestBuilders
				.get("/songs/title/Ee petaku nene mestri")
				.content(objectMapper.writeValueAsString(song))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
