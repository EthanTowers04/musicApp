package EthanTowers.MusicApp.DTO;

import java.net.URL;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter 
@Setter 
public class AlbumRequestDTO {

    private String title;

    private long artistId;

    private URL cover;

    private List<SongRequestDTO> songs;
}
