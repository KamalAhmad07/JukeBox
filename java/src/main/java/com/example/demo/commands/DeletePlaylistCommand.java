package com.example.demo.commands;

import java.util.List;
import com.example.demo.service.IPlaylistService;

public class DeletePlaylistCommand implements ICommand {

    private  IPlaylistService playlistService;
    
    public DeletePlaylistCommand(IPlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void execute(List<String> tokens) {
        boolean b =    playlistService.removePlaylist(tokens);
        if(b){
           System.out.println("Playlist "+tokens.get(1) +" is deleted!");
        }
               
    }
    
}
