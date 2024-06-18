package com.example.streambridge.entity.spotify;

public class Track {
    private String uri;

    public Track() {
    }

    public Track(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
