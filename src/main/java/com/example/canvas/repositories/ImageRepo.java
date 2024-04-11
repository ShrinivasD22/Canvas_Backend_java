package com.example.canvas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.canvas.entity.Imageupload;



public interface ImageRepo extends JpaRepository<Imageupload,Integer> {
     
	
	
}

