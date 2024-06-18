package com.example.streambridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeezerService {
    @Autowired
    private RestTemplate restTemplate;

    private static final String DEEZER_API_URL = "http://localhost:3001";

    public Object getPlaylistTracks(String playlistId) {
        return restTemplate.getForObject(DEEZER_API_URL + "/playlist/" + playlistId + "/tracks", Object.class);
    }
}
