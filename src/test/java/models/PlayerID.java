package models;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlayerID {
    private Integer playerId;

    public PlayerID(Integer playerId) {
        this.playerId = playerId;
    }
}
