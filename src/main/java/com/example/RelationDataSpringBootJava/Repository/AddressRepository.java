package com.example.RelationDataSpringBootJava.Repository;

import com.example.RelationDataSpringBootJava.EntityOneToOne.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
