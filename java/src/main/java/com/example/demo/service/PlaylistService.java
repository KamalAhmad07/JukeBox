package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.demo.constants.SongStatus;
import com.example.demo.entity.Playlist;
import com.example.demo.entity.Song;
import com.example.demo.repository.IPlaylistRepo;

public class PlaylistService  implements IPlaylistService{

    private IPlaylistRepo playlistRepo;
    private ISongService songService;
    private Playlist currentPlaylist;
     Song currentPlayingSong;

    public PlaylistService(IPlaylistRepo playlistRepo,ISongService songService){
         this.playlistRepo = playlistRepo;  
         this.songService = songService;  
    }

    @Override
    public Playlist createPlaylist(List<String> tokens) {   
      List<Song>  songList = new ArrayList<>();

        for(int  i=2; i<tokens.size(); i++){           
               Song song = songService.getSongById( Integer.parseInt(tokens.get(i)));
               songList.add(song);               
        } 
         
          Playlist playlist = new Playlist(tokens.get(1),songList);
          playlist =  playlistRepo.createPlaylist(playlist);
        return playlist;  
        
    }

    @Override
    public Playlist getPlayListByName(String playlistName) {
        return playlistRepo.getPlayListByName(playlistName);
    }

    @Override
    public List<Playlist> getAllPlaylist() {
        return playlistRepo.getAllPlaylist();
    }

    @Override
    public boolean removePlaylist(List<String> tokens) {
       String playlistName = tokens.get(1);
       boolean b = playlistRepo.removePlaylist(playlistName);
       return b;
    }

    @Override
    public Playlist addSongToPlaylist(List<String> tokens) {
      Playlist playlist = playlistRepo.getPlayListByName(tokens.get(1));
       Song song = songService.getSongById(Integer.parseInt(tokens.get(2)));
      
      if(playlist != null){
          playlist.getSongsList().add(song);
          return playlist;
      }
       return null;
    }

    @Override
    public Playlist removeSongFromPlaylist(List<String> tokens) {
        Playlist playlist = playlistRepo.getPlayListByName(tokens.get(1));
        if(playlist != null){
           Song song = songService.getSongById(Integer.parseInt(tokens.get(2)));
           if(song != null){
              playlist.getSongsList().remove(song);
              return playlist;
           }
        }
       return null; 
    }

    @Override
    public Song playSong() {       
        if(currentPlaylist != null){
           List<Song> songs =  currentPlaylist.getSongsList();
          Optional<Song> song = songs.stream().filter(s->s.getSongStatus() == SongStatus.PLAY).findFirst();
           
           if(!song.isEmpty()){
            currentPlayingSong = song.get();
              song.get().setSongStatus(SongStatus.PAUSE);
              System.out.println(song.get()+" is paused!");
              return null;
           }else{
              Song song1 = songs.get(0);
              song1.setSongStatus(SongStatus.PLAY);
              currentPlayingSong = song1;
              return song1;
           }
        }
       return null; 
    }

    @Override
    public Song stopSong() {
         if(currentPlayingSong != null){
              Song song = currentPlayingSong;
              currentPlayingSong.setSongStatus(SongStatus.PAUSE);
              currentPlayingSong = null;
              return song;
         }
       return null; 
    }

    @Override
    public Song playNext() {
       if(currentPlaylist != null){
           List<Song> songs = currentPlaylist.getSongsList();
           for(int i=0;i<songs.size(); i++){
            Song song  = songs.get(i);
             if((song.getSongStatus() == SongStatus.PLAY) &&   (i != songs.size()-1) ){
                 song.setSongStatus(SongStatus.PAUSE);
                 song =  songs.get(++i);
                 song.setSongStatus(SongStatus.PLAY);
                 return  song;
             }else if((song.getSongStatus() == SongStatus.PLAY) &&   (i == songs.size()-1)){
                song.setSongStatus(SongStatus.PAUSE);
                song =  songs.get(0);
                song.setSongStatus(SongStatus.PLAY);
                 return song;
             }
           }
       }
       return null;
        
    }

    @Override
    public Song playPrevious() {
        if(currentPlaylist != null){
            List<Song> songs = currentPlaylist.getSongsList();
            for(int i=0;i<songs.size(); i++){
             Song song  = songs.get(i);
              if((song.getSongStatus() == SongStatus.PLAY) &&   (i == 0) ){
                
                song.setSongStatus(SongStatus.PAUSE);
                  song =  songs.get(songs.size()-1);
                  song.setSongStatus(SongStatus.PLAY);
                  return  song;

              }else if((song.getSongStatus() == SongStatus.PLAY) &&   (i != 0)){
                 song.setSongStatus(SongStatus.PAUSE);
                 song =  songs.get(--i);
                 song.setSongStatus(SongStatus.PLAY);
                  return song;
              }
            }
        }
        return null;
         
    }

    @Override
    public boolean loadPlaylist(List<String> tokens) {
        String name = tokens.get(1);
         Playlist playlist = playlistRepo.getPlayListByName(name);
         if(playlist != null){
            currentPlaylist = playlist;
            // System.err.println(" current playlist ============ ++++++++++++"+currentPlaylist );
            return true;            
         }
        return false;
    }
    
}
