package EthanTowers.MusicApp.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import EthanTowers.MusicApp.DTO.ArtistDTO;
import EthanTowers.MusicApp.DTO.GenreDTO;
import EthanTowers.MusicApp.DTO.SongRequestDTO;
import EthanTowers.MusicApp.DTO.SongCreateDTO;
import EthanTowers.MusicApp.model.Genre;
import EthanTowers.MusicApp.model.Song;
import EthanTowers.MusicApp.model.Artist;
import EthanTowers.MusicApp.repository.ArtistRepository;
import EthanTowers.MusicApp.repository.GenreRepository;
import EthanTowers.MusicApp.repository.SongRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final GenreRepository genreRepository;

    public SongRequestDTO getSongById(Long id){
        Song songEntity = this.songRepository.findSongById(id);
        Artist artist = songEntity.getArtist();
        ArtistDTO artistDTO = ArtistDTO.builder()
            .name(artist.getName())
            .bio(artist.getBio())
            .build();

        return SongRequestDTO.builder()
        .title(songEntity.getTitle())
        .artist(artistDTO)
        .genres(songEntity.getGenres().stream()
            .map(genre -> GenreDTO.builder()
                .name(genre.getName())
                .description(genre.getDescription())
                .build())
            .collect(Collectors.toList()))
        .runtime(songEntity.getRuntime())
        .cover(songEntity.getCover())
        .build();

    }

    public List<SongRequestDTO> getAllSongs(){
        return StreamSupport
            .stream(this.songRepository.findAll().spliterator(), false)
            .map(song -> SongRequestDTO.builder()
                .title(song.getTitle())
                .artist(ArtistDTO.builder()
                    .name(song.getArtist().getName())
                    .bio(song.getArtist().getBio())
                    .build())
                .genres(song.getGenres().stream()
                    .map(genre -> GenreDTO.builder()
                        .name(genre.getName())
                        .description(genre.getDescription())
                        .build())
                    .collect(Collectors.toList()))
                .runtime(song.getRuntime())
                .cover(song.getCover())
                .build())
            .collect(Collectors.toList());
    }

    public Song createSong(SongCreateDTO songDTO){
        Song song = new Song();
        song.setTitle(songDTO.getTitle());
        song.setRuntime(songDTO.getRuntime());
        song.setCover(songDTO.getCover());
        song.setArtist(artistRepository.findArtistById(songDTO.getArtistId()));
        for (Long genreId : songDTO.getGenreIds()) {
            Genre genre = genreRepository.findGenreById(genreId);
            song.getGenres().add(genre);
        }

        return this.songRepository.save(song);
    }


}