package com.example.TestOraclePostgres.UserModule.repositories;

import com.example.TestOraclePostgres.UserModule.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
}
