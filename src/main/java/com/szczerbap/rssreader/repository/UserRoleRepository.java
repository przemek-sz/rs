package com.szczerbap.rssreader.repository;

import com.szczerbap.rssreader.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

    public UserRole getByRole(String role);
}
