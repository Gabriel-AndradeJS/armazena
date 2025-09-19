package com.armazena.armazena.DTOs.UserDTO;

import java.time.LocalDateTime;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updateAt
) {
}
