package com.jihed.accessoires.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jihed.accessoires.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}