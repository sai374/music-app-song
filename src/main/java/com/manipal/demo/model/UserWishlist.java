package com.manipal.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "User_Wishlist")
@IdClass(UserWishlist.class)
public class UserWishlist implements Serializable {
	@Id
	@ApiModelProperty(notes = "ID of the User", name = "userId", value="U101")
    private String userId;
	@Id
	@ApiModelProperty(notes = "ID of the Song", name = "songId", value="S101")
	private String songId;

	public UserWishlist() {}

	public UserWishlist(String userId, String songId) {
	        this.userId = userId;
	        this.songId = songId;
	    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSongId() {
		return songId;
	}

	public void setSongId(String songId) {
		this.songId = songId;
	}
	
}
