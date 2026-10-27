package EthanTowers.MusicApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import EthanTowers.MusicApp.model.AlbumRating;
import EthanTowers.MusicApp.model.composite.AlbumRatingId;

@Repository 
public interface AlbumRatingRepository extends CrudRepository<AlbumRating, AlbumRatingId> {
    public AlbumRating findByAlbum_IdAndUser_Id(Long albumId, Long userId);
}