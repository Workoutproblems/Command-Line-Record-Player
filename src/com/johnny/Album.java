package com.johnny;

import java.util.ArrayList;

public class Album {


    private String albumName;

    // SongList object.
    private SongList songlist = new SongList();

    // Instead of using an ArrayList, it will use an inner class..
    //private ArrayList<Song> albumSong;


    public Album(String albumName) {

        //this.albumSong = new ArrayList<Song>();
        this.albumName = albumName;
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
        public void addSong(String song, String duration) {

            songs.add(new Song(song, duration));
        }
    }



    // Need fix: no longer needed?
    public ArrayList<Song> getAlbum() {

        //return albumSong;
        return songlist.songs;
    }

    // Need fix: using SongList method..
//    public void addAlbumSong(String  albumSong, String duration) {
//
//        this.albumSong.add(new Song(albumSong, duration));
//    }
    //*****
    // FIX
    //*****
    public void addAlbumSong(String song, String duration){
        songlist.songs.add(new Song(song, duration));
    }


    // Need fix: implement with song method.
    public void printSongs(){

        //for (int i=0; i<albumSong.size(); i++){

        for (int i=0; i<songlist.songs.size(); i++){
            System.out.print("\t" + "song no. " + i + ": " + songlist.songs.get(i).getSongDuration());
            System.out.println("\t" + songlist.songs.get(i).getSongTile());
        }
    }



    public String getAlbumName() {

        return albumName;
    }
}
