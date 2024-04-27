package com.example.RelationDataSpringBootJava.EntityOneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;
    private String city;
    private String province;

    // if infinite loop you should @JsonIgnore or @Json .... more field in document

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private User user;




}
