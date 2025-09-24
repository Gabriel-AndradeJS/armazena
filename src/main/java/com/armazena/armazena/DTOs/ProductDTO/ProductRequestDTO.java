package com.armazena.armazena.DTOs.ProductDTO;

import com.armazena.armazena.entities.user.User;
import jakarta.validation.constraints.NotBlank;

public record ProductRequestDTO(
        @NotBlank(message = "Name is mandatory")
        String name,
        @NotBlank(message = "price is mandatory")
        Double price,
        @NotBlank(message = "quantity is mandatory")
        Integer quantity,
        @NotBlank(message = "category is mandatory")
        String category,
        @NotBlank(message = "userId is mandatory")
        Long userId
) {
}
