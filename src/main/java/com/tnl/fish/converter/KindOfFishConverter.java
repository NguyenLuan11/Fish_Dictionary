package com.tnl.fish.converter;

import org.springframework.stereotype.Component;

import com.tnl.fish.dto.KindOfFishDTO;
import com.tnl.fish.entity.KindOfFishEntity;

@Component
public class KindOfFishConverter {

	// Convert from DTO to Entity
	public KindOfFishEntity toEntity(KindOfFishDTO dto) {
		KindOfFishEntity entity = new KindOfFishEntity();
		entity.setBehavior(dto.getBehavior());
		entity.setNameKind(dto.getNameKind());
		entity.setReproduction(dto.getReproduction());
		entity.setOrigin(dto.getOrigin());
		entity.setWiki_reference(dto.getWiki_reference());
		return entity;
	}
	
	// Convert from Entity to DTO
	public KindOfFishDTO toDTO(KindOfFishEntity entity) {
		KindOfFishDTO dto = new KindOfFishDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setBehavior(entity.getBehavior());
		dto.setNameKind(entity.getNameKind());
		dto.setReproduction(entity.getReproduction());
		dto.setOrigin(entity.getOrigin());
		dto.setWiki_reference(entity.getWiki_reference());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	// Save update KindOfFish by convert from DTO to Entity
	public KindOfFishEntity toEntity(KindOfFishDTO dto, KindOfFishEntity entity) {
		entity.setBehavior(dto.getBehavior());
		entity.setNameKind(dto.getNameKind());
		entity.setReproduction(dto.getReproduction());
		entity.setOrigin(dto.getOrigin());
		entity.setWiki_reference(dto.getWiki_reference());
		return entity;
	}
}
