package fr.epita.assistants.item_producer.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    float quantity;
    String type;
}
