package br.com.meetime.hubspot.service;

import org.springframework.stereotype.Service;

import br.com.meetime.hubspot.config.OAuth2Config;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final OAuth2Config oAuth2Config;

    public String getAuthorizationURL() {
        return "https://app.hubspot.com/oauth/authorize?client_id=" + oAuth2Config.getClientId()
                + "&scope=contacts"
                + "&redirect_uri=" + oAuth2Config.getRedirectUri();
    }
}
