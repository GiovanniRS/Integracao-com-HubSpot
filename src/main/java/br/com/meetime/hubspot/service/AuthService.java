package br.com.meetime.hubspot.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.meetime.hubspot.config.OAuth2Config;
import br.com.meetime.hubspot.dto.OAuthTokenResponse;
import br.com.meetime.hubspot.model.Token;
import br.com.meetime.hubspot.repository.TokenRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private final OAuth2Config oAuth2Config;

    private final TokenRepository tokenRepository;

    public String getAuthorizationURL() {
        return "https://app.hubspot.com/oauth/authorize?client_id=" + oAuth2Config.getClientId()
                + "&redirect_uri=" + oAuth2Config.getRedirectUri()
                + "&scope=" + oAuth2Config.getScopes();
    }

    public String changeCodeForToken(String code) {
        OAuthTokenResponse response = webClientBuilder.baseUrl("https://api.hubapi.com")
                .build()
                .post()
                .uri("/oauth/v1/token")
                .bodyValue(Map.of(
                        "grant_type", "authorization_code",
                        "client_id", oAuth2Config.getClientId(),
                        "client_secret", oAuth2Config.getClientSecret(),
                        "redirect_uri", oAuth2Config.getRedirectUri(),
                        "code", code))
                .retrieve()
                .bodyToMono(OAuthTokenResponse.class)
                .block();

        tokenRepository.save(new Token(response.getAccess_token(), response.getExpires_in()));
        return response.getAccess_token();
    }

}
