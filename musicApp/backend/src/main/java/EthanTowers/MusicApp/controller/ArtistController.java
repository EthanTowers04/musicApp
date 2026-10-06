package EthanTowers.MusicApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EthanTowers.MusicApp.DTO.ArtistDTO;
import EthanTowers.MusicApp.service.ArtistService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping("/{id}")
    public ArtistDTO getArtistById(@PathVariable Long id){
        return this.artistService.getArtistById(id);
    }

    @GetMapping("/")
    public List<ArtistDTO> getAllArtists(){
        return this.artistService.getAllArtists();
    }
    
    @PostMapping("")
    public ArtistDTO createArtist(@RequestBody ArtistDTO params){
        return this.artistService.createArtist(params);
    }
}
