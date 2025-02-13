package fr.epita.assistants.item_producer.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "game")
public class GameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String map;
}
