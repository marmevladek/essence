package com.project.essence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameOfProduct;
    @Column(columnDefinition = "text")
    private String description;
    private int price;
    private LocalDateTime dateOfAdded;

    @PrePersist
    private void init() {
        dateOfAdded = LocalDateTime.now();
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn
    private Manufacturer manufacturer;


    public void addImageToProduct(Image image) {
        image.setProduct(this);
        images.add(image);

    }

}
