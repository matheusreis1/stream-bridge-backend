package com.example.streambridge.entity.spotify;

import java.util.List;

public class TrackList {
    private List<Track> items;

    public TrackList() {
    }

    public TrackList(List<Track> items) {
        this.items = items;
    }

    public List<Track> getItems() {
        return items;
    }

    public void setItems(List<Track> items) {
        this.items = items;
    }
}
