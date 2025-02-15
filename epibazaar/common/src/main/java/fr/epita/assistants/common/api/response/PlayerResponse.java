package fr.epita.assistants.common.api.response;

import fr.epita.assistants.common.aggregate.ItemAggregate;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class PlayerResponse {
    @Getter
    @AllArgsConstructor
    public static class PlayerData {
        int posX;
        int posY;
        LocalDateTime lastMove;
        LocalDateTime lastCollect;
        float moveSpeedMultiplier;
        float staminaMultiplier;
        float collectRateMultiplier;
    }
    public int  posX;
    public int posY;
    public LocalDateTime lastMove;
    public LocalDateTime lastCollect;
    public float moveSpeedMultiplier;
    public float staminaMultiplier;
    public float collectRateMultiplier;

    public PlayerResponse(PlayerData playerResponse) {
        this.posX = playerResponse.getPosX();
        this.posY = playerResponse.getPosY();
        this.lastMove = playerResponse.getLastMove();
        this.lastCollect = playerResponse.getLastCollect();
        this.moveSpeedMultiplier = playerResponse.getMoveSpeedMultiplier();
        this.staminaMultiplier = playerResponse.getStaminaMultiplier();
        this.collectRateMultiplier = playerResponse.getCollectRateMultiplier();
    }
}
