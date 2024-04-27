package com.example.RelationDataSpringBootJava.Controller;


import com.example.RelationDataSpringBootJava.EntityOneToOne.Address;
import com.example.RelationDataSpringBootJava.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Address getDetailAddress(@PathVariable Integer id) {
        return addressRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<Address> createUser(@RequestBody Address address) {
        addressRepository.save(address);

        return ResponseEntity.ok().build();
    }


}
