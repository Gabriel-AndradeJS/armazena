package com.armazena.armazena.controllers;

import com.armazena.armazena.DTOs.ProductDTO.ProductRequestDTO;
import com.armazena.armazena.DTOs.ProductDTO.ProductResponseDTO;
import com.armazena.armazena.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServices productService;

    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/userId/{userId}")
    public List<ProductResponseDTO> getProductsByUserId(@PathVariable Long userId) {
        return productService.getProductsByUserId(userId);
    }

    @PostMapping
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO productDTO) {
        return productService.createProduct(productDTO);
    }
}
