package com.ultra.slack.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by YG-MAC on 2017. 2. 4..
 */
@JsonIgnoreProperties
public class SlackEventRequest {

    private String toekn;

    private String challenge;

    @JsonProperty(value = "team_id")
    private String temaId;

    @JsonProperty(value = "api_app_id")
    private String apiAppId;

    private String type;

    @JsonProperty(value = "authed_users")
    private List<String> authedUsers;

    private Event event;

    @JsonIgnoreProperties
    private class Event {
        private String type;
        private String channel;
        private String user;
        private String text;
        private Long ts;
    }

    @JsonIgnore
    public boolean isValidCheck(){
        return "url_verification".equals(this.type);
    }

    public ResponseEntity<String> validResult(){
        if(challenge == null){
            return new ResponseEntity<>("not found challenge", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(challenge, HttpStatus.OK);
    }

    @Override
    public String toString() {
        return "SlackEventRequest{" +
                "toekn='" + toekn + '\'' +
                ", challenge='" + challenge + '\'' +
                ", temaId='" + temaId + '\'' +
                ", apiAppId='" + apiAppId + '\'' +
                ", type='" + type + '\'' +
                ", authedUsers=" + authedUsers +
                ", event=" + event +
                '}';
    }
}
