package EthanTowers.MusicApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EthanTowers.MusicApp.DTO.GenreDTO;
import EthanTowers.MusicApp.service.GenreService;
import lombok.AllArgsConstructor;

@RestController 
@AllArgsConstructor
@RequestMapping ("/api/genres")
public class GenreController {
    private final GenreService genreService;

    @GetMapping ("/{id}")
    public GenreDTO getGenreById(@PathVariable Long id){
        return this.genreService.getGenreById(id);
    }
    
    @GetMapping("/")
    public List<GenreDTO> getAllGenres(){
        return this.genreService.getAllGenres();
    }
}
