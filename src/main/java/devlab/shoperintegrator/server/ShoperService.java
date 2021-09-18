package devlab.shoperintegrator.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import devlab.shoperintegrator.utils.EnvironmentUtils;
import devlab.shoperintegrator.utils.HttpWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class ShoperService {
    private static final Logger logger = LoggerFactory.getLogger(ShoperService.class);
    private final HttpWrapper httpWrapper;
    private final ObjectMapper objectMapper;

    public ShoperService(HttpWrapper httpWrapper) {
        this.httpWrapper = httpWrapper;
        this.objectMapper = new ObjectMapper();
    }

    Token getAuthToken() {
        var login = EnvironmentUtils.getEnv("login");
        var password = EnvironmentUtils.getEnv("password");
        var url = "https://loftstore.pl/webapi/rest/auth";
        var responseBody = httpWrapper.getAuthToken(url, login, password);
        if (responseBody == null) {
            logger.error("responseBody is null for url {}", url);
            return null;
        }
        logger.info("received responseBody {}", responseBody);
        Token authToken;
        try {
            authToken = objectMapper.readValue(responseBody, Token.class);
            logger.info("authTokenModel: {}", authToken);
        } catch (JsonProcessingException e) {
            logger.error("Cannot parse authTokenModel: {}", e.getMessage());
            e.printStackTrace();
            return null;
        }
        EnvironmentUtils.setProperty("token", authToken.getAccessToken());
        return authToken;
    }

    Categories getCategories() {
        String token = EnvironmentUtils.getProperty("token");
        var headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        String responseBody = httpWrapper.performGETRequest("https://loftstore.pl/webapi/rest/categories", headers);
        Categories categories;
        try {
            categories = objectMapper.readValue(responseBody, Categories.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    return categories;
    }

    //todo dodac obsluge wymiany auth tokena na access token. zamiec to w metodach api.
}
