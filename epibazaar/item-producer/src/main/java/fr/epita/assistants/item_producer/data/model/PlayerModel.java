package fr.epita.assistants.item_producer.data.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "player")
public class PlayerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    float collect_rate_multiplier;
    float move_speed_multiplier;
    int pos_x;
    int pos_y;
    float stamina_multiplier;
    Timestamp last_collect;
    Timestamp last_move;
}
