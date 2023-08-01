package com.example.demo.commands;

import java.util.List;
import com.example.demo.entity.Playlist;
import com.example.demo.service.IPlaylistService;

public class DeleteSongFromPlaylistCommand implements ICommand{

    private  IPlaylistService playlistService;
    
    public DeleteSongFromPlaylistCommand(IPlaylistService playlistService) {
        this.playlistService = playlistService;
    }
    @Override
    public void execute(List<String> tokens) {
        Playlist playlist = playlistService.removeSongFromPlaylist(tokens);
        if(playlist != null){
            System.out.println("Playlist "+playlist.getName()+" is revised with "+
            playlist.getSongsList());
        }
    }
    
}
