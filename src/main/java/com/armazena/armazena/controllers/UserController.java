package com.armazena.armazena.controllers;

import com.armazena.armazena.DTOs.UserDTO.UserRequestDTO;
import com.armazena.armazena.DTOs.UserDTO.UserResponseDTO;
import com.armazena.armazena.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public List<UserResponseDTO> getUsers() {
        return userServices.getUsers();
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {
        return userServices.getUserById(id);
    }

    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userDTO) {
        return userServices.createUser(userDTO);
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userDTO) {
        return userServices.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAllUsers(@PathVariable Long id) {
        userServices.deleteUser(id);
    }
}
