package EthanTowers.MusicApp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import EthanTowers.MusicApp.model.AlbumReview;
import EthanTowers.MusicApp.model.composite.AlbumReviewId;

@Repository
public interface AlbumReviewRepository extends CrudRepository<AlbumReview, AlbumReviewId> {
    public AlbumReview findByAlbum_IdAndUser_IdAndReviewNo(long albumId, long userId, long reviewNo);
    public List<AlbumReview> findAllByAlbum_IdAndUser_Id(long albumId, long userId);
    public AlbumReview findTopByAlbum_IdAndUser_IdOrderByReviewNoDesc(long albumId, long userId);
}
