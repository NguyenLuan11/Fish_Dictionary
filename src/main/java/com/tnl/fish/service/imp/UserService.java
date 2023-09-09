package com.tnl.fish.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tnl.fish.converter.UserConverter;
import com.tnl.fish.dto.UserDTO;
import com.tnl.fish.entity.RoleEntity;
import com.tnl.fish.entity.UserEntity;
import com.tnl.fish.repository.RoleRepository;
import com.tnl.fish.repository.UserRepository;
import com.tnl.fish.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		
		if(userDTO.getId() != null) {
			UserEntity oldUserEntity = userRepository.findOne(userDTO.getId());
			userEntity = userConverter.toEntity(userDTO, oldUserEntity);
		} else {
			userEntity = userConverter.toEntity(userDTO);
		}
		
		RoleEntity roleEntity = roleRepository.findOneByName(userDTO.getRole());
		userEntity.setRoles(roleEntity);
		
		userEntity = userRepository.save(userEntity);
		return userConverter.toDTO(userEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			userRepository.delete(item);
		}
	}

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> result = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll();
		
		for(UserEntity item: entities) {
			UserDTO dto = userConverter.toDTO(item);
			result.add(dto);
		}
		return result;
	}

	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> result = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll(pageable).getContent();
		
		for(UserEntity item: entities) {
			UserDTO dto = userConverter.toDTO(item);
			result.add(dto);
		}
		return result;
	}

	@Override
	public int totalItem() {
		return (int) userRepository.count();
	}
}
