package com.tnl.fish.service;

import org.springframework.data.domain.Pageable;
import java.util.List;

import com.tnl.fish.dto.FishesDTO;

public interface IFishesService {

	// Save Fishes from DTO
	FishesDTO save(FishesDTO fishesDTO);
	// Delete Fishes
	void delete(long[] ids);
	// Get Fishes no paging
	List<FishesDTO> findAll();
	// Get Fishes and paging
	List<FishesDTO> findAll(Pageable pageable);
	// Total fish
	int totalItem();
}
