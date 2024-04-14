package com.security.security.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/upload")
public class UploadImageFolder {
    @Value("${upload.dir}")
    private String uploadDir;

    private List<String> allowExtentions=Arrays.asList("jpg", "jpeg", "png");

    private long maxFileSize=5 * 1024 * 1024;
    @PostMapping("/image")
    public String handleFileUpload(@RequestBody List<MultipartFile> files){
        if (files.isEmpty()) {
            return "Please attach file";
        }
        List<String> uploadedFiles = new ArrayList<>();
        for (MultipartFile file : files) {
    
            try {
                String filename=StringUtils.cleanPath(file.getOriginalFilename());
    
                String fileExtension=getFilenameExtension(filename);
    
                if (!allowExtentions.contains(fileExtension.toLowerCase())) {
                    return "File type not allowed. Allowed types are: " + allowExtentions;
                }
    
                if (file.getSize()>maxFileSize) {
                    return "File size exceeds the allowed limit of " + maxFileSize / (1024 * 1024) + "MB";
                }
                File filePath=new File(uploadDir+File.separator+filename);
                file.transferTo(filePath);
                uploadedFiles.add(filename);
            } catch (Exception e) {
                return "Failed to upload file"+e;
            }
        }
        return "Files uploaded successfully: " + uploadedFiles;
    }

    private String getFilenameExtension(String filename){
        int dotIndex=filename.lastIndexOf(".");
        if (dotIndex==-1) {
            return "";
        }
        return filename.substring(dotIndex+1);
    }
}
