package com.project.essence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "manufacturers")
@Data
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameOfManufacturer;
    private String linkOfficial;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "manufacturer")
    private List<Product> products;

    public void addManufacturerInProduct(Product product) {
        product.setManufacturer(this);
        products.add(product);
    }
}
