package com.example.backend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity getUserEntitiesById(Integer id);
    UserEntity getUserEntityById(Integer id);
}
