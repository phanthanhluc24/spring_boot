package com.security.security.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloundinaryConfig {
    @Value("${cloundinary.name}")
    private String cloundinaryName;
    @Value("${cloundinary.key}")
    private String cloundinaryKey;
    @Value("${cloundinary.secret}")
    private String cloundinarySecret;

    @Bean
    public Cloudinary getCloudinary() {
        Cloudinary cloundinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloundinaryName,
                "api_key", cloundinaryKey,
                "api_secret", cloundinarySecret));
        return cloundinary;
    }
}
