package org.example.service;

import org.example.web.dto.auth.JwtRequest;
import org.example.web.dto.auth.JwtResponse;

public interface AuthService {
    JwtResponse login(JwtRequest loginRequest);
    JwtResponse refresh(String refreshToken);
}
