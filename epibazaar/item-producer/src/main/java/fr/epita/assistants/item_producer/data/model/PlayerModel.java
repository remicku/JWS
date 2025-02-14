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

    int posX;
    int posY;
    float collectRateMultiplier;
    float moveSpeedMultiplier;
    float staminaMultiplier;
    LocalDateTime lastCollect;
    LocalDateTime lastMove;

    public PlayerModel(int x, int y, float collectRateMultiplier, float moveSpeedMultiplier,
                       float staminaMultiplier, LocalDateTime lastCollect,
                       LocalDateTime lastMove) {
        this.posX = x;
        this.posY = y;
        this.collectRateMultiplier = collectRateMultiplier;
        this.moveSpeedMultiplier = moveSpeedMultiplier;
        this.staminaMultiplier = staminaMultiplier;
        this. lastCollect = lastCollect;
        this.lastMove = lastMove;
    }
}
