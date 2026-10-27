package EthanTowers.MusicApp.model.composite;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AlbumRatingId implements Serializable {
    private long user;
    private long album;
}