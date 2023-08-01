package com.example.demo.commands;

import java.util.List;
import com.example.demo.entity.Song;
import com.example.demo.service.IPlaylistService;

public class NextSongCommand implements ICommand {
   
    private  IPlaylistService playlistService;
    

    public NextSongCommand(IPlaylistService playlistService) {
        this.playlistService = playlistService;
    }


    @Override
    public void execute(List<String> tokens) {
        Song song = playlistService.playNext();
        if(song != null){
            System.out.println(song +" is playing!");
        }
    }
    
}
