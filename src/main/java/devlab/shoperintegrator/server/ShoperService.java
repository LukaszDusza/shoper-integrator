package devlab.shoperintegrator.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import devlab.shoperintegrator.utils.EnvironmentUtils;
import devlab.shoperintegrator.utils.HttpWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ShoperService {
    private static final Logger logger = LoggerFactory.getLogger(ShoperService.class);
    private final HttpWrapper httpWrapper;

    public ShoperService(HttpWrapper httpWrapper) {
        this.httpWrapper = httpWrapper;
    }

    AuthTokenModel getAuthToken() {
        var login = EnvironmentUtils.getProperty("login");
        var password = EnvironmentUtils.getProperty("password");
        var url = "https://loftstore.pl/webapi/rest/auth";
        var responseBody = httpWrapper.getAuthToken(url, login, password);
        if (responseBody == null) {
            logger.error("responseBody is null for url {}", url);
            return null;
        }
        logger.info("received responseBody {}", responseBody);
        var objectMapper = new ObjectMapper();
        AuthTokenModel authToken = null;
        try {
            authToken = objectMapper.readValue(responseBody, AuthTokenModel.class);
            logger.info("authTokenModel: {}", authToken);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return authToken;
    }
}
