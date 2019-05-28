package com.johnny;

public class Song {

    private String songTile;
    private String songDuration;

    public Song(String songTile, String songDuration) {

        this.songTile = songTile;
        this.songDuration = songDuration;
    }

    public String getSongTile() {

        return songTile;
    }

    public String getSongDuration() {

        return songDuration;
    }

    // Only used for editing
    public void setSongTile(String songTile) {

        this.songTile = songTile;
    }

    // Only used for editing.
    public void setSongDuration(String songDuration) {

        this.songDuration = songDuration;
    }
}
