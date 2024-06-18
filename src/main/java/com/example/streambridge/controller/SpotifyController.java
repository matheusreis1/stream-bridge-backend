package com.example.streambridge.controller;

import com.example.streambridge.dto.CreatePlaylistDTO;
import com.example.streambridge.entity.spotify.Playlist;
import com.example.streambridge.entity.spotify.Track;
import com.example.streambridge.entity.spotify.User;
import com.example.streambridge.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spotify")
public class SpotifyController {
    @Autowired
    private SpotifyService spotifyService;

    @PostMapping("/playlist")
    public void createPlaylist(@RequestBody CreatePlaylistDTO requestBody) {
        List<Track> tracks = spotifyService.getTracks(requestBody.getTrackNames());

        User user = spotifyService.getUser("");

        Playlist playlist = spotifyService.createPlaylist(user.getId(), requestBody.getPlaylistName());

        List<String> tracksUris = tracks.stream()
                .map(Track::getUri)
                .toList();

        spotifyService.addTracksToPlaylist(tracksUris, playlist.getId());
    }
}
