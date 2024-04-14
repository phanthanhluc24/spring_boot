package com.security.security.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface CloudinaryService {
    List<Map<String, Object>> uploadFileCloudinary(List<MultipartFile> files);
}
