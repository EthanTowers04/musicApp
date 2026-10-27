package EthanTowers.MusicApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import EthanTowers.MusicApp.model.SongRating;
import EthanTowers.MusicApp.model.composite.SongRatingId;

@Repository 
public interface SongRatingRepository extends CrudRepository<SongRating, SongRatingId> {
    public SongRating findBySong_IdAndUser_Id(Long songId, Long userId);
}
