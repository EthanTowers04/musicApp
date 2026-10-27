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
import EthanTowers.MusicApp.model.composite.AlbumRatingId;

@IdClass(AlbumRatingId.class)
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "album_rating")
public class AlbumRating {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount user;

    @Id
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    private long rating;
}


