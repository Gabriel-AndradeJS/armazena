package com.armazena.armazena.services;

import com.armazena.armazena.DTOs.UserDTO.UserRequestDTO;
import com.armazena.armazena.DTOs.UserDTO.UserResponseDTO;
import com.armazena.armazena.entities.user.User;
import com.armazena.armazena.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    public List<UserResponseDTO> getUsers() {
        List<User> users = repository.findAll();
        return users.stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getCreatedAt(),
                        user.getUpdateAt()
                ))
                .toList();
    }

    public UserResponseDTO createUser(UserRequestDTO userDTO) {
        User user = new User();
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
        User userSaved = repository.save(user);

        UserResponseDTO userResponseDTO = new UserResponseDTO(
                userSaved.getId(),
                userSaved.getName(),
                userSaved.getEmail(),
                userSaved.getCreatedAt(),
                userSaved.getUpdateAt()
        );
        return userResponseDTO;

    }
}
