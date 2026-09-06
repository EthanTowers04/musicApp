package EthanTowers.MusicApp.service;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import EthanTowers.MusicApp.DTO.ArtistDTO;
import EthanTowers.MusicApp.DTO.GenreDTO;
import EthanTowers.MusicApp.DTO.SongRequestDTO;
import EthanTowers.MusicApp.model.Genre;
import EthanTowers.MusicApp.model.Song;
import EthanTowers.MusicApp.model.Artist;
import EthanTowers.MusicApp.repository.SongRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    public SongRequestDTO getSongById(Long id){
        Song songEntity = this.songRepository.findSongById(id);
        Artist artist = songEntity.getArtist();
        ArtistDTO artistDTO = ArtistDTO.builder()
            .name(artist.getName())
            .bio(artist.getBio())
            .build();

        return SongRequestDTO.builder()
        .artist(artistDTO)
        .genres(songEntity.getGenres().stream()
            .map(genre -> GenreDTO.builder()
                .name(genre.getName())
                .build())
            .collect(Collectors.toList()))
        .runtime(songEntity.getRuntime())
        .cover(songEntity.getCover())
        .build();

    }
}