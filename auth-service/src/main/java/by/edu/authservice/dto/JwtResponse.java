package by.edu.authservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Jwt Token Response")
public class JwtResponse {

    @Schema(description = "id", example = "1")
    private Long id;

    @Schema(description = "username", example = "username")
    private String username;

    @Schema(description = "access token", example = "12345")
    private String accessToken;

    @Schema(description = "refresh token", example = "12345")
    private String refreshToken;
}
