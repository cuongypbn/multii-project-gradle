package com.example.core.dto;

import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;

@Configuration
public class UserDto {
    @PersistenceContext
    EntityManager entityManager;

    public int getCountUser() {
        BigInteger bigInteger = (BigInteger) entityManager.createNativeQuery("SELECT nextval('acc_id_seq') as num").getSingleResult();
        return bigInteger.intValue();
    }
}
