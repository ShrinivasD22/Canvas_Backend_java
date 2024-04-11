package com.example.canvas.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import com.example.canvas.payload.ImageuploadDto;
import com.example.canvas.services.FileService;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final FileService fileService;

    @Autowired
    public ImageController(FileService fileService) {
        this.fileService = fileService;
    }

	@Value("${project.image}")
	private String path;
	
	
	
	
	
	 
    
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = fileService.uploadImage(path,file);
            return ResponseEntity.ok(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }

    @GetMapping(value= "/images/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(
   	@PathVariable("imageName") String imageName,
   	HttpServletResponse response	 
   		 ) throws IOException{
   	 InputStream resource = this.fileService.getResource(path, imageName);
   	 response.setContentType(MediaType.IMAGE_JPEG_VALUE);
   	 StreamUtils.copy(resource,response.getOutputStream());
    }
}
