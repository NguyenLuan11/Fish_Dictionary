package com.tnl.fish.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.tnl.fish.dto.UserDTO;

public interface IUserService {

	// Save User from DTO
	UserDTO save(UserDTO userDTO);
	// Delete User
	void delete(long[] ids);
	// Get User no paging
	List<UserDTO> findAll();
	// Get User and paging
	List<UserDTO> findAll(Pageable pageable);
	// Total Item
	int totalItem();
}
