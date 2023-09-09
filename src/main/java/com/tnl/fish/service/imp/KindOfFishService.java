package com.tnl.fish.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnl.fish.converter.KindOfFishConverter;
import com.tnl.fish.dto.KindOfFishDTO;
import com.tnl.fish.entity.KindOfFishEntity;
import com.tnl.fish.repository.KindOfFishRepository;
import com.tnl.fish.service.IKindOfFishService;

@Service
public class KindOfFishService implements IKindOfFishService {
	
	@Autowired
	private KindOfFishRepository kindOfFishRepository;
	
	@Autowired
	private KindOfFishConverter kindOfFishConverter;

	@Override
	public KindOfFishDTO save(KindOfFishDTO kindOfFishDTO) {
		KindOfFishEntity kindOfFishEntity = new KindOfFishEntity();
		
		if(kindOfFishDTO.getId() != null) {
			KindOfFishEntity oldKindOfFishEntity = kindOfFishRepository.findOne(kindOfFishDTO.getId());
			kindOfFishEntity = kindOfFishConverter.toEntity(kindOfFishDTO, oldKindOfFishEntity);
		} else {
			kindOfFishEntity = kindOfFishConverter.toEntity(kindOfFishDTO);
		}
		
		kindOfFishEntity = kindOfFishRepository.save(kindOfFishEntity);
		return kindOfFishConverter.toDTO(kindOfFishEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			kindOfFishRepository.delete(item);
		}
		
	}

	@Override
	public List<KindOfFishDTO> findAll() {
		List<KindOfFishDTO> result = new ArrayList<>();
		List<KindOfFishEntity> entities = kindOfFishRepository.findAll();
		
		for(KindOfFishEntity item: entities) {
			KindOfFishDTO dto = kindOfFishConverter.toDTO(item);
			result.add(dto);
		}
		return result;
	}
}
