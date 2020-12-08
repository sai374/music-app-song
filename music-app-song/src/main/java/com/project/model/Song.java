package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Song")
public class Song {
	
	@Id
	@ApiModelProperty(notes = "ID of the Song", name = "songId", value="S101")
    private String songId;
	@ApiModelProperty(notes = "Title of the Song", name = "songTitle", value="Breathless")
    private String songTitle;
	@ApiModelProperty(notes = "Singer of the Song", name = "singer", value="Shankar Mahadevan")
    private String singer;
	@ApiModelProperty(notes = "Album of the Song", name = "albumName", value="Breathless")
    private String albumName;
	@ApiModelProperty(notes = "Url of the Song", name = "url", value="https://www.youtube.com/watch?v=HHkHxTeaK_I")
    private String url;

    public Song() {}
    
    public Song(String songId, String songTitle, String singer, String albumName, String url) {
        this.songId = songId;
        this.songTitle = songTitle;
        this.singer = singer;
        this.albumName = albumName;
        this.url = url;
    }

	public String getSongId() {
		return songId;
	}

	public void setSongId(String songId) {
		this.songId = songId;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
   
}
