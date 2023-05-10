package com.project.essence.repository;

import com.project.essence.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Manufacturer findByNameOfManufacturer(String name);
}
