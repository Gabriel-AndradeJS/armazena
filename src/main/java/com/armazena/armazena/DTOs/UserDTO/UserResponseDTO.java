package com.armazena.armazena.DTOs.UserDTO;

import com.armazena.armazena.entities.Product.Product;

import java.time.LocalDateTime;
import java.util.List;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        List<Product> product,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
