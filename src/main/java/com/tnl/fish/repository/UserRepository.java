package com.tnl.fish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnl.fish.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
