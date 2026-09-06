package EthanTowers.MusicApp.DTO;

import java.net.URL;
import java.util.List;

import lombok.Builder;

@Builder
public class SongRequestDTO {

    private Long id;

    private ArtistDTO artist;

    private List<GenreDTO> genres;

    private int runtime;

    private URL cover;

}
