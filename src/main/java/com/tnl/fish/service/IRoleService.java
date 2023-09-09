package com.tnl.fish.service;

import java.util.List;

import com.tnl.fish.dto.RoleDTO;

public interface IRoleService {

	// Save Role from DTO
	RoleDTO save(RoleDTO roleDTO);
	// Delete Role
	void delete(long[] ids);
	// Get Role no paging
	List<RoleDTO> findAll();
}
