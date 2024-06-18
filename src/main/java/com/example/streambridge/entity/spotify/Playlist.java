package com.example.streambridge.entity.spotify;

public class Playlist {
    private String id;

    public Playlist() {
    }

    public Playlist(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
