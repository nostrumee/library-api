package by.edu.authservice.service;

import by.edu.authservice.dto.JwtRequest;
import by.edu.authservice.dto.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);

}
