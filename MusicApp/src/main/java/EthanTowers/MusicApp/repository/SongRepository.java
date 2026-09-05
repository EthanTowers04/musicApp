package EthanTowers.MusicApp.repository;

import org.springframework.data.repository.CrudRepository;

import EthanTowers.MusicApp.model.Song;

public interface SongRepository extends CrudRepository<Song, Long>{

    public Song findSongById(Long Id);

}
