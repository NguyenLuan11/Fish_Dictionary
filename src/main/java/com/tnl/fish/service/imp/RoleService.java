package com.tnl.fish.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnl.fish.converter.RoleConverter;
import com.tnl.fish.dto.RoleDTO;
import com.tnl.fish.entity.RoleEntity;
import com.tnl.fish.repository.RoleRepository;
import com.tnl.fish.service.IRoleService;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleConverter roleConverter;

	@Override
	public RoleDTO save(RoleDTO roleDTO) {
		RoleEntity roleEntity = new RoleEntity();
		
		if(roleDTO.getId() != null) {
			RoleEntity oldRoleEntity = roleRepository.findOne(roleDTO.getId());
			roleEntity = roleConverter.toEntity(roleDTO, oldRoleEntity);
		} else {
			roleEntity = roleConverter.toEntity(roleDTO);
		}
		
		roleEntity = roleRepository.save(roleEntity);
		return roleConverter.toDTO(roleEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			roleRepository.delete(item);
		}
	}

	@Override
	public List<RoleDTO> findAll() {
		List<RoleDTO> result = new ArrayList<>();
		List<RoleEntity> entities = roleRepository.findAll();
		
		for(RoleEntity item: entities) {
			RoleDTO dto = roleConverter.toDTO(item);
			result.add(dto);
		}
		return result;
	}
}
