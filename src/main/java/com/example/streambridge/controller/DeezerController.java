package com.example.streambridge.controller;

import com.example.streambridge.service.DeezerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deezer")
public class DeezerController {
    @Autowired
    private DeezerService deezerService;

    @GetMapping("/playlists/{id}/tracks")
    public Object getPlaylistTracks(@PathVariable String id) {
        return deezerService.getPlaylistTracks(id);
    }
}
