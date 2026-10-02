package EthanTowers.MusicApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EthanTowers.MusicApp.DTO.AlbumRequestDTO;
import EthanTowers.MusicApp.service.AlbumService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor 
@RequestMapping ("/api/albums")
public class AlbumController {
    private final AlbumService albumService;

    @GetMapping("/{id}")
    public AlbumRequestDTO getAlbumById(@PathVariable Long id){
        return this.albumService.getAlbumById(id);
    }

    @GetMapping("/")
    public List<AlbumRequestDTO> getAllAlbums(){
        return this.albumService.getAllAlbums();
    }
    
}
