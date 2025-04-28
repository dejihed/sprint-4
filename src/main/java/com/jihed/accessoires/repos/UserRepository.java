package com.jihed.accessoires.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jihed.accessoires.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}