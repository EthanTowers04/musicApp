package EthanTowers.MusicApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import EthanTowers.MusicApp.service.ReviewService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import EthanTowers.MusicApp.model.SongReview;
import EthanTowers.MusicApp.model.AlbumReview;
import EthanTowers.MusicApp.DTO.AlbumReviewDTO;
import EthanTowers.MusicApp.DTO.SongReviewDTO;

import lombok.AllArgsConstructor;

@RestController 
@AllArgsConstructor 
@RequestMapping("/api/reviews")
public class ReviewController {

    private ReviewService reviewService;


    @GetMapping ("/song")
    public SongReview getSongReview(@RequestParam long userId, @RequestParam long songId, @RequestParam long reviewNo){
        return reviewService.getSongReview(userId, songId, reviewNo);
    }

    @GetMapping("/songs")
    public List<SongReview> getSongReviews(@RequestParam long userId, @RequestParam long songId){
        return reviewService.getSongReviews(userId, songId);
    }

    @PostMapping ("/song")
    public SongReview createSongReview(@RequestBody SongReviewDTO songReviewDTO){
        return reviewService.createSongReview(songReviewDTO);
    }

    @GetMapping("/album")
    public AlbumReview getAlbumReview(@RequestParam long userId, @RequestParam long albumId, @RequestParam long reviewNo){
        return reviewService.getAlbumReview(userId, albumId, reviewNo);
    }

    @GetMapping("/albums")
    public List<AlbumReview> getAlbumReviews(@RequestParam long userId, @RequestParam long albumId){
        return reviewService.getAlbumReviews(userId, albumId);
    }

    @PostMapping("/album")
    public AlbumReview createAlbumReview(@RequestBody AlbumReviewDTO albumReviewDTO){
        return reviewService.createAlbumReview(albumReviewDTO);
    }

    
}
