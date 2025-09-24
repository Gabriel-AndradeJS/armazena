package com.armazena.armazena.DTOs.ProductDTO;

import java.time.LocalDateTime;

public record ProductResponseDTO(
        Long id,
        String name,
        double price,
        int quantity,
        String category,
        Long userId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
