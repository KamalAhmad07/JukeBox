package com.example.demo.entity;

import java.util.List;

public class Playlist {
    private int id;
    private String name;
    private List<Song> songsList;


    public Playlist(String name, List<Song> songsList) {
        this.name = name;
        this.songsList = songsList;
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


    public List<Song> getSongsList() {
        return songsList;
    }


    public void setSongsList(List<Song> songsList) {
        this.songsList = songsList;
    }


    @Override
    public String toString() {
        return "Playlist [id=" + id + "]";
    }
    
}


