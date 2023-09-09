package com.tnl.fish.converter;

import org.springframework.stereotype.Component;

import com.tnl.fish.dto.UserDTO;
import com.tnl.fish.entity.UserEntity;

@Component
public class UserConverter {

	// Convert from DTO to Entity
	public UserEntity toEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		entity.setUserName(dto.getUserName());
		entity.setFullName(dto.getFullName());
		entity.setPassword(dto.getPassword());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	
	// Convert from Entity to DTO
	public UserDTO toDTO(UserEntity entity) {
		UserDTO dto = new UserDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setUserName(entity.getUserName());
		dto.setFullName(entity.getFullName());
		dto.setPassword(entity.getPassword());
		dto.setStatus(entity.getStatus());
		if(entity.getRoles() != null) {
			dto.setRole(entity.getRoles().getName());
		}
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	// Save update User by convert from DTO to Entity
	public UserEntity toEntity(UserDTO dto, UserEntity entity) {
		entity.setUserName(dto.getUserName());
		entity.setFullName(dto.getFullName());
		entity.setPassword(dto.getPassword());
		entity.setStatus(dto.getStatus());
		return entity;
	}
}
