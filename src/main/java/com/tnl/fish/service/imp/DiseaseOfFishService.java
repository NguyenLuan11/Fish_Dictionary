package com.tnl.fish.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnl.fish.converter.DiseaseOfFishConverter;
import com.tnl.fish.dto.DiseaseOfFishDTO;
import com.tnl.fish.entity.DiseaseOfFishEntity;
import com.tnl.fish.entity.KindOfFishEntity;
import com.tnl.fish.repository.DiseaseOfFishRepository;
import com.tnl.fish.repository.KindOfFishRepository;
import com.tnl.fish.service.IDiseaseOfFishService;

@Service
public class DiseaseOfFishService implements IDiseaseOfFishService {
	
	@Autowired
	private KindOfFishRepository kindOfFishRepository;
	
	@Autowired
	private DiseaseOfFishRepository diseaseOfFishRepository;
	
	@Autowired
	private DiseaseOfFishConverter diseaseOfFishConverter;

	@Override
	public DiseaseOfFishDTO save(DiseaseOfFishDTO diseaseOfFishDTO) {
		DiseaseOfFishEntity diseaseOfFishEntity = new DiseaseOfFishEntity();
		
		if(diseaseOfFishDTO.getId() != null) {
			DiseaseOfFishEntity oldDiseaseOfFishEntity = diseaseOfFishRepository.findOne(diseaseOfFishDTO.getId());
			diseaseOfFishEntity = diseaseOfFishConverter.toEntity(diseaseOfFishDTO, oldDiseaseOfFishEntity);
		} else {
			diseaseOfFishEntity = diseaseOfFishConverter.toEntity(diseaseOfFishDTO);
		}
		
		KindOfFishEntity kindOfFishEntity = kindOfFishRepository.findOneByNameKind(diseaseOfFishDTO.getNameKind());
		diseaseOfFishEntity.setKind(kindOfFishEntity);
		
		diseaseOfFishEntity = diseaseOfFishRepository.save(diseaseOfFishEntity);
		return diseaseOfFishConverter.toDTO(diseaseOfFishEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			diseaseOfFishRepository.delete(item);
		}
	}

	@Override
	public List<DiseaseOfFishDTO> findAll() {
		List<DiseaseOfFishDTO> result = new ArrayList<>();
		List<DiseaseOfFishEntity> entities = diseaseOfFishRepository.findAll();
		
		for(DiseaseOfFishEntity item: entities) {
			DiseaseOfFishDTO dto = diseaseOfFishConverter.toDTO(item);
			result.add(dto);
		}
		return result;
	}
}
