package EthanTowers.MusicApp.service;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import EthanTowers.MusicApp.repository.AlbumRatingRepository;
import EthanTowers.MusicApp.repository.SongRatingRepository;
import EthanTowers.MusicApp.DTO.SongRatingDTO;
import EthanTowers.MusicApp.DTO.AlbumRatingDTO;
import EthanTowers.MusicApp.model.SongRating;
import EthanTowers.MusicApp.model.AlbumRating;
import EthanTowers.MusicApp.repository.UserAccountRepository;
import EthanTowers.MusicApp.repository.SongRepository;
import EthanTowers.MusicApp.repository.AlbumRepository;


@Service
@AllArgsConstructor 
public class RatingService {

    private final AlbumRatingRepository albumRatingRepository;

    private final SongRatingRepository songRatingRepository;

    private final UserAccountRepository userRepository;

    private final SongRepository songRepository;

    private final AlbumRepository albumRepository;
    
    public SongRating createSongRating (SongRatingDTO songRatingDTO){

        return songRatingRepository.save(SongRating.builder()
            .rating(songRatingDTO.getRating())
            .song(songRepository.findById(songRatingDTO.getSongId()).orElse(null))
            .user(userRepository.findById(songRatingDTO.getUserId()).orElse(null))
            .build());
    }

    public AlbumRating createAlbumRating (AlbumRatingDTO albumRatingDTO){

        return albumRatingRepository.save(AlbumRating.builder()
            .rating(albumRatingDTO.getRating())
            .album(albumRepository.findById(albumRatingDTO.getAlbumId()).orElse(null))
            .user(userRepository.findById(albumRatingDTO.getUserId()).orElse(null))
            .build());
    }

    public SongRating getSongRating(long user_id, long song_id){
        return songRatingRepository.findBySong_IdAndUser_Id(song_id, user_id);
    }

    public AlbumRating getAlbumRating(long user_id, long album_id){
        return albumRatingRepository.findByAlbum_IdAndUser_Id(album_id, user_id);
    }
}
