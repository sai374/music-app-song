package com.manipal.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "User")
public class User {
	
	    @Id
	    @ApiModelProperty(notes = "ID of the User", name = "userId", value="U100")
	    private String userId;
	    @ApiModelProperty(notes = "Name of the User", name = "userName", value="Sai")
	    private String userName;
	    @ApiModelProperty(notes = "Password of the User", name = "userPassword", value="Sai@1234")
	    private String userPassword;

	    public User() {}
	    
	    public User(String userId, String userName, String userPassword){
	        this.userId = userId;
	        this.userName = userName;
	        this.userPassword = userPassword;
	    }

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserPassword() {
			return userPassword;
		}

		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
	    
}
