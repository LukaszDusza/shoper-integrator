package devlab.shoperintegrator.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Component
public class HttpWrapper {

    private final RestTemplate restTemplate;

    public HttpWrapper() {
        this.restTemplate = new RestTemplate();
    }

    public String getAuthToken(String url, String login, String password) {
        try {
            var authString = login + ":" + password;
            var base64Credits = Base64.getEncoder().encodeToString(authString.getBytes());
            var headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Credits);
            var request = new HttpEntity<String>(headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String performGETRequest(String url, HttpHeaders headers) {
        var request = new HttpEntity<String>(headers);
        ResponseEntity<String> response;
        try {
            response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
        return response.getBody();
    }
}
