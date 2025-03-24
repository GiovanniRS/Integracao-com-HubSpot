package br.com.meetime.hubspot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OAuthTokenResponse {
    private String refresh_token;
    private String access_token;
    private int expires_in;
}
