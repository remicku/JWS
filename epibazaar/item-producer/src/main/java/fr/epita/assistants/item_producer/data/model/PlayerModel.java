package fr.epita.assistants.item_producer.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "player")
@Getter
@Setter
@NoArgsConstructor
public class PlayerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    Integer posX;
    Integer posY;
    LocalDateTime lastMove;
    LocalDateTime lastCollect;
    Float moveSpeedMultiplier;
    Float staminaMultiplier;
    Float collectRateMultiplier;

    public PlayerModel(int x, int y, LocalDateTime lastMove,  LocalDateTime lastCollect, float moveSpeedMultiplier,
                       float staminaMultiplier, float collectRateMultiplier) {
        this.posX = x;
        this.posY = y;
        this.lastMove = lastMove;
        this.lastCollect = lastCollect;
        this.moveSpeedMultiplier = moveSpeedMultiplier;
        this.staminaMultiplier = staminaMultiplier;
        this.collectRateMultiplier = collectRateMultiplier;
    }
}
