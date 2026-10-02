package EthanTowers.MusicApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EthanTowers.MusicApp.DTO.ArtistRequestDTO;
import EthanTowers.MusicApp.service.ArtistService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping("/{id}")
    public ArtistRequestDTO getArtistById(@PathVariable Long id){
        return this.artistService.getArtistById(id);
    }

    @GetMapping("/")
    public List<ArtistRequestDTO> getAllArtists(){
        return this.artistService.getAllArtists();
    }
    
}
