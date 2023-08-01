package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Song;
import com.example.demo.repository.ISongRepo;

public class SongServiceImpl implements ISongService {

    private ISongRepo songRepo;
    
    public SongServiceImpl(ISongRepo songRepo){
        this.songRepo = songRepo;
    }

    @Override
    public void saveSong(List<String> tokens) {
        String name = tokens.get(1).trim();
        String artist =tokens.get(2).trim();;
        String album = tokens.get(3).trim();
        String genre = tokens.get(4).trim();
      
        Song song = new Song(name,artist,album,genre);        
        song =  songRepo.saveSong(song);
        System.out.println(song);

    }

    @Override
    public Song getSongById(int id) {       
          Song song = songRepo.getSongById(id);
          return song;
    }
    
    @Override
    public boolean  songExist(int id){
        Song song  = songRepo.getSongById(id);
        return song == null?false:true;
    }

    @Override
    public List<Song> getAllSong() {
        List<Song>  allSongs = songRepo.getAllSong();
        return allSongs;
    }
        
}
