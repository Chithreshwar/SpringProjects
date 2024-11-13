package com.example.firstapi.utils;

import com.example.firstapi.config.RestTemplateConfig;
import com.example.firstapi.entity.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

@Component
public class AuthUtil {
    private RestTemplateConfig restTemplateConfig;

    @Autowired
    public AuthUtil(RestTemplateConfig restTemplateConfig) {
        this.restTemplateConfig = restTemplateConfig;
    }

    public boolean validateToken(String tokenValue) {
        String body = "{\"token\" :\"" + tokenValue + "\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity<>(body, headers);
        ResponseEntity<Token> response = this.restTemplateConfig.getRestTemplate().postForEntity("http://localhost:8080/user/validate-token", httpEntity, Token.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            // HTTP status is 200 OK
            Token token = response.getBody();
            return true;
        }
        return false;
    }
}
