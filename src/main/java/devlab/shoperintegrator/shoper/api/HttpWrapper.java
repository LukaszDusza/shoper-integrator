package devlab.shoperintegrator.shoper.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import devlab.shoperintegrator.utils.EnvironmentUtils;
import devlab.shoperintegrator.utils.LoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class HttpWrapper<T> {
    private static final Logger logger = LoggerFactory.getLogger(HttpWrapper.class);
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public HttpWrapper() {
        this.restTemplate = getRestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public String getAccessToken(String url, String login, String password) {
        try {
            var authString = login + ":" + password;
            var base64Credits = Base64.getEncoder().encodeToString(authString.getBytes());
            var headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Credits);
            var request = new HttpEntity<String>(headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
            logger.info("Received response: {}", response);
            return response.getBody();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public ResponseEntity<String> performGETRequest(String url, HttpHeaders headers) {
        var request = new HttpEntity<String>(headers);
        ResponseEntity<String> response;
        try {
            response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    public String performPOSTRequest(String url, HttpHeaders headers, T object) {
        var request = new HttpEntity<T>(object, headers);
        ResponseEntity<String> response;
        try {
            response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
        return response.getBody();
    }

    public String performPUTRequest(String url, HttpHeaders headers, T object) {
        var request = new HttpEntity<T>(object, headers);
        ResponseEntity<String> response;
        try {
            response = restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
        return response.getBody();
    }

    private RestTemplate getRestTemplate() {
        RestTemplate rt = new RestTemplate();
        rt.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        List<ClientHttpRequestInterceptor> interceptors = rt.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(new LoggingInterceptor());
    //    rt.setInterceptors(interceptors); todo do naprawy interceptor
        return rt;
    }

    public String getAccessToken() {
        var login = EnvironmentUtils.getEnv("login");
        var password = EnvironmentUtils.getEnv("password");
        var url = "https://loftstore.pl/webapi/rest/auth";
        var responseBody = getAccessToken(url, login, password);
        if (responseBody == null) {
            logger.error("responseBody is null for url {}", url);
            return null;
        }
        logger.info("received responseBody {}", responseBody);
        Token accessToken;
        try {
            accessToken = objectMapper.readValue(responseBody, Token.class);
            logger.info("authTokenModel: {}", accessToken);
        } catch (JsonProcessingException e) {
            logger.error("Cannot deserialize authTokenModel: {}", e.getMessage());
            e.printStackTrace();
            return null;
        }
        EnvironmentUtils.setProperty("token", accessToken.getAccessToken());
        logger.debug("set accessToken: {}", accessToken.getAccessToken());
        return accessToken.getAccessToken();
    }
}

