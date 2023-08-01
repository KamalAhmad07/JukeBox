package com.example.demo.commands;

import java.util.List;
import com.example.demo.entity.Playlist;
import com.example.demo.service.IPlaylistService;
import com.example.demo.service.ISongService;

public class AddSongToPlayListCommand implements ICommand {
  
   private  IPlaylistService playlistService;
   private ISongService songService;

    public AddSongToPlayListCommand(IPlaylistService playlistService, ISongService service) {
      this.playlistService = playlistService;
      this.songService = service;
   }

    @Override
    public void execute(List<String> tokens) {
         Playlist playlist = playlistService.addSongToPlaylist(tokens);
         if(playlist != null){
             System.out.println("Playlist "+playlist.getName()+" is revised with "+
             playlist.getSongsList());
         }
    }
    
}
