package com.jihed.accessoires.service;

import com.jihed.accessoires.entities.Role;
import com.jihed.accessoires.entities.User;

public interface UserService {
	void deleteAllusers();

	void deleteAllRoles();

	User saveUser(User user);

	User findUserByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);

}