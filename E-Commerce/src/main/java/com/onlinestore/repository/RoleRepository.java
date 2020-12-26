package com.onlinestore.repository;

import org.springframework.data.repository.CrudRepository;

import com.onlinestore.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByName(String name);
	
}
