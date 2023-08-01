package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Playlist;
import com.example.demo.entity.Song;

public interface IPlaylistService {
    Playlist createPlaylist(List<String> tokens);
     Playlist getPlayListByName(String playlistName);
     List<Playlist> getAllPlaylist();
     boolean loadPlaylist(List<String> tokens);
     boolean removePlaylist(List<String> tokens);
     Playlist addSongToPlaylist(List<String> tokens);
     Playlist removeSongFromPlaylist(List<String> tokens);
     Song playSong();
     Song stopSong();
     Song playNext();
     Song playPrevious();
}
