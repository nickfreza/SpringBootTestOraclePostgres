package com.example.TestOraclePostgres.controller;

import com.example.TestOraclePostgres.UserModule.entities.UserEntity;
import com.example.TestOraclePostgres.UserModule.repositories.UserRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        userRepo.deleteAll();
        UserEntity newUser = new UserEntity();
        newUser.setName("Bejo");
        newUser.setAge(25);
        newUser.setEmail("user@email.com");
        userRepo.save(newUser);
    }

    @Test
    void copyUserById() throws Exception{
        String id = "1";
        mockMvc.perform(
                get("/copyUserById/"+id)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                     )
        .andDo(result -> {
            String response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<String>() {
            });
            /// copy row to new table response 1 success, response 0 failed
            assertNotNull(response);
        });
    }

    @Test
    void countUsersByAge() throws Exception{
        String age = "1";
        mockMvc.perform(
                        get("/countUsersByAge/"+age)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(result -> {
                    String response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<String>() {
                    });
                    /// count user by age
                    assertNotNull(response);
                });
    }

}