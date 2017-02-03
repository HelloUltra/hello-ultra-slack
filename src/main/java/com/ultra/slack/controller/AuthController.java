package com.ultra.slack.controller;

import com.ultra.config.SlackEnvironment;
import com.ultra.slack.response.CommonResponse;
import com.ultra.slack.response.SlackTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by YG-MAC on 2017. 2. 3..
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private SlackEnvironment slackEnvironment;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/authorize")
    public CommonResponse authorize(@RequestParam String code) {
        try {
            if (code != null) {
                logger.debug("code - {}", code);
            }
            logger.debug("url - {}", slackEnvironment.buildAccessUrl(code));
            SlackTokenResponse slackTokenResponse = restTemplate.getForObject(slackEnvironment.buildAccessUrl(code), SlackTokenResponse.class);
            if (slackTokenResponse != null) {
                logger.debug("slackTokenResponse - {}", slackTokenResponse.toString());
            }
        } catch (Exception e) {
            logger.error("authorize error - {}", e);
            return CommonResponse.FAILED(e.getMessage());
        }
        return CommonResponse.SUCCESS;
    }
}
