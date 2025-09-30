package com.armazena.armazena.services;

import com.armazena.armazena.DTOs.LoginDTO.LoginRequestDTO;
import com.armazena.armazena.DTOs.LoginDTO.LoginResponseDTO;
import com.armazena.armazena.config.JWTConfigToken;
import com.armazena.armazena.entities.user.User;
import com.armazena.armazena.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServices {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JWTConfigToken createJWT;

    public ResponseEntity<LoginResponseDTO> createSession(LoginRequestDTO loginDTO) throws Exception {
        User userExists = this.repository.findByEmail(loginDTO.email());
        if (userExists == null) {
            throw new RuntimeException("Usuário não encontrado");
        }

        boolean passwordMatches = bCryptPasswordEncoder.matches(loginDTO.password(), userExists.getPassword());
        if (!passwordMatches) {
            throw new RuntimeException("Senha incorreta");
        }

        String token = createJWT.generateToken(userExists.getEmail());

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO(
                userExists.getId(),
                userExists.getName(),
                userExists.getEmail(),
                token,
                userExists.getProduct(),
                userExists.getCreatedAt(),
                userExists.getUpdateAt()
        );
        return ResponseEntity.ok().body(loginResponseDTO);
    }
}
