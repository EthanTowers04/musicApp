package EthanTowers.MusicApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import EthanTowers.MusicApp.DTO.ArtistRequestDTO;
import EthanTowers.MusicApp.model.Artist;
import EthanTowers.MusicApp.repository.ArtistRepository;
import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class ArtistService {
    
    private final ArtistRepository artistRepository;

    public ArtistRequestDTO getArtistById(Long id){
        Artist artist = this.artistRepository.findArtistById(id);
        return ArtistRequestDTO.builder()
                .name(artist.getName())
                .bio(artist.getBio())
                .build();
    }

    public List<ArtistRequestDTO> getAllArtists(){
        return this.artistRepository.findAll().stream()
            .map(artist -> ArtistRequestDTO.builder()
                .name(artist.getName())
                .bio(artist.getBio())
                .build())
            .toList();
    }

}
