package fr.epita.assistants.common.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class PlayerResponse {
    @Getter
    @AllArgsConstructor
    public static class PlayerData {
        Integer posX;
        Integer posY;
        LocalDateTime lastMove;
        LocalDateTime lastCollect;
        Float moveSpeedMultiplier;
        Float staminaMultiplier;
        Float collectRateMultiplier;
    }

    public Integer  posX;
    public Integer posY;
    public LocalDateTime lastMove;
    public LocalDateTime lastCollect;
    public Float moveSpeedMultiplier;
    public Float staminaMultiplier;
    public Float collectRateMultiplier;

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
