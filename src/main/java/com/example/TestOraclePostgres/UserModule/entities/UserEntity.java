package com.example.TestOraclePostgres.UserModule.entities;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedStoredProcedureQuery(name = "UserEntity.PROCEDURE_COPY_USER", procedureName = "PROCEDURE_COPY_USER", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_address", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_phone", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "is_success", type = String.class) })
@NamedStoredProcedureQuery(name = "UserEntity.GET_TOTAL_USER_BY_AGE", procedureName = "GET_TOTAL_USER_BY_AGE", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_AGE", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "COUNT_USER", type = Integer.class) })
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private int age;
}
