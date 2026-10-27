package EthanTowers.MusicApp.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder 
@Getter 
public class SongRatingDTO {
    private long rating;
    private long songId;
    private long userId;
}
