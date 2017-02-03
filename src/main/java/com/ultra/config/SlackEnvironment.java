package com.ultra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by YG-MAC on 2017. 2. 3..
 */
@Configuration
@ConfigurationProperties(locations = {"file:/data/slack-bot.yml", "classpath:/properties/slack-bot.yml", "file:/data/slack-api.yml", "classpath:/properties/slack-api.yml"}, prefix = "slack")
public class SlackEnvironment {

    private String clientId;

    private String secret;

    private String authToken;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    private Oauth oauth = new Oauth();

    public Oauth getOauth() {
        return oauth;
    }

    private class Oauth {
        private String access;

        public void setAccess(String access) {
            this.access = access;
        }
    }

    public String buildAccessUrl(String code){
        return UriComponentsBuilder
                .fromUriString(oauth.access)
                .queryParam("client_id", clientId)
                .queryParam("client_secret", secret)
                .queryParam("code", code)
                .build()
                .toString();
    }
}
