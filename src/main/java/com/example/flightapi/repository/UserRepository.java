package com.example.flightapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flightapi.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByEmail(String phone);

  Optional<UserEntity> findByEmailAndPassword(String phone, String password);

  Optional<UserEntity> findByUserId(Long userId);

}
