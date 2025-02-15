package fr.epita.assistants.inventory.domain.entity;

import fr.epita.assistants.common.aggregate.ItemAggregate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemEntity {
    float quantity;
    ItemAggregate.ResourceType type;

    public ItemAggregate toAggregate() {
        return new ItemAggregate(type, quantity);
    }
}