package EthanTowers.MusicApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import EthanTowers.MusicApp.model.Song;

@Repository 
public interface SongRepository extends CrudRepository<Song, Long>{

    public Song findSongById(Long Id);

}
