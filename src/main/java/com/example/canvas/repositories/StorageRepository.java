package com.example.canvas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.canvas.entity.ImageData;

public interface StorageRepository extends JpaRepository<ImageData,Long> {
  Optional<ImageData> findByName(String fileName);
}
