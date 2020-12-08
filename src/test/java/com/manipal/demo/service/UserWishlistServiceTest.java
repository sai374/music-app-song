package com.manipal.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.manipal.demo.exception.SongNotFoundException;
import com.manipal.demo.model.Song;
import com.manipal.demo.model.User;
import com.manipal.demo.model.UserWishlist;
import com.manipal.demo.repository.SongRepo;
import com.manipal.demo.repository.UserWishlistRepo;
import com.manipal.demo.service.impl.SongServiceImpl;
import com.manipal.demo.service.impl.UserWishlistServiceImpl;

@SpringBootTest
public class UserWishlistServiceTest {
	
	@Autowired
	UserWishlistServiceImpl userWishlistService;

	@MockBean
	UserWishlistRepo userWishlistRepo;
	
	@MockBean
	SongRepo songRepo;
	
	@MockBean
	SongServiceImpl songService;

//	@Before
//	public void init() {
//		MockitoAnnotations.initMocks(this);
//	}
	
	@Test
	public void addSongToWishlistTest() throws SongNotFoundException {
		String userId = "U101";
		String songId = "S100";
		UserWishlist userWishlist = new UserWishlist("U101", "S100");
		Song song = new Song("S100","Jam","Michael Jackson","Dangerous","https://www.youtube.com/watch?v=JbHI1yI1Ndk");
		when(songService.getSongById(songId)).thenReturn(song);
		when(userWishlistRepo.save(userWishlist)).thenReturn(userWishlist);
		assertEquals(userWishlist, userWishlistRepo.save(userWishlist));
	}
	
	@Test
	public void deleteAllSongsByUserIdTest() throws SongNotFoundException {	
		String userId = "U101";
		User user = new User("U101", "Sai","Sai@1234");
		userWishlistService.deleteAllSongsByUserId(userId);
		verify(userWishlistRepo, atLeastOnce()).deleteAllSongsByUserId(userId);
	}
}
