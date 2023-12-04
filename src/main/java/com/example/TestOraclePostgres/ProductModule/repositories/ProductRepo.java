package com.example.TestOraclePostgres.ProductModule.repositories;

import com.example.TestOraclePostgres.ProductModule.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

}
