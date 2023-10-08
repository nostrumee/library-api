package by.edu.authservice.controller;

import by.edu.authservice.dto.JwtRequest;
import by.edu.authservice.dto.JwtResponse;
import by.edu.authservice.dto.UserDTO;
import by.edu.authservice.entity.User;
import by.edu.authservice.mapper.UserMapper;
import by.edu.authservice.service.AuthService;
import by.edu.authservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name ="Auth Controller", description = "Auth API")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping("/login")
    @Operation(summary = "Login with username and password")
    public JwtResponse login(@RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public UserDTO register(@RequestBody UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User createdUser = userService.create(user);
        return userMapper.toDTO(createdUser);
    }

    @PostMapping("/refresh")
    @Operation(summary = "Refresh token")
    public JwtResponse refresh(@RequestBody final String refreshToken) {
        return authService.refresh(refreshToken);
    }

}
