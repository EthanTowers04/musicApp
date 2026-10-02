package EthanTowers.MusicApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import EthanTowers.MusicApp.model.Song;
import EthanTowers.MusicApp.service.SongService;
import EthanTowers.MusicApp.DTO.SongCreateDTO;
import EthanTowers.MusicApp.DTO.SongRequestDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService songService;


    @GetMapping("/{id}")
    public SongRequestDTO getSongById(@PathVariable Long id){
        return this.songService.getSongById(id);
    }

    @GetMapping("/")
    public List<SongRequestDTO> getAllSongs(){
        return this.songService.getAllSongs();
    }

    @PostMapping("/")
    public Song addSong(@RequestBody SongCreateDTO song){
        return this.songService.createSong(song);
    }
}
