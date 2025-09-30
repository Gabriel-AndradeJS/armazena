package com.armazena.armazena.DTOs.LoginDTO;

import com.armazena.armazena.DTOs.UserDTO.UserResponseDTO;
import com.armazena.armazena.entities.Product.Product;

import java.time.LocalDateTime;
import java.util.List;

public record LoginResponseDTO(
        Long id,
        String name,
        String email,
        String token,
        List<Product> product,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
