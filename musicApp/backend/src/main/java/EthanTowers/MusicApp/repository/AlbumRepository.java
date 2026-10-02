package EthanTowers.MusicApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EthanTowers.MusicApp.model.Album;

@Repository 
public interface AlbumRepository extends JpaRepository<Album, Long> {
    Album findAlbumById(Long id);
    
}
