package EthanTowers.MusicApp.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EthanTowers.MusicApp.DTO.AlbumRequestDTO;
import EthanTowers.MusicApp.DTO.SongCreateDTO;
import EthanTowers.MusicApp.model.Song;
import EthanTowers.MusicApp.repository.SongRepository;
import EthanTowers.MusicApp.service.AlbumService;
import EthanTowers.MusicApp.service.SongService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor 
@RequestMapping ("/api/albums")
public class AlbumController {
    private final AlbumService albumService;
    private final SongService songService;
    private final SongRepository songRepository;

    @GetMapping("/{id}")
    public AlbumRequestDTO getAlbumById(@PathVariable Long id){
        return this.albumService.getAlbumById(id);
    }

    @GetMapping("/")
    public List<AlbumRequestDTO> getAllAlbums(){
        return this.albumService.getAllAlbums();
    }

    @PostMapping ("/fromSongs")
    public AlbumRequestDTO createAlbumFromSongs(
            @RequestParam List<Long> songIds,
            @RequestParam String title,
            @RequestParam Long artistId,
            @RequestParam(required = false) URL cover){
        List<Song> songs = new ArrayList<>();
        for(Long id : songIds){
            songs.add(this.songRepository.findSongById(id));
        }
        return this.albumService.createAlbum(songs, title, artistId, cover);
    }

    @PostMapping ("/withSongs")
    public AlbumRequestDTO createAlbumWithSongs (@RequestParam List<SongCreateDTO> songDTOs, String title, Long artistId, URL cover){
        List<Song> songs = new ArrayList<>();
        for(SongCreateDTO dto : songDTOs){
            songs.add(this.songService.createSong(dto));
        }
        return this.albumService.createAlbum(songs, title, artistId, cover);
    }
    
}
