package com.security.security.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.security.security.services.impl.CloudinaryServiceImpl;

@RestController
@RequestMapping("/api/v1/cloudinary")
public class CloudinaryController {
    @Autowired
    private CloudinaryServiceImpl cloudinaryServiceImpl;

    @PostMapping("/image")
    public ResponseEntity<List<Map<String, Object>>> uploadImageCloudinary(@RequestBody List<MultipartFile> files){
        try {
            List<Map<String, Object>> data = cloudinaryServiceImpl.uploadFileCloudinary(files);
            return new ResponseEntity<>(data,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
