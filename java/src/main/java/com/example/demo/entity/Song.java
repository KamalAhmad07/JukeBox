package com.example.demo.entity;

import com.example.demo.constants.*;;

public class Song {
     private int id;
     private String name;
     private String artist;
     private String album;
     private String genre;
     private SongStatus songStatus;

     
     public Song(int id, String name, String artist, String album, String genre) {
          this.id = id;
          this.name = name;
          this.artist = artist;
          this.album = album;
          this.genre = genre;
          this.songStatus = SongStatus.PAUSE;
     }

     public Song(String name, String artist, String album, String genre) {
          this.name = name;
          this.artist = artist;
          this.album = album;
          this.genre = genre;
          this.songStatus = SongStatus.PAUSE;
     }
     public int getId() {
          return id;
     }


     public void setId(int id) {
          this.id = id;
     }
     public String getName() {
          return name;
     }
     public void setName(String name) {
          this.name = name;
     }
     public String getArtist() {
          return artist;
     }
     public void setArtist(String artist) {
          this.artist = artist;
     }
     public String getAlbum() {
          return album;
     }
     public void setAlbum(String album) {
          this.album = album;
     }
     public String getGenre() {
          return genre;
     }
     public void setGenre(String genre) {
          this.genre = genre;
     }     
     public SongStatus getSongStatus() {
          return songStatus;
     }
     public void setSongStatus(SongStatus songStatus) {
          this.songStatus = songStatus;
     }
     @Override
     public String toString() {
          return "Song [id=" + id + "]";
     }


}
