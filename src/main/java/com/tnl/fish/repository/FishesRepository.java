package com.tnl.fish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnl.fish.entity.FishesEntity;

public interface FishesRepository extends JpaRepository<FishesEntity, Long> {

}
