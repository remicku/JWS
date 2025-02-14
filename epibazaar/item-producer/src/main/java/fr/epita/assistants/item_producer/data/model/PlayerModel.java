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

    int pos_x;
    int pos_y;
    float collect_rate_multiplier;
    float move_speed_multiplier;
    float stamina_multiplier;
    LocalDateTime last_collect;
    LocalDateTime last_move;

    public PlayerModel(int x, int y, float collect_rate_multiplier, float move_speed_multiplier,
                       float stamina_multiplier, LocalDateTime last_collect,
                       LocalDateTime last_move) {
        this.pos_x = x;
        this.pos_y = y;
        this.collect_rate_multiplier = collect_rate_multiplier;
        this.move_speed_multiplier = move_speed_multiplier;
        this.stamina_multiplier = stamina_multiplier;
        this. last_collect = last_collect;
        this.last_move = last_move;
    }
}
