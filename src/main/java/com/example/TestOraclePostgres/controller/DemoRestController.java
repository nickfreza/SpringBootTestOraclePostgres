package com.example.TestOraclePostgres.controller;


import com.example.TestOraclePostgres.ProductModule.model.ProductRequest;
import com.example.TestOraclePostgres.UserModule.entities.UserEntity;
import com.example.TestOraclePostgres.UserModule.model.ContactUserRequest;
import com.example.TestOraclePostgres.UserModule.model.RegisterUserRequest;
import com.example.TestOraclePostgres.UserModule.repositories.UserRepo;
import com.example.TestOraclePostgres.ProductModule.entities.ProductEntity;
import com.example.TestOraclePostgres.ProductModule.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class DemoRestController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/saveProduct")
    public ProductEntity saveProduct(@RequestBody ProductRequest request) {
        ProductEntity product = new ProductEntity();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return productRepo.save(product);
    }

    @GetMapping("/getAllProducts")
    public List<ProductEntity> getAllProducts(){
        return productRepo.findAll();
    }

    @PostMapping("/saveUser")
    public UserEntity saveUser(@RequestBody RegisterUserRequest request) {
        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setAge(request.getAge());
        return userRepo.save(user);
    }

    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/countUsersByAge/{age}")
    public int getCountUserByAge(@PathVariable("age") String age){
        return userRepo.callGetTotalUserByAge(Integer.parseInt(age));
    }

    @PostMapping("/copyUserById/{id}")
    public String doCopyUserById(@PathVariable("id") String id, @RequestBody ContactUserRequest request){
        return userRepo.callProcedureCopyUser(Integer.parseInt(id), request.getAddress(), request.getPhone());
    }
}
