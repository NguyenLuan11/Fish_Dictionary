package com.tnl.fish.converter;

import org.springframework.stereotype.Component;

import com.tnl.fish.dto.RoleDTO;
import com.tnl.fish.entity.RoleEntity;

@Component
public class RoleConverter {

	// Convert from DTO to Entity
	public RoleEntity toEntity(RoleDTO dto) {
		RoleEntity entity = new RoleEntity();
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		return entity;
	}
	
	// Convert from Entity to DTO
	public RoleDTO toDTO(RoleEntity entity) {
		RoleDTO dto = new RoleDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setName(entity.getName());
		dto.setCode(entity.getCode());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	// Save update Role by convert from DTO to Entity
	public RoleEntity toEntity(RoleDTO dto, RoleEntity entity) {
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		return entity;
	}
}
