package com.example.TestOraclePostgres.ProductModule.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "products")
public class ProductEntity {
    @Id
    private int id;

    private String name;

    private double price;
}
