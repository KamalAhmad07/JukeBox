package com.example.demo.commands;

import java.util.List;
import com.example.demo.entity.Playlist;
import com.example.demo.service.IPlaylistService;

public class CreatePlaylistCommand  implements ICommand{

    private  IPlaylistService playlistService;

    public CreatePlaylistCommand(IPlaylistService playlistService) {
        this.playlistService = playlistService;        
    }


    @Override
    public void execute(List<String> tokens) {
         Playlist playlist =  playlistService.createPlaylist(tokens);
         System.out.println(playlist);

    }
    
}
