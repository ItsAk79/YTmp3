package com.example.project;

public class Listsong {

    private String thumbnail;
    private String title;
    private String artist;
    private String duration;

    public Listsong(String thumbnail, String title, String artist, String duration) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
