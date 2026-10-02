package EthanTowers.MusicApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import EthanTowers.MusicApp.DTO.GenreDTO;
import EthanTowers.MusicApp.model.Genre;
import EthanTowers.MusicApp.repository.GenreRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor 
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreDTO getGenreById(Long id){
        Genre genre = this.genreRepository.findGenreById(id);
        return GenreDTO.builder()
                .name(genre.getName())
                .description(genre.getDescription())
                .build();
    }

    public List<GenreDTO> getAllGenres(){
        return this.genreRepository.findAll().stream()
            .map(genre -> GenreDTO.builder()
                .name(genre.getName())
                .description(genre.getDescription())
                .build())
            .toList();
    }
}
