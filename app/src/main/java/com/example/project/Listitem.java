package com.example.project;

public class Listitem {

    private String url;
    private String title;
    private String thumbnail;
    private String artist;
    private String duration;


    public Listitem(String url, String title, String thumbnail, String artist, String duration) {
        this.url = url;
        this.title = title;
        this.thumbnail = thumbnail;
        this.artist = artist;
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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
