package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.demo.counter.Counter;

@RestController
public class RequestController {
    Logger logger = LogManager.getLogger(RequestController.class);

    @GetMapping("/request")
    public String requestController() {
        logger.info("Visited request controller");
        return "Number of service request:  " + Counter.getCount() ;
    }
}
