package EthanTowers.MusicApp.service;

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

}
