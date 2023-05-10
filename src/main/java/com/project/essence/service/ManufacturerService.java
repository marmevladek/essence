package com.project.essence.service;

import com.project.essence.model.Manufacturer;
import com.project.essence.model.Product;
import com.project.essence.repository.ManufacturerRepository;
import com.project.essence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final ProductRepository productRepository;

    public boolean createManufacturer(Manufacturer manufacturer) {
        String name = manufacturer.getNameOfManufacturer();
        if (manufacturerRepository.findByNameOfManufacturer(name)!=null) return false;
        log.info("Saving new Manufacturer: {}", name);
        manufacturerRepository.save(manufacturer);
        return true;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturerRepository.findAll();
    }

    public void deleteManufacturer(Long id) {
        List<Product> products = productRepository.findProductsByManufacturer_Id(id);
        for (Product product : products) {
            product.setManufacturer(null);
            productRepository.save(product);
        }

        manufacturerRepository.deleteById(id);
    }
}
