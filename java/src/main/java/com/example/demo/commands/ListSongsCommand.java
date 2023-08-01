package com.example.demo.commands;

import java.util.List;
import com.example.demo.entity.Song;
import com.example.demo.service.ISongService;

public class ListSongsCommand  implements ICommand{

    private ISongService songService;
    
    public ListSongsCommand(ISongService songService) {
        this.songService = songService;
    }

    @Override
    public void execute(List<String> tokens) {
        List<Song> allSongs =  songService.getAllSong();
        System.out.println(allSongs);
    }
    
}
