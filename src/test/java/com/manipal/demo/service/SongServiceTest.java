package com.manipal.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.manipal.demo.exception.SongNotFoundException;
import com.manipal.demo.model.Song;
import com.manipal.demo.repository.SongRepo;
import com.manipal.demo.service.impl.SongServiceImpl;

@SpringBootTest
public class SongServiceTest {

	@InjectMocks
	SongServiceImpl songService;

	@Mock
	private SongRepo songRepo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findAllSongsTest() throws SongNotFoundException {
	    List<Song> songs = new ArrayList<>();
	    songs.add(new Song("S100","Jam","Michael Jackson","Dangerous","https://www.youtube.com/watch?v=JbHI1yI1Ndk"));
	    songs.add(new Song("S101","In the closet","Michael Jackson","Dangerous","https://www.youtube.com/watch?v=THFW9cfIx_Y"));
	    songs.add(new Song("S102","Rock with you","Michael Jackson","Off the wall","https://www.youtube.com/watch?v=5X-Mrc2l1d0"));
		when(songRepo.findAll()).thenReturn(songs);
		//List<Song> expected = songService.findAllSongs();
		assertEquals(3, songService.findAllSongs().size());
	}
	
	@Test
	public void findSongByTitleTest() throws SongNotFoundException {		
		String title = "Jam";
		Song song = new Song("S100","Jam","Michael Jackson","Dangerous","https://www.youtube.com/watch?v=JbHI1yI1Ndk");
		when(songRepo.findBySongTitle(title)).thenReturn(song);
		assertEquals(song, songService.findSongByTitle(title));
	}
	
	@Test
	public void findSongByAlbumTest() throws SongNotFoundException {		
		String album = "Dangerous";
		List<Song> songs = new ArrayList<Song>();
		songs.add(new Song("S100","Jam","Michael Jackson","Dangerous","https://www.youtube.com/watch?v=JbHI1yI1Ndk"));
	    songs.add(new Song("S101","In the closet","Michael Jackson","Dangerous","https://www.youtube.com/watch?v=THFW9cfIx_Y"));
		when(songRepo.findByAlbumName(album)).thenReturn(songs);
		assertEquals(album, songService.findSongsByAlbum(album).get(0).getAlbumName());
	}
	
	@Test
	public void findSongBySingerTest() throws SongNotFoundException {		
		String singer = "Michael Jackson";
		List<Song> songs = new ArrayList<Song>();
		songs.add(new Song("S100","Jam","Michael Jackson","Dangerous","https://www.youtube.com/watch?v=JbHI1yI1Ndk"));
	    songs.add(new Song("S101","In the closet","Michael Jackson","Dangerous","https://www.youtube.com/watch?v=THFW9cfIx_Y"));
	    songs.add(new Song("S103","Mark my words","Justin Bieber","Purpose","https://www.youtube.com/watch?v=_ZUwpwnl_CU"));
		when(songRepo.findBySinger(singer)).thenReturn(songs);
		assertEquals(singer, songService.findSongsBySinger(singer).get(0).getSinger());
	}
	
	@Test
	public void addDetailsTest() throws SongNotFoundException {		
		Song song = new Song("S106","Ee petaku nene mestri","SP Balasubramanyam","Mutha Mestri","https://www.youtube.com/watch?v=c16sIwFhVgQ");
		when(songRepo.save(song)).thenReturn(song);
		assertEquals(song, songService.addSongToMusicStore(song));
	}
	
	@Test
	public void getSongByIdTest() throws SongNotFoundException {		
		String id = "S101";
		Song song = new Song("S101","In the closet","Michael Jackson","Dangerous","https://www.youtube.com/watch?v=THFW9cfIx_Y");
		when(songRepo.findById(id)).thenReturn(Optional.of(song));
		Song expected = songService.getSongById(id);
		assertEquals(song, expected);
	}
	
	@Test
	public void updateDetailsTest() throws SongNotFoundException {		
		String songId = "S106";
		Song song = new Song("S106","Ee petaku nene mestri","SP Balasubramanyam","Muta Mestri","https://www.youtube.com/watch?v=c16sIwFhVgQ");
		when(songRepo.findById(songId)).thenReturn(Optional.of(song));
		Song actual = songService.getSongById(songId);
		when(songRepo.save(song)).thenReturn(song);		
		Song expected = songService.updateDetails(song);
		assertEquals(expected, actual);
	}
	
	@Test
	public void removeSong() throws SongNotFoundException {
	    String songId = "S106";		
		Song song = new Song("S106","Ee petaku nene mestri","SP Balasubramanyam","Muta Mestri","https://www.youtube.com/watch?v=c16sIwFhVgQ");
		when(songRepo.findById(songId)).thenReturn(Optional.of(song));
		songService.removeSong("S106");
		verify(songRepo, atLeastOnce()).deleteById("S106");
	}
	
	
}
