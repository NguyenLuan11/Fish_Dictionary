package com.tnl.fish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnl.fish.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	
	// Find single Role by name
	RoleEntity findOneByName(String name);
}
