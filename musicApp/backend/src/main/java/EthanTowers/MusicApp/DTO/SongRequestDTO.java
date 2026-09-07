package EthanTowers.MusicApp.DTO;

import java.net.URL;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SongRequestDTO {

    private Long id;

    private ArtistDTO artist;

    private List<GenreDTO> genres;

    private int runtime;

    private URL cover;

}
