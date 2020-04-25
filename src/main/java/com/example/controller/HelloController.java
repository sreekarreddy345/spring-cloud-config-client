package com.example.controller;

import com.example.pojo.DbSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {

    @Value("${my.greeting: default value}")
    private String greetingMessage;

    @Autowired
    private DbSettings dbSettings;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String test() {
        return "my.greeting: " + greetingMessage + " db.connection " + dbSettings.getConnection() +
                " db.host: " + dbSettings.getHost() + " db.port: " + dbSettings.getPort();
    }
}
