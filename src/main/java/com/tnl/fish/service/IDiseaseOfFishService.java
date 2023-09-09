package com.tnl.fish.service;

import java.util.List;

import com.tnl.fish.dto.DiseaseOfFishDTO;

public interface IDiseaseOfFishService {

	// Save KindOfFish from DTO
	DiseaseOfFishDTO save(DiseaseOfFishDTO diseaseOfFishDTO);
	// Delete KindOfFish
	void delete(long[] ids);
	// Get KindOfFish no paging
	List<DiseaseOfFishDTO> findAll();
}
