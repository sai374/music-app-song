package com.manipal.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manipal.demo.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, String> {

    @Query(value = "SELECT * FROM Admin a WHERE a.admin_id = (:adminId) AND a.admin_password = (:adminPassword)", nativeQuery = true)
    public Admin checkDetails(@Param("adminId") String adminId, @Param("adminPassword") String adminPassword);
}
