package com.emreilgar.repository;

import com.emreilgar.repository.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepository extends JpaRepository<UserEntity,Integer> {
    
    Optional<UserEntity> findOptionalByEmail(String email);


    Optional<UserEntity> findOptionalByEmailAndPassword(String email, String password);
}
