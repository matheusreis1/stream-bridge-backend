package com.example.streambridge.dto;

import java.util.List;

public class CreatePlaylistDTO {
    private List<String> trackNames;
    private String playlistName;

    public CreatePlaylistDTO() {
    }

    public CreatePlaylistDTO(List<String> trackNames, String playlistName) {
        this.trackNames = trackNames;
        this.playlistName = playlistName;
    }

    public List<String> getTrackNames() {
        return trackNames;
    }

    public void setTrackNames(List<String> trackNames) {
        this.trackNames = trackNames;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }
}
