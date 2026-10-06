package EthanTowers.MusicApp.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import EthanTowers.MusicApp.DTO.AlbumRequestDTO;
import EthanTowers.MusicApp.DTO.ArtistDTO;
import EthanTowers.MusicApp.DTO.GenreDTO;
import EthanTowers.MusicApp.DTO.SongCreateDTO;
import EthanTowers.MusicApp.DTO.SongRequestDTO;
import EthanTowers.MusicApp.model.Album;
import EthanTowers.MusicApp.model.Song;
import EthanTowers.MusicApp.repository.AlbumRepository;
import EthanTowers.MusicApp.repository.ArtistRepository;
import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public AlbumRequestDTO getAlbumById(Long id){
        Album album = this.albumRepository.findAlbumById(id);
        return AlbumRequestDTO.builder()
                .title(album.getTitle())
                .artistId(album.getArtist().getId())
                .cover(album.getCover())
                .songs(toSongDtos(album.getSongs()))
                .build();
    }

    public List<AlbumRequestDTO> getAllAlbums(){
        return this.albumRepository.findAll().stream()
            .map(album -> AlbumRequestDTO.builder()
                .title(album.getTitle())
                .artistId(album.getArtist().getId())
                .cover(album.getCover())
                .songs(toSongDtos(album.getSongs()))
                .build())
            .toList();
    }

    public AlbumRequestDTO createAlbum(List <Song> songs, String title, Long artistId, URL cover){
        Album album = Album.builder()
            .title(title)
            .artist(this.artistRepository.findArtistById(artistId))
            .cover(cover)
            .songs(songs)
            .build();
        this.albumRepository.save(album);
        return AlbumRequestDTO.builder()
            .title(album.getTitle())
            .artistId(album.getArtist().getId())
            .cover(album.getCover())
            .songs(toSongDtos(album.getSongs()))
            .build();
    }

    private List<SongRequestDTO> toSongDtos(List<Song> songs){
        if (songs == null) {
            return List.of();
        }
        return songs.stream()
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
                    .toList())
                .runtime(song.getRuntime())
                .cover(song.getCover())
                .build())
            .toList();
    }

}
