package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.model.Song;

@Repository
public interface SongRepo extends JpaRepository<Song, String> {
	
	public Song findBySongTitle(String title);
	public List<Song> findBySinger(String singer);
	public List<Song> findByAlbumName(String album);
	
	@Query(value = "SELECT * FROM Song s WHERE s.song_id = (:songId)", nativeQuery = true)
	public Song searchSong(String songId);
}
