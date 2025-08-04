package com.dfesh.co.thetartaros.repository;

import com.dfesh.co.thetartaros.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long aLong);

    Optional<Product> findByName(String name);
    
    boolean existsByName(String name);

    List<Product> findByCategory(String category);
}
