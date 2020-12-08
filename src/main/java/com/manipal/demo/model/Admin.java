package com.manipal.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Admin")
public class Admin {
	@Id
	@ApiModelProperty(notes = "ID of the Admin", name = "adminId", value="A101")
    private String adminId;
	@ApiModelProperty(notes = "Password of the Admin", name = "adminPassword", value="Red@9870")
    private String adminPassword;

    public Admin() {}
    
    public Admin(String adminId, String adminPassword) {
        this.adminId = adminId;
        this.adminPassword = adminPassword;
    }

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
    
}
