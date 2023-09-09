package com.tnl.fish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnl.fish.entity.KindOfFishEntity;

public interface KindOfFishRepository extends JpaRepository<KindOfFishEntity, Long> {

	// Find single kind by name
	KindOfFishEntity findOneByNameKind(String nameKind);
}
