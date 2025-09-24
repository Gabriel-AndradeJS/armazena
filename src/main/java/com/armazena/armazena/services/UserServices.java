package com.armazena.armazena.services;

import com.armazena.armazena.DTOs.UserDTO.UserRequestDTO;
import com.armazena.armazena.DTOs.UserDTO.UserResponseDTO;
import com.armazena.armazena.entities.user.User;
import com.armazena.armazena.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public UserResponseDTO getUserById(Long id) {
        User user = repository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );

        UserResponseDTO userResponseDTO = new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdateAt()
        );
        return userResponseDTO;
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

    public UserResponseDTO updateUser(Long id, UserRequestDTO userDTO) {
        User user = repository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );

        if (userDTO.name() != null) {
            user.setName(userDTO.name());
        }

        if (userDTO.email() != null) {
            user.setEmail(userDTO.email());
        }

        if (userDTO.password() != null) {
            user.setPassword(userDTO.password());
        }

        User userUpdated = repository.save(user);

        UserResponseDTO userResponseDTO = new UserResponseDTO(
                userUpdated.getId(),
                userUpdated.getName(),
                userUpdated.getEmail(),
                userUpdated.getCreatedAt(),
                userUpdated.getUpdateAt()
        );
        return userResponseDTO;
    }

    public ResponseEntity<Void> deleteUser(Long id) {
        User user = repository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
