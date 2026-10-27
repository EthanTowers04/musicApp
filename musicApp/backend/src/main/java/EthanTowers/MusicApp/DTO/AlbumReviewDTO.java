package EthanTowers.MusicApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumReviewDTO {
    private long albumId;
    private long userId;
    private String comment;
    private long rating;
}
