package com.project.essence.repository;

import com.project.essence.model.Image;
import com.project.essence.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findImagesByProductId(Long id);
}
