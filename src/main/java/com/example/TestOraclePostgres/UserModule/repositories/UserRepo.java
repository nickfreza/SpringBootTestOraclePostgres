package com.example.TestOraclePostgres.UserModule.repositories;

import com.example.TestOraclePostgres.UserModule.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    @Procedure(procedureName = "PROCEDURE_COPY_USER",name = "UserEntity.PROCEDURE_COPY_USER")
    Integer callProcedureCopyUser(@Param("p_id") Integer arg);

    @Procedure(procedureName = "GET_TOTAL_USER_BY_AGE",name = "UserEntity.GET_TOTAL_USER_BY_AGE")
    Integer callGetTotalUserByAge(@Param("P_AGE") Integer arg);
}
