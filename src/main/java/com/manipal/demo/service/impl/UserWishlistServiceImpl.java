package com.manipal.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.demo.exception.SongNotFoundException;
import com.manipal.demo.model.Song;
import com.manipal.demo.model.UserWishlist;
import com.manipal.demo.repository.UserWishlistRepo;
import com.manipal.demo.service.UserWishlistService;

@Service
public class UserWishlistServiceImpl implements UserWishlistService {
	@Autowired
    private UserWishlistRepo userWishlistRepo;

    @Autowired
    private SongServiceImpl songService;
	
    @Override
	public UserWishlist addSongToWishlist(String userId, String songId) throws SongNotFoundException {
		songService.getSongById(songId);
		UserWishlist userWishlist = new UserWishlist(userId, songId);
		return userWishlistRepo.save(userWishlist);
	}
	
    @Override
	public void deleteSongFromWishlist(String userId, String songId)throws SongNotFoundException {
		userWishlistRepo.deleteSong(userId, songId);
	}

    @Override
	public Song findSongByTitleFromWishlist(String userId, String songTitle) throws SongNotFoundException {
		Song song = songService.findSongByTitle(songTitle);
		return userWishlistRepo.findSongsByTitleFromWishlist(userId, song.getSongId());
	}
	 
    @Override
	public List<Song> findSongByAlbumFromWishlist(String userId, String albumName) throws SongNotFoundException {
		List<Song> songs = songService.findSongsByAlbum(albumName);
		List<String> songIds = new ArrayList<String>();
		for (Song song : songs) {
			songIds.add(song.getSongId());
		}
		List<Song> songsFromWishlist = new ArrayList<Song>();
		for (String songId : songIds) {
			Song song = userWishlistRepo.findSongsByAlbumFromWishlist(userId, songId);
			if (song != null) {
				songsFromWishlist.add(song);
			}
		}
		return songsFromWishlist;
	}

    @Override
    public List<Song> findAllSongsFromWishlist(String userId) throws SongNotFoundException {
    	try {
    		List<Song> songs = userWishlistRepo.findAllSongsFromsWishlist(userId);
    		if(songs == null) {
    			throw new SongNotFoundException();
    		}
    		return songs;
    	} catch(SongNotFoundException snfe) {
    		throw new SongNotFoundException();
    	}
    }

    @Override
	public void deleteAllSongsByUserId(String userId) {
		userWishlistRepo.deleteAllSongsByUserId(userId);		
	}	

}
