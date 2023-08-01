package com.example.demo.configurations;

import com.example.demo.commands.AddSongToPlayListCommand;
import com.example.demo.commands.AddSongcommand;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.CreatePlaylistCommand;
import com.example.demo.commands.DeletePlaylistCommand;
import com.example.demo.commands.DeleteSongFromPlaylistCommand;
import com.example.demo.commands.ListSongsCommand;
import com.example.demo.commands.LoadPlaylistCommand;
import com.example.demo.commands.NextSongCommand;
import com.example.demo.commands.PlaySongCommand;
import com.example.demo.commands.PreviousSongCommand;
import com.example.demo.commands.StopSongCommand;
import com.example.demo.repository.IPlaylistRepo;
import com.example.demo.repository.ISongRepo;
import com.example.demo.repository.PlaylistRepoImpl;
import com.example.demo.repository.SongRepoImpl;
import com.example.demo.service.IPlaylistService;
import com.example.demo.service.ISongService;
import com.example.demo.service.PlaylistService;
import com.example.demo.service.SongServiceImpl;

public class Configuration {
    

      private ISongRepo songRepo = new SongRepoImpl();    
      private IPlaylistRepo playlistRepo  = new PlaylistRepoImpl();
       static Configuration conf;

      private ISongService songService = new SongServiceImpl(songRepo);
      private IPlaylistService playlistService = new PlaylistService(playlistRepo,songService);
      
      // Add Song Command
      private AddSongcommand addSongcommand = new AddSongcommand(songService);
      // get List Of All Song
      private ListSongsCommand listSongsCommand = new ListSongsCommand(songService);
      // create playlist 
      private CreatePlaylistCommand createPlaylistCommand = new CreatePlaylistCommand(playlistService);          

      // delete playlist
      private DeletePlaylistCommand deletePlaylistCommand = new DeletePlaylistCommand(playlistService);

      // add Song to PlayList
      private AddSongToPlayListCommand addSongToPlayListCommand = new AddSongToPlayListCommand(playlistService,songService);
      
      // deltee song From playlist
      private  DeleteSongFromPlaylistCommand deleteSongFromPlaylistCommand = new  DeleteSongFromPlaylistCommand(playlistService);

      // Load playlist
      private LoadPlaylistCommand loadPlaylistCommand = new LoadPlaylistCommand(playlistService);

      // playu next song
      private NextSongCommand nextSongCommand = new NextSongCommand(playlistService);
      // play previous sonng
      private PreviousSongCommand previousSongCommand = new PreviousSongCommand(playlistService);

      // playSong command
      private PlaySongCommand playSongCommand = new PlaySongCommand(playlistService);

      // stopSong Command
      private StopSongCommand stopSongCommand = new StopSongCommand(playlistService);
    
       
      public static Configuration getInstance(){
        if(conf == null){
          conf =  new Configuration();
          return conf;
        }
        return conf;
      }
     
      CommandRegistry commandRegistry = new CommandRegistry();
      public  CommandRegistry getCommandRegistry(){
        commandRegistry.registerCommand("ADD_SONG", addSongcommand);
        commandRegistry.registerCommand("LIST_SONGS", listSongsCommand);
        commandRegistry.registerCommand("CREATE_PLAYLIST",createPlaylistCommand);
        commandRegistry.registerCommand("LOAD_PLAYLIST", loadPlaylistCommand);
        commandRegistry.registerCommand("PLAY_SONG", playSongCommand);
        commandRegistry.registerCommand("NEXT_SONG", nextSongCommand);
        commandRegistry.registerCommand("PREVIOUS_SONG",previousSongCommand);
        commandRegistry.registerCommand("STOP_SONG", stopSongCommand);
        commandRegistry.registerCommand("DELETE_PLAYLIST", deletePlaylistCommand);
        commandRegistry.registerCommand("ADD_SONG_TO_PLAYLIST", addSongToPlayListCommand);
        commandRegistry.registerCommand("DELETE_SONG_FROM_PLAYLIST", deleteSongFromPlaylistCommand);
        return commandRegistry;
      }
    
}
