package com.example.demo.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.example.demo.entity.Song;

public class SongRepoImpl  implements ISongRepo{

    Map<Integer,Song> allSongs ;
    Integer id;
    
    public SongRepoImpl() {
        this.allSongs = new HashMap<>();
        this.id = 1;
    }

    @Override
    public Song saveSong(Song song) {       
        song.setId(id);
        allSongs.put(id, song);
        id++;
        return song; 
    }

    @Override
    public Song getSongById(int id) {
       return allSongs.get(id);
    }

    
    @Override
    public List<Song> getAllSong() {
         return allSongs.values().stream().collect(Collectors.toList());
    }
    
    
}
