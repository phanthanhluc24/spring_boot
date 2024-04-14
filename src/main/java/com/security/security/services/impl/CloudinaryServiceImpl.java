package com.security.security.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.security.security.services.CloudinaryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService{
    private final Cloudinary cloudinary;
    private List<String> allowExtentions=Arrays.asList("jpg", "jpeg", "png");
    private long maxFileSize=5 * 1024 * 1024;
    @Override
    public List<Map<String, Object>> uploadFileCloudinary(List<MultipartFile> files){

        List<Map<String, Object>> responses = new ArrayList<>();
        try {

            Map<String, Object> response = new HashMap<>();
            for (MultipartFile file : files) {
                if (file.isEmpty()) {
                    response.put("error","File image is not null");
                    responses.add(response);
                    continue;
                }
                String filename=StringUtils.cleanPath(file.getOriginalFilename());
                String fileExtensions=getFilenameExtension(filename);
                if (!allowExtentions.contains(fileExtensions.toLowerCase())) {
                    response.put("error", "File invalid");
                    responses.add(response);
                    continue;
                }

                if (file.getSize()>maxFileSize) {
                    response.put("error", "File so big size");
                    responses.add(response);
                    continue;
                }

                Map<String, Object> data=cloudinary.uploader().upload(file.getBytes(), Map.of());
                responses.add(data);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return responses;
    }

    private String getFilenameExtension(String filename){
        int dotIndex=filename.lastIndexOf(".");
        if (dotIndex==-1) {
            return "";
        }
        return filename.substring(dotIndex+1);
    }
}
