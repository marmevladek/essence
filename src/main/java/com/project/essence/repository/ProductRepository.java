package com.project.essence.repository;

import com.project.essence.model.Manufacturer;
import com.project.essence.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameOfProduct(String title);

    List<Product> findProductsByManufacturer_Id(Long id);
}
