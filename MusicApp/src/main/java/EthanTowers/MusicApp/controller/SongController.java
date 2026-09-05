package EthanTowers.MusicApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import EthanTowers.MusicApp.service.SongService;
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
}
