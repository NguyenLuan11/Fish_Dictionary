package com.tnl.fish.converter;

import org.springframework.stereotype.Component;

import com.tnl.fish.dto.DiseaseOfFishDTO;
import com.tnl.fish.entity.DiseaseOfFishEntity;

@Component
public class DiseaseOfFishConverter {

	// Convert from DTO to Entity
	public DiseaseOfFishEntity toEntity(DiseaseOfFishDTO dto) {
		DiseaseOfFishEntity entity = new DiseaseOfFishEntity();
		entity.setNameDisease(dto.getNameDisease());
		entity.setManifestations(dto.getManifestations());
		entity.setCure(dto.getCure());
		return entity;
	}
	
	// Convert from Entity to DTO
	public DiseaseOfFishDTO toDTO(DiseaseOfFishEntity entity) {
		DiseaseOfFishDTO dto = new DiseaseOfFishDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setNameDisease(entity.getNameDisease());
		dto.setManifestations(entity.getManifestations());
		dto.setCure(entity.getCure());
		if(entity.getKind() != null) {
			dto.setNameKind(entity.getKind().getNameKind());
		}
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	// Save update DiseaseOfFish by convert from DTO to Entity
	public DiseaseOfFishEntity toEntity(DiseaseOfFishDTO dto, DiseaseOfFishEntity entity) {
		entity.setNameDisease(dto.getNameDisease());
		entity.setManifestations(dto.getManifestations());
		entity.setCure(dto.getCure());
		return entity;
	}
}
