package com.tnl.fish.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import com.tnl.fish.converter.FishesConverter;
import com.tnl.fish.dto.FishesDTO;
import com.tnl.fish.entity.FishesEntity;
import com.tnl.fish.entity.KindOfFishEntity;
import com.tnl.fish.repository.FishesRepository;
import com.tnl.fish.repository.KindOfFishRepository;
import com.tnl.fish.service.IFishesService;

@Service
public class FishesService implements IFishesService {

	@Autowired
	private KindOfFishRepository kindOfFishRepository;
	
	@Autowired
	private FishesRepository fishesRepository;
	
	@Autowired
	private FishesConverter fishesConverter;

	@Override
	public FishesDTO save(FishesDTO fishesDTO) {
		FishesEntity fishesEntity = new FishesEntity();
		
		if(fishesDTO.getId() != null) {
			FishesEntity oldFishesEntity = fishesRepository.findOne(fishesDTO.getId());
			fishesEntity = fishesConverter.toEntity(fishesDTO, oldFishesEntity);
		} else {
			fishesEntity = fishesConverter.toEntity(fishesDTO);
		}
		
		KindOfFishEntity kindOfFishEntity = kindOfFishRepository.findOneByNameKind(fishesDTO.getNameKind());
		fishesEntity.setKind(kindOfFishEntity);
		
		fishesEntity = fishesRepository.save(fishesEntity);
		return fishesConverter.toDTO(fishesEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			fishesRepository.delete(item);
		}
	}

	@Override
	public List<FishesDTO> findAll() {
		List<FishesDTO> result = new ArrayList<>();
		List<FishesEntity> entities = fishesRepository.findAll();
		
		for(FishesEntity item: entities) {
			FishesDTO dto = fishesConverter.toDTO(item);
			result.add(dto);
		}
		return result;
	}

	@Override
	public List<FishesDTO> findAll(Pageable pageable) {
		List<FishesDTO> result = new ArrayList<>();
		List<FishesEntity> entities = fishesRepository.findAll(pageable).getContent();
		
		for(FishesEntity item: entities) {
			FishesDTO dto = fishesConverter.toDTO(item);
			result.add(dto);
		}
		return result;
	}

	@Override
	public int totalItem() {
		return (int) fishesRepository.count();
	}
	
	
}
