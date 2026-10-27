package EthanTowers.MusicApp.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;

import EthanTowers.MusicApp.repository.AlbumReviewRepository;
import EthanTowers.MusicApp.repository.SongReviewRepository;
import EthanTowers.MusicApp.repository.AlbumRepository;
import EthanTowers.MusicApp.repository.SongRepository;
import EthanTowers.MusicApp.repository.UserAccountRepository;
import EthanTowers.MusicApp.repository.AlbumRatingRepository;
import EthanTowers.MusicApp.repository.SongRatingRepository;
import EthanTowers.MusicApp.model.Album;
import EthanTowers.MusicApp.model.AlbumRating;
import EthanTowers.MusicApp.model.AlbumReview;
import EthanTowers.MusicApp.model.Song;
import EthanTowers.MusicApp.model.UserAccount;
import EthanTowers.MusicApp.DTO.AlbumReviewDTO;
import EthanTowers.MusicApp.model.SongRating;
import EthanTowers.MusicApp.model.SongReview;
import EthanTowers.MusicApp.DTO.SongReviewDTO;

@Service
@AllArgsConstructor 
public class ReviewService {

    private final AlbumReviewRepository albumReviewRepository;

    private final SongReviewRepository songReviewRepository;

    private final AlbumRepository albumRepository;

    private final SongRepository songRepository;

    private final UserAccountRepository userRepository;

    private final AlbumRatingRepository albumRatingRepository;

    private final SongRatingRepository songRatingRepository;


    private UserAccount requireUser(long userId) {
        return userRepository.findById(userId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found: " + userId));
    }

    private Song requireSong(long songId) {
        return songRepository.findById(songId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Song not found: " + songId));
    }

    private Album requireAlbum(long albumId) {
        return albumRepository.findById(albumId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Album not found: " + albumId));
    }

    public AlbumReview createAlbumReview(AlbumReviewDTO albumReviewDTO){
        UserAccount user = requireUser(albumReviewDTO.getUserId());
        Album album = requireAlbum(albumReviewDTO.getAlbumId());

        AlbumReview latestReview = albumReviewRepository.findTopByAlbum_IdAndUser_IdOrderByReviewNoDesc(
            albumReviewDTO.getAlbumId(),
            albumReviewDTO.getUserId()
        );
        long reviewNo = latestReview == null ? 1 : latestReview.getReviewNo() + 1;

        AlbumRating existingAlbumRating = albumRatingRepository.findByAlbum_IdAndUser_Id(
            albumReviewDTO.getAlbumId(),
            albumReviewDTO.getUserId()
        );

        if (existingAlbumRating != null) {
            existingAlbumRating.setRating(albumReviewDTO.getRating());
            albumRatingRepository.save(existingAlbumRating);
        } else {
            albumRatingRepository.save(AlbumRating.builder()
                .rating(albumReviewDTO.getRating())
                .user(user)
                .album(album)
                .build()
            );
        }

        return albumReviewRepository.save(AlbumReview.builder()
            .reviewNo(reviewNo)
            .user(user)
            .album(album)
            .comment(albumReviewDTO.getComment())
            .rating(albumReviewDTO.getRating())
            .build()
        );

    }

    public SongReview createSongReview(SongReviewDTO songReviewDTO){
        UserAccount user = requireUser(songReviewDTO.getUserId());
        Song song = requireSong(songReviewDTO.getSongId());

        SongReview latestReview = songReviewRepository.findTopBySong_IdAndUser_IdOrderByReviewNoDesc(
            songReviewDTO.getSongId(),
            songReviewDTO.getUserId()
        );
        long reviewNo = latestReview == null ? 1 : latestReview.getReviewNo() + 1;

        SongRating existingSongRating = songRatingRepository.findBySong_IdAndUser_Id(
            songReviewDTO.getSongId(),
            songReviewDTO.getUserId()
        );

        if (existingSongRating != null) {
            existingSongRating.setRating(songReviewDTO.getRating());
            songRatingRepository.save(existingSongRating);
        } else {
            songRatingRepository.save(SongRating.builder()
                .rating(songReviewDTO.getRating())
                .user(user)
                .song(song)
                .build()
            );
        }

        return songReviewRepository.save(SongReview.builder()
            .reviewNo(reviewNo)
            .rating(songReviewDTO.getRating())
            .comment(songReviewDTO.getComment())
            .song(song)
            .user(user)
            .build()
        );
    }

    public SongReview getSongReview(long userId, long songId, long reviewNo){
        return songReviewRepository.findBySong_IdAndUser_IdAndReviewNo(songId, userId, reviewNo);
    }

    public List<SongReview> getSongReviews(long userId, long songId){
        return songReviewRepository.findAllBySong_IdAndUser_Id(songId, userId);
    }

    public AlbumReview getAlbumReview(long userId, long albumId, long reviewNo){
        return albumReviewRepository.findByAlbum_IdAndUser_IdAndReviewNo(albumId, userId, reviewNo);
    }

    public List<AlbumReview> getAlbumReviews(long userId, long albumId){
        return albumReviewRepository.findAllByAlbum_IdAndUser_Id(albumId, userId);
    }
    
}
