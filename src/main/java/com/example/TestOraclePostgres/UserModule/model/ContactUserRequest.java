package com.example.TestOraclePostgres.UserModule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactUserRequest {

    @NotBlank
    private String address;

    @NotBlank
    private int phone;
}
