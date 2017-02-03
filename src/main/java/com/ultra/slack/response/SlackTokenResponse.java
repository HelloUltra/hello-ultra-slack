package com.ultra.slack.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by YG-MAC on 2017. 2. 4..
 */
@JsonIgnoreProperties
public class SlackTokenResponse {
    private boolean ok;

    @JsonProperty(value = "access_token")
    private String accessToken;

    private String scope;

    @Override
    public String toString() {
        return "SlackTokenResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
