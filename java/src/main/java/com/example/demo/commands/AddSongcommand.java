package com.example.demo.commands;

import java.util.List;
import com.example.demo.service.ISongService;

public class AddSongcommand implements ICommand{
    
    private ISongService songService;
    

    public AddSongcommand(ISongService songService) {
        this.songService = songService;
    }

    @Override
    public void execute(List<String> tokens) {
        try{
          songService.saveSong(tokens);

        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
   
    }

    
}
