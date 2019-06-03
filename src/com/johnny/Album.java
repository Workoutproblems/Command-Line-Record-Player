package com.johnny;

import java.util.ArrayList;

public class Album {

    // Album Fields
    private String albumName;

    private SongList songlist = new SongList();

    public Album(String albumName) { this.albumName = albumName; }

    public ArrayList<Song> getAlbum() { return songlist.songs; }

    //**************************
    // Add song to Album meathod
    //**************************
    public void addAlbumSong(String song, String duration){
        songlist.songs.add(new Song(song, duration));
    }

    public String getAlbumName() { return albumName; }

    public void printSongs(){

        for (int i=0; i<songlist.songs.size(); i++){
            System.out.print("\t" + "song no. " + i + ": " + songlist.songs.get(i).getSongDuration());
            System.out.println("\t" + songlist.songs.get(i).getSongTile());
        }
    }

    //**************
    //SongList class
    //**************
    // Modify the playlist so that the Album class uses an inner class.
    public class SongList {

        // The inner SongList class will use an ArrayList
        private ArrayList<Song> songs = new ArrayList<Song>();

        // ... and will provide a method to add a song.
        public ArrayList<Song> getSongs() {
            return songs;
        }

        // method to add a song
        public void addSong(String song, String duration) { songs.add(new Song(song, duration)); }
    }
}
