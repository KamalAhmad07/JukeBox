package com.example.demo.commands;

import java.util.List;
import com.example.demo.entity.Song;
import com.example.demo.service.IPlaylistService;

public class PreviousSongCommand implements ICommand {

    private  IPlaylistService playlistService;

    public PreviousSongCommand(IPlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void execute(List<String> tokens) {
          Song song = playlistService.playPrevious();
          if(song != null){
            System.out.println(song +" is playing!");
        }

    }
    
}
