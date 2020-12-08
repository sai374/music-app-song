package com.manipal.demo.service;

import java.util.List;

import com.manipal.demo.exception.SongNotFoundException;
import com.manipal.demo.model.Song;

public interface SongService {
	
	public List<Song> findAllSongs() throws SongNotFoundException;
	public Song findSongByTitle(String title) throws SongNotFoundException;
	public List<Song> findSongsBySinger(String singer) throws SongNotFoundException;
	public List<Song> findSongsByAlbum(String album) throws SongNotFoundException;
	public Song addSongToMusicStore(Song song) throws SongNotFoundException;
	public Song getSongById(String songId) throws SongNotFoundException;
	public Song updateDetails(Song song) throws SongNotFoundException;
	public  void removeSong(String songId) throws SongNotFoundException;
}
