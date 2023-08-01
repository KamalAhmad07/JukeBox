package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Song;

public interface ISongService {
    void saveSong(List<String> tokens);
    Song getSongById(int id);   
    List<Song>  getAllSong();
    boolean  songExist(int id);
}
