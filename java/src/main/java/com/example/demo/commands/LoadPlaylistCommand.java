package com.example.demo.commands;

import java.util.List;
import com.example.demo.service.IPlaylistService;

public class LoadPlaylistCommand implements ICommand{

    private  IPlaylistService playlistService;
    
    public LoadPlaylistCommand(IPlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void execute(List<String> tokens) {
        boolean b =  playlistService.loadPlaylist(tokens);
        if(b) System.out.println("Playlist "+ tokens.get(1)+" is loaded!");
        else System.out.println("Playlist not Found !! "+tokens.get(1));
    }
    
}
