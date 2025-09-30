package com.armazena.armazena.controllers;

import com.armazena.armazena.DTOs.LoginDTO.LoginRequestDTO;
import com.armazena.armazena.DTOs.LoginDTO.LoginResponseDTO;
import com.armazena.armazena.services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginServices loginServices;


    @PostMapping
    public ResponseEntity<LoginResponseDTO> createSession(@RequestBody LoginRequestDTO loginDTO) throws Exception {
        return this.loginServices.createSession(loginDTO);
    }
}
