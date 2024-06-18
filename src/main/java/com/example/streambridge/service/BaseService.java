package com.example.streambridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public abstract class BaseService {

    @Autowired
    protected RestTemplate restTemplate;

    protected String apiUrl;


    public BaseService(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}
