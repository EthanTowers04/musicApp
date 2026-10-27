package EthanTowers.MusicApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import EthanTowers.MusicApp.DTO.AlbumRatingDTO;
import EthanTowers.MusicApp.DTO.SongRatingDTO;
import EthanTowers.MusicApp.model.AlbumRating;
import EthanTowers.MusicApp.model.SongRating;
import EthanTowers.MusicApp.service.RatingService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    private final RatingService ratingService;

    @GetMapping("/song")
    public SongRating getSongRating(@RequestParam long userId, @RequestParam long songId) {
        return this.ratingService.getSongRating(userId, songId);
    }

    @GetMapping("/album")
    public AlbumRating getAlbumRating(@RequestParam long userId, @RequestParam long albumId) {
        return this.ratingService.getAlbumRating(userId, albumId);
    }

    @PutMapping("/song")
    public SongRating putSongRating(@RequestBody SongRatingDTO songRatingDTO) {
        return this.ratingService.createSongRating(songRatingDTO);
    }

    @PutMapping("/album")
    public AlbumRating putAlbumRating(@RequestBody AlbumRatingDTO albumRatingDTO) {
        return this.ratingService.createAlbumRating(albumRatingDTO);
    }
}
