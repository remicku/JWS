package fr.epita.assistants.inventory.data.model;

import fr.epita.assistants.common.aggregate.ItemAggregate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    Float quantity;

    @Enumerated(EnumType.STRING)
    ItemAggregate.ResourceType type;
}
