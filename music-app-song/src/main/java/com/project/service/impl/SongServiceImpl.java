package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.SongNotFoundException;
import com.project.model.Song;
import com.project.repository.SongRepo;
import com.project.service.SongService;

@Service
public class SongServiceImpl implements SongService {
	@Autowired
    private SongRepo songRepo;

	@Override
    public List<Song> findAllSongs() throws SongNotFoundException {
    	try {
			List<Song> songs = songRepo.findAll();
			if(songs.size() == 0) {
				throw new SongNotFoundException("Songs are not available now. Try after some time.");
			}
			return songs;
		} catch(SongNotFoundException snfe) {
			throw new SongNotFoundException("Songs are not available now. Try after some time.");
		}
    }

	@Override
	public Song findSongByTitle(String title) throws SongNotFoundException {
		try {
			Song song = songRepo.findBySongTitle(title);
			if(song==null) {
				throw new SongNotFoundException("Song with title "+title+" is not found.");
			}
			return song;
		} catch(SongNotFoundException snfe) {
			throw new SongNotFoundException("Song with title "+title+" is not found.");
		}
	}	 

	@Override
    public List<Song> findSongsBySinger(String singer) throws SongNotFoundException {
    	try {
			List<Song> songs = songRepo.findBySinger(singer);
			if(songs.size()==0) {
				throw new SongNotFoundException("Songs sung by "+singer+" are not available.");
			}
			return songs;
		} catch(SongNotFoundException snfe) {
			throw new SongNotFoundException("Songs sung by "+singer+" are not available.");
		}
    }

	@Override
    public List<Song> findSongsByAlbum(String album) throws SongNotFoundException {
    	try {
			List<Song> songs = songRepo.findByAlbumName(album);
			if(songs.size()==0) {
				throw new SongNotFoundException("Album "+album+" is not found.");
			}
			return songs;
		} catch(SongNotFoundException snfe) {
			throw new SongNotFoundException("Album "+album+" is not found.");
		}
    }

	@Override
    public Song addSongToMusicStore(Song song) throws SongNotFoundException {
		if(songRepo.searchSong(song.getSongId())!=null) {
			throw new SongNotFoundException("Song id already exists. Give new song id.");
		}
        return songRepo.save(song);
    }

	@Override
     public Song getSongById(String songId) throws SongNotFoundException {
            return songRepo.findById(songId).orElseThrow(() -> new SongNotFoundException("No songs found."));
    }

	@Override
	public Song updateDetails(Song song) throws SongNotFoundException {
		songRepo.findById(song.getSongId()).orElseThrow(() -> new SongNotFoundException("Updation cannot be done. Song with this song id is not found."));
		return songRepo.save(song);
	}

	@Override
    public  void removeSong(String songId) throws SongNotFoundException {
    	songRepo.findById(songId).orElseThrow(() -> new SongNotFoundException("Deletion cannot be done. Song with this song id is not found."));
            songRepo.deleteById(songId);
    }
}
