package EthanTowers.MusicApp.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder 
@Getter 
public class AlbumRatingDTO{
    private long rating;
    private long albumId;
    private long userId;
}