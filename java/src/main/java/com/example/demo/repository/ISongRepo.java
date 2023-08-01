package com.example.demo.repository;

import java.util.List;
import com.example.demo.entity.Song;

public interface ISongRepo{

     Song saveSong(Song song);    
     Song getSongById(int id);
     List<Song> getAllSong();             
}