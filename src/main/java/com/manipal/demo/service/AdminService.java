package com.manipal.demo.service;

import com.manipal.demo.exception.AdminNotFoundException;
import com.manipal.demo.model.Admin;

public interface AdminService {
	
	public Boolean checkDetails(String adminId, String adminPassword);
	public Admin updateDetails(Admin admin) throws AdminNotFoundException;
}
