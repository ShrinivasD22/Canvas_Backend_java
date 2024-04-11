package com.example.canvas.entity;

import java.util.Date;
import java.util.Set;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ImageUpload")
@Getter
@Setter
@NoArgsConstructor
public class Imageupload {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer imageId;
	
	
	
	
}
