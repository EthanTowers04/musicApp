package EthanTowers.MusicApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongReviewDTO {
    private long songId;
    private long userId;
    private String comment;
    private long rating;
}
