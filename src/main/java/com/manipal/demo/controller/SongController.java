package com.manipal.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.demo.exception.SongNotFoundException;
import com.manipal.demo.model.Song;
import com.manipal.demo.service.impl.SongServiceImpl;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SongController {
	@Autowired
    private SongServiceImpl songService;
	
	@ApiOperation(value = "Search song by title", response = Song.class)
	@GetMapping("/songs/id/{songId}")
	public Song findSongById(@PathVariable String songId) throws SongNotFoundException {
		return songService.getSongById(songId);
	}

	@ApiOperation(value = "Search song by title", response = Song.class)
	@GetMapping("/songs/title/{songTitle}")
	public Song findSongByTitle(@PathVariable String songTitle) throws SongNotFoundException {
		return songService.findSongByTitle(songTitle);
	}
    
	@ApiOperation(value = "Search songs by album name", response = Iterable.class)
	@GetMapping("/songs/album/{albumName}")
	public List<Song> findSongsByAlbum(@PathVariable String albumName) throws SongNotFoundException {
		return songService.findSongsByAlbum(albumName);
	}

	@ApiOperation(value = "Search song by singer", response = Iterable.class)
	@GetMapping("/songs/singer/{singer}")
	public List<Song> findSongsBySinger(@PathVariable String singer) throws SongNotFoundException {
		return songService.findSongsBySinger(singer);
	}

	
	@ApiOperation(value = "Search all songs", response = Iterable.class)
    @GetMapping("/songs")
    public List<Song> findAll() throws SongNotFoundException {
        return songService.findAllSongs();
    }
	
	//@CrossOrigin(origins = "http://localhost:3000")
	@ApiOperation(value = "Add Song to Music Store", response = Song.class)
    @PostMapping("/songs")
    public Song addSongToMusicStore(@RequestBody Song song) throws SongNotFoundException {
        return songService.addSongToMusicStore(song);
    }

	@ApiOperation(value = "Update Song Details", response = Song.class)
    @PutMapping("/songs/{songId}")
    public Song updateDetails(@PathVariable String songId, @RequestBody Song songDetails) throws SongNotFoundException {
        Song song = songService.getSongById(songId);
        song.setSongTitle(songDetails.getSongTitle());
        song.setSinger(songDetails.getSinger());
        song.setAlbumName(songDetails.getAlbumName());
        song.setUrl(songDetails.getUrl());
        return songService.updateDetails(song);
    }

	//@CrossOrigin(origins = "http://localhost:3000")
	@ApiOperation(value = "Delete Song")
    @DeleteMapping("/songs/{songId}")
    public String removeSong(@PathVariable String songId) throws SongNotFoundException {
        songService.removeSong(songId);
        return "Song Deleted";
    }

}
