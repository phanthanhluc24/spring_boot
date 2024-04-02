package com.security.security.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.security.security.dto.JwtAuthenticationResponse;
import com.security.security.dto.RefreshTokenRequest;
import com.security.security.dto.SendMailRequest;
import com.security.security.dto.SignInRequest;
import com.security.security.dto.SignUpRequest;
import com.security.security.models.User;
import com.security.security.services.AuthenticationService;
import com.security.security.services.EmailService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final EmailService emailService;
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signin(signInRequest));
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<JwtAuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }

    @PostMapping("/sendMail")
    public ResponseEntity<?> sendSimpleMail(@RequestBody SendMailRequest sendMailRequest){
        emailService.sendSimpleMessage(sendMailRequest.getTo(),sendMailRequest.getSubject(),sendMailRequest.getContent());
        return ResponseEntity.ok().build();
    }
}
