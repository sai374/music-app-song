package com.manipal.demo.service;

import java.util.List;

import com.manipal.demo.exception.SongNotFoundException;
import com.manipal.demo.model.Song;
import com.manipal.demo.model.UserWishlist;

public interface UserWishlistService {
	
	public UserWishlist addSongToWishlist(String userId, String songId) throws SongNotFoundException;
	public void deleteSongFromWishlist(String userId, String songId)throws SongNotFoundException;
	public Song findSongByTitleFromWishlist(String userId, String songTitle) throws SongNotFoundException;
	public List<Song> findSongByAlbumFromWishlist(String userId, String albumName) throws SongNotFoundException;
	public List<Song> findAllSongsFromWishlist(String userId) throws SongNotFoundException;
	public void deleteAllSongsByUserId(String userId);
}
