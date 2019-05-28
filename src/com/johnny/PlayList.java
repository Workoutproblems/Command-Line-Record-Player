package com.johnny;

public class PlayList {

    private String songName;
    private String songDuration;
    private String albumName;

    public PlayList(String albumName, String songName, String songDuration) {
        this.songName = songName;
        this.songDuration = songDuration;
        this.albumName = albumName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
