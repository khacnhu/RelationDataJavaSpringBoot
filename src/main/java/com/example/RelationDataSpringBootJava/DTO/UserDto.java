package com.example.RelationDataSpringBootJava.DTO;

import com.example.RelationDataSpringBootJava.EntityOneToOne.Address;
import lombok.Data;

@Data
public class UserDto {

    private String username;
    private String password;
    private Address address;




}
