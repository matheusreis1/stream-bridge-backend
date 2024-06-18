package com.example.streambridge.entity.spotify;

import java.util.List;

public class SearchResponse {
    private List<TrackList> tracks;

    public SearchResponse() {
    }

    public SearchResponse(List<TrackList> tracks) {
        this.tracks = tracks;
    }

    public List<TrackList> getTracks() {
        return tracks;
    }

    public void setTracks(List<TrackList> tracks) {
        this.tracks = tracks;
    }
}
