package com.johnny;

import java.util.*;

public class Main {

    public static Album album;

    public static Scanner scanner = new Scanner(System.in);

    public static ArrayList<Album> music = new ArrayList<Album>();

    public static LinkedList<PlayList> playList = new LinkedList<PlayList>();


    public static void main(String[] args) {


        // LOADING MUSIC
        // Note: more functionality can be made in Album class "get(0)"
        // add a song, name an album.
        music.add(new Album("The Choir"));
        // setAlbumSong adds to the same album in get(index).
        music.get(0).addAlbumSong("Angles are here", "08:21");
        music.get(0).addAlbumSong("Nutcracker", "05:10");

        System.out.println("Here temp");
        System.out.println(music.get(0).getAlbum().get(0).getSongTile());
        System.out.println(music.get(0).getAlbum().get(1).getSongTile());

        music.add(new Album("Winter Hymns"));
        music.get(1).addAlbumSong("Snowman's calling", "05:38");
        music.get(1).addAlbumSong("White Christmas", "04:28");
        music.get(1).addAlbumSong("Winter for all", "02:18");

        music.add(new Album("Hard Rock"));
        music.get(2).addAlbumSong("Jamming", "03:15");
        music.get(2).addAlbumSong("Super funk!", "02:58");
        music.get(2).addAlbumSong("Coolness", "04:23");
        music.get(2).addAlbumSong("Broke stereo", "03:31");


        playListMessage();

        appMessage();


    }
    public static void appMessage(){

        boolean quit = false;
        while (!quit){

            int choice = printMenu();

            switch (choice){
                case 1:
                    buildPlayList();
                    break;
                case 2:
                    showPlayList();
                    break;
                case 3:
                    removeFromPlayList();
                    break;
                case 4:
                    playing();
                case 5:
                    quit = true;
                    break;

                default:
                    System.out.println("error, enter 1 - 5.");
            }
        }
    }
    public static void playMenu(){

        System.out.println("enter a play menu choice..");

        System.out.println("Now playing: ");
        System.out.println(playList.get(0).getAlbumName());
        System.out.println(playList.get(0).getSongName());
        System.out.println(playList.get(0).getSongDuration());

        System.out.println("\t0 - quit to app");
        System.out.println("\t1 - pause");
        System.out.println("\t2 - forward track");
        System.out.println("\t3 - back track");
        System.out.println("\t4 - skip");
        System.out.println("\t5 - remove current track");


    }
    public static void playing(){

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<PlayList> listIterator = playList.listIterator();

        if (playList.isEmpty()){
            System.out.println("empty playlist");
        }else {
            System.out.println("Now playing " + listIterator.next().getSongName());

            playMenu();
            while (!quit){
                int action = scanner.nextInt();
                switch (action) {
                    case 0:
                        System.out.println("playing stopped");
                        quit = true;
                        appMessage();
                        break;
                    // Forward
                    case 1:
                        System.out.println("pause..");
                        break;
                    case 2:
                        // Checks: that you can go forward from where you left off.
                        // Is: a test if going forward.
                        if (!goingForward){
                            if (listIterator.hasPrevious()){
                                listIterator.next();
                            }
                            goingForward = true;
                        }
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing: " + listIterator.next().getSongName());
                        }else {
                            System.out.println("reached end of list");
                            goingForward = false;
                        }
                        break;
                    // Backwards
                    case 3:
                        // Checks: User has selected to go previous
                        if (goingForward){
                            if (listIterator.hasPrevious()){
                                listIterator.previous();
                            }
                            goingForward = false;
                        }
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().getSongName());
                        }else{
                            System.out.println("We're at the start of the playlist");
                            // Start of list, now going forward.
                            goingForward = true;
                        }
                    case 5:
                        listIterator.remove();
                        break;
                }
            }
        }
    }
    public static void removeFromPlayList(){

        System.out.println("Enter queue to remove: ");
        int queue = scanner.nextInt();

        playList.remove(queue);

        System.out.println("Update playlist..");
        showPlayList();
    }
    public static void showPlayList(){

        for (int i=0; i<playList.size(); i++){

            System.out.println("queue no.: " + i);
            System.out.println(playList.get(i).getAlbumName());
            System.out.println(playList.get(i).getSongName());
            System.out.println(playList.get(i).getSongDuration());
            System.out.println("===============================");

        }
    }
    public static int printMenu(){

        System.out.println("Enter a choice..");
        System.out.println("\t1 - to build playlist");
        System.out.println("\t2 - to show playlist");
        System.out.println("\t3 - remove a track from playlist");
        System.out.println("\t4 - playlist menu");
        System.out.println("\t5 - quit app");

        int choice = scanner.nextInt();
        return choice;

    }
    public static void buildPlayList(){

        boolean quit = false;
        System.out.println("Building playlist...");
        while (!quit) {

            System.out.println("Enter album no.:");
            int albumNo = scanner.nextInt();

            System.out.println("Enter song no.:");
            int songNo = scanner.nextInt();

            String album = music.get(albumNo).getAlbumName();
            String song = music.get(albumNo).getAlbum().get(songNo).getSongTile();
            String duration = music.get(albumNo).getAlbum().get(songNo).getSongDuration();

            playList.add(new PlayList(album, song, duration));

            System.out.println(album);
            System.out.println("\t" + song);
            System.out.println("added..");


            System.out.println("continue (Y/N)? ");
            String input = scanner.next();

            if (input.equals("N"))
                break;

        }
    }
    public static void playListMessage(){

        System.out.println("Build your playlist:");
        System.out.println("========================");
        for (int i=0; i<music.size(); i++){

            System.out.println( "Album No.: " + i + " " + music.get(i).getAlbumName());
            music.get(i).printSongs();
            System.out.println("\n");
        }
    }

}