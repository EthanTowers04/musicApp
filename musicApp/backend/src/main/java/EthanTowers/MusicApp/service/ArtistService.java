package EthanTowers.MusicApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import EthanTowers.MusicApp.DTO.ArtistDTO;
import EthanTowers.MusicApp.model.Artist;
import EthanTowers.MusicApp.repository.ArtistRepository;
import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class ArtistService {
    
    private final ArtistRepository artistRepository;

    public ArtistDTO getArtistById(Long id){
        Artist artist = this.artistRepository.findArtistById(id);
        return ArtistDTO.builder()
                .name(artist.getName())
                .bio(artist.getBio())
                .build();
    }

    public List<ArtistDTO> getAllArtists(){
        return this.artistRepository.findAll().stream()
            .map(artist -> ArtistDTO.builder()
                .name(artist.getName())
                .bio(artist.getBio())
                .build())
            .toList();
    }

    public ArtistDTO createArtist(ArtistDTO params){
        Artist artist = Artist.builder()
            .name(params.getName())
            .bio(params.getBio())
            .build();
        this.artistRepository.save(artist);
        return ArtistDTO.builder()
            .name(artist.getName())
            .bio(artist.getBio())
            .build();
    }

}
