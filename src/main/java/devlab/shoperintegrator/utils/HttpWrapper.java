package devlab.shoperintegrator.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Component
public class HttpWrapper {

    public String getAuthToken(String url, String login, String password) {
        try {
            var authString = login + ":" + password;
            var base64Credits = Base64.getEncoder().encodeToString(authString.getBytes());
            var headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Credits);
            var request = new HttpEntity<String>(headers);
            ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.POST, request, String.class);
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
