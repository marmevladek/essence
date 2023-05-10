package com.project.essence.service;

import com.project.essence.model.Image;
import com.project.essence.model.Manufacturer;
import com.project.essence.model.Product;
import com.project.essence.repository.ImageRepository;
import com.project.essence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;

    public void addProduct(Product product, Manufacturer manufacturer, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;

        if (file1.getSize()!=0) {
            image1 = toImageEntity(file1);
            image1.setPreview(true);
            product.addImageToProduct(image1);
        }

        if (file2.getSize()!=0) {
            image2 = toImageEntity(file2);
            product.addImageToProduct(image2);
        }

        if (file3.getSize()!=0) {
            image3 = toImageEntity(file3);
            product.addImageToProduct(image3);
        }

        manufacturer.addManufacturerInProduct(product);
        log.info("Saving new Product. Name: {}; Price: {}", product.getNameOfProduct(), product.getPrice());

        Product productFromDb = productRepository.save(product);
        productFromDb.setPreviewImageId(product.getImages().get(0).getId());
        productRepository.save(product);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());

        return image;
    }

    public List<Product> listOfProduct(String nameOfProduct) {
        if (nameOfProduct!=null) return productRepository.findByNameOfProduct(nameOfProduct);
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }


    public void deleteProduct(Long id) {
        List<Image> images = imageRepository.findImagesByProductId(id);
        imageRepository.deleteAll(images);
        productRepository.deleteById(id);
    }

}

