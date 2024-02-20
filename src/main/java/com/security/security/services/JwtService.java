package com.security.security.services;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUserName(String token);

    String generateAccessToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);

    String generateRefreshAccessToken(Map<String,Object> extraClaims,UserDetails userDetails);

    
}
