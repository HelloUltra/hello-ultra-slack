package com.ultra.slack.controller;

import com.ultra.slack.request.SlackEventRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YG-MAC on 2017. 2. 4..
 */
@RestController
@RequestMapping(value = "/event")
public class EventController {

    private static final ResponseEntity<String> OK = new ResponseEntity<>("OK", HttpStatus.OK);

    @PostMapping("/hook")
    private ResponseEntity<String> event(@RequestBody SlackEventRequest slackEventRequest){
        if(slackEventRequest.isValidCheck()){
            return slackEventRequest.validResult();
        }

        return OK;
    }
}
