package com.example.demo.repository;

import java.util.List;
import com.example.demo.entity.Playlist;

public interface IPlaylistRepo {
    Playlist createPlaylist(Playlist Playlist);
     Playlist getPlayListByName(String playlistName);
     List<Playlist> getAllPlaylist();
     public boolean removePlaylist(String name);
    //  Playlist addSongToPlaylist(int songId);
    //  Playlist removeSongToPlaylist(int songId);
}
