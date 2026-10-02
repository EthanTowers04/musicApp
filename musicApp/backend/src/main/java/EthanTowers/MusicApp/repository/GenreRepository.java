package EthanTowers.MusicApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EthanTowers.MusicApp.model.Genre;

@Repository 
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findGenreById(Long id);
    
}
