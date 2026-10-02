package EthanTowers.MusicApp.repository;

import org.springframework.stereotype.Repository;
import EthanTowers.MusicApp.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository 
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findArtistById(Long id);

}
