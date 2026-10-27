package EthanTowers.MusicApp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import EthanTowers.MusicApp.model.SongReview;
import EthanTowers.MusicApp.model.composite.SongReviewId;

@Repository
public interface SongReviewRepository extends CrudRepository<SongReview, SongReviewId> {
    public SongReview findBySong_IdAndUser_IdAndReviewNo(long songId, long userId, long reviewNo);
    public List<SongReview> findAllBySong_IdAndUser_Id(long songId, long userId);
    public SongReview findTopBySong_IdAndUser_IdOrderByReviewNoDesc(long songId, long userId);
}
