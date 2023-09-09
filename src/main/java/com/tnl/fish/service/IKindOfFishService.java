package com.tnl.fish.service;

import java.util.List;

import com.tnl.fish.dto.KindOfFishDTO;

public interface IKindOfFishService {

	// Save KindOfFish from DTO
	KindOfFishDTO save(KindOfFishDTO kindOfFishDTO);
	// Delete KindOfFish
	void delete(long[] ids);
	// Get KindOfFish no paging
	List<KindOfFishDTO> findAll();
}
