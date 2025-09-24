package com.armazena.armazena.controllers;

import com.armazena.armazena.DTOs.ProductDTO.ProductRequestDTO;
import com.armazena.armazena.DTOs.ProductDTO.ProductResponseDTO;
import com.armazena.armazena.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServices productService;

    @PostMapping
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO productDTO) {
        return productService.createProduct(productDTO);
    }
}
