package com.armazena.armazena.services;

import com.armazena.armazena.DTOs.ProductDTO.ProductRequestDTO;
import com.armazena.armazena.DTOs.ProductDTO.ProductResponseDTO;
import com.armazena.armazena.entities.Product.Product;
import com.armazena.armazena.entities.user.User;
import com.armazena.armazena.repositories.ProductRepository;
import com.armazena.armazena.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private UserRepository userRepository;

    public ProductResponseDTO createProduct(ProductRequestDTO productDTO) {
        User user = userRepository.findById(productDTO.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = new Product(productDTO, user);
        Product productSaved = repository.save(product);
        ProductResponseDTO res = new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategory(),
                product.getUser().getId(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
        return res;
    }
}
