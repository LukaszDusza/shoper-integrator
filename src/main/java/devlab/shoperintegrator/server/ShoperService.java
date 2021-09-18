package devlab.shoperintegrator.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import devlab.shoperintegrator.model.products.Products;
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
            logger.error("Cannot deserialize authTokenModel: {}", e.getMessage());
            e.printStackTrace();
            return null;
        }
        EnvironmentUtils.setProperty("token", authToken.getAccessToken());
        return authToken;
    }

    Products getProducts() {
        String token = EnvironmentUtils.getProperty("token");
        if(token == null) {
            token = getAuthToken().getAccessToken();
            logger.debug("getting new access token: {}", token);
        }
        var headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        String responseBody = httpWrapper.performGETRequest("https://loftstore.pl/webapi/rest/products?limit=50&page=1", headers);
        Products products;
        try {
            products = objectMapper.readValue(responseBody, Products.class);
        } catch (JsonProcessingException e) {
            logger.error("cannot deserialize responseBody: {}, {}", responseBody, e.getMessage());
            return null;
        }
    return products;
    }


}
