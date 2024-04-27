package com.example.RelationDataSpringBootJava.Controller;

import com.example.RelationDataSpringBootJava.DTO.UserDto;
import com.example.RelationDataSpringBootJava.EntityOneToOne.User;
import com.example.RelationDataSpringBootJava.Repository.AddressRepository;
import com.example.RelationDataSpringBootJava.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getDetailUser(@PathVariable Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setAddress(userDto.getAddress());

         userRepository.save(user);

        return ResponseEntity.ok().build();
    }








}
