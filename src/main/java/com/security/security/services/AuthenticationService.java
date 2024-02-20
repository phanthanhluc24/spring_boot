package com.security.security.services;

import com.security.security.dto.JwtAuthenticationResponse;
import com.security.security.dto.RefreshTokenRequest;
import com.security.security.dto.SignInRequest;
import com.security.security.dto.SignUpRequest;
import com.security.security.models.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SignInRequest signInRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
