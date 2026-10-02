package EthanTowers.MusicApp.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@Builder 
public class ArtistRequestDTO {
    private String name;
    private String bio;

}
