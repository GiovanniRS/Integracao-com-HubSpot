package br.com.meetime.hubspot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "hubspot.oauth")
@Getter
@Setter
public class OAuth2Config {
    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String authUrl;
    private String tokenUrl;
    private String scopes;
}
