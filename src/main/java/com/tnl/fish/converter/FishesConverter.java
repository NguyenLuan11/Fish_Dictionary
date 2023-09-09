package com.tnl.fish.converter;

import org.springframework.stereotype.Component;

import com.tnl.fish.dto.FishesDTO;
import com.tnl.fish.entity.FishesEntity;

@Component
public class FishesConverter {

	// Convert from DTO to Entity
	public FishesEntity toEntity(FishesDTO dto) {
		FishesEntity entity = new FishesEntity();
		entity.setNameFish(dto.getNameFish());
		entity.setColor(dto.getColor());
		entity.setImage(dto.getImage());
		entity.setShortDescription(dto.getShortDescription());
		return entity;
	}
	
	// Convert from Entity to DTO
	public FishesDTO toDTO(FishesEntity entity) {
		FishesDTO dto  = new FishesDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setNameFish(entity.getNameFish());
		dto.setColor(entity.getColor());
		dto.setImage(entity.getImage());
		dto.setShortDescription(entity.getShortDescription());
		if(entity.getKind() != null) {
			dto.setNameKind(entity.getKind().getNameKind());
		}
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	// Save update Fish by convert from DTO to Entity
	public FishesEntity toEntity(FishesDTO dto, FishesEntity entity) {
		entity.setNameFish(dto.getNameFish());
		entity.setColor(dto.getColor());
		entity.setImage(dto.getImage());
		entity.setShortDescription(dto.getShortDescription());
		return entity;
	}
}
