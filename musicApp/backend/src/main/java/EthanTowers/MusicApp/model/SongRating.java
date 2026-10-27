package EthanTowers.MusicApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import EthanTowers.MusicApp.model.composite.SongRatingId;

@IdClass(SongRatingId.class)
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "song_rating")
public class SongRating {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserAccount user;

    @Id
    @ManyToOne
    @JoinColumn(name = "song_id", referencedColumnName = "id")
    private Song song;

    private long rating;
}
