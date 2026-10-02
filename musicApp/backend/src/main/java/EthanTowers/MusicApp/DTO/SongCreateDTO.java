package EthanTowers.MusicApp.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.net.URL;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder 
@Getter
@AllArgsConstructor
@NoArgsConstructor 
public class SongCreateDTO {
    private String title;
    private long artistId;
    private URL cover;
    private List<Long> genreIds;
    private int runtime;
}