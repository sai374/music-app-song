package com.manipal.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.demo.exception.AdminNotFoundException;
import com.manipal.demo.model.Admin;
import com.manipal.demo.repository.AdminRepo;
import com.manipal.demo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
    private AdminRepo adminRepo;

	@Override
	public Boolean checkDetails(String adminId, String adminPassword) {
		if(adminRepo.checkDetails(adminId, adminPassword) != null) {
			return true;
		}
		return false;
	}

	@Override
	public Admin updateDetails(Admin admin) throws AdminNotFoundException {
		adminRepo.findById(admin.getAdminId()).orElseThrow(() -> new AdminNotFoundException("Access Restricted"));
		return adminRepo.save(admin);	
	}
}
