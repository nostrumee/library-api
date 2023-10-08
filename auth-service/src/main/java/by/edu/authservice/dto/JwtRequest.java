package by.edu.authservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Login Request")
public class JwtRequest {

    @Schema(description = "username", example = "username")
    private String username;

    @Schema(description = "password", example = "password")
    private String password;
}
