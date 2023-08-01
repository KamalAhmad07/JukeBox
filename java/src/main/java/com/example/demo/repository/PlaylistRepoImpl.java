package com.example.demo.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.example.demo.entity.Playlist;

public class PlaylistRepoImpl  implements IPlaylistRepo{

    private Map<String,Playlist> playlists;
    private Integer increment;
    public PlaylistRepoImpl(){
        this.playlists = new HashMap<>();
        this.increment = 1;        
    }    
   
    @Override
    public Playlist createPlaylist(Playlist playlist) {
        playlist.setId(increment); 
        playlists.put(playlist.getName(),playlist);
        increment++;
        return playlist;    
    }

     @Override
     public boolean removePlaylist(String name) {
        return playlists.remove(name) != null;
    }

    @Override
    public Playlist getPlayListByName(String playlistName) {
        return playlists.get(playlistName);
    }

    @Override
    public List<Playlist> getAllPlaylist() {
        return playlists.values().stream()
        .collect(Collectors.toList());
    }

}