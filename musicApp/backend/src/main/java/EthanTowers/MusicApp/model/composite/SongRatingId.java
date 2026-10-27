package EthanTowers.MusicApp.model.composite;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode 
@NoArgsConstructor 
@AllArgsConstructor 
public class SongRatingId implements Serializable {
    private long song;
    private long user;
}
