package com.example.demo.commands;

import java.util.List;
import com.example.demo.entity.Song;
import com.example.demo.service.IPlaylistService;

public class StopSongCommand  implements ICommand{

    private  IPlaylistService playlistService;

    public StopSongCommand(IPlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void execute(List<String> tokens) {
         Song song =  playlistService.stopSong();
         if(song != null){
             System.out.println(song +" is stopped!");
         }
    }
    
}
