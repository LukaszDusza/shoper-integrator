package devlab.shoperintegrator.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthTokenModel {

    @JsonProperty(value = "access_token")
    private String accessToken;
    @JsonProperty(value = "refresh_token")
    private String refreshToken;
    @JsonProperty(value = "expires_in")
    private long expiresIn;
    @JsonProperty(value = "token_type")
    private String tokenType;
    private String scope;
}
