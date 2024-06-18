package com.example.streambridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeezerService extends BaseService {
    public Object getPlaylistTracks(String playlistId) {
        return restTemplate.getForObject(API_URL + "/playlist/" + playlistId + "/tracks", Object.class);
    }
}
