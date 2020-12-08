package com.manipal.demo.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.manipal.demo.model.Admin;
import com.manipal.demo.repository.AdminRepo;
import com.manipal.demo.service.impl.AdminServiceImpl;

@SpringBootTest
public class AdminServiceTest {
	
	@InjectMocks
	AdminServiceImpl adminService;

	@Mock
	private AdminRepo adminRepo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void checkDetailsTest1() {	
		String adminId = "A101";
		String adminPassword = "Amd@7890";
		Admin admin = new Admin("A101", "Adm@7890");
		when(adminRepo.checkDetails(adminId, adminPassword)).thenReturn(admin);
		assertTrue(adminService.checkDetails(adminId, adminPassword));
	}
	
	@Test
	public void checkDetailsTest2() {	
		String adminId = "A101";
		String adminPassword = "Amd@7890";
		Admin admin = new Admin("A102", "Adm@7899");
		when(adminRepo.checkDetails(adminId, adminPassword)).thenReturn(null);
		assertFalse(adminService.checkDetails(adminId, adminPassword));
	}
}
