package com.armazena.armazena.repositories;

import com.armazena.armazena.entities.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
