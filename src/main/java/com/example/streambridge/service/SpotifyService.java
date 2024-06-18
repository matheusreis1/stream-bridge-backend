package com.example.streambridge.service;

import com.example.streambridge.entity.spotify.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class SpotifyService extends BaseService {

    public SpotifyService() {
        super("https://api.spotify.com");
    }

    public User getUser(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> request = new HttpEntity<>(null, headers);

        return restTemplate.getForObject(apiUrl + "/me", User.class, request);
    }

    public List<Track> getTracks(List<String> tracksNames) {
        List<CompletableFuture<Track>> futures = tracksNames.stream()
                .map(trackName -> CompletableFuture.supplyAsync(() ->
                {
                    SearchResponse searchResponse = restTemplate.getForObject(apiUrl + "/search?q=" + trackName, SearchResponse.class);
                    assert searchResponse != null;
                    TrackList tracksResponse = searchResponse.getTracks().get(0);
                    return tracksResponse.getItems().get(0);
                }))
                .toList();

        return futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public Playlist createPlaylist(String userId, String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(name, headers);

        return restTemplate.postForObject(apiUrl + "/users/" + userId + "/playlists", request, Playlist.class);
    }

    public void addTracksToPlaylist(List<String> uris, String playlistId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<List<String>> request = new HttpEntity<>(uris, headers);

        restTemplate.postForObject(apiUrl + "/playlists/" + playlistId + "/tracks", request, Object.class);
    }
}
