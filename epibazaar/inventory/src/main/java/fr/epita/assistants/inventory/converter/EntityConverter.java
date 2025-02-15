package fr.epita.assistants.inventory.converter;

import fr.epita.assistants.inventory.data.model.ItemModel;
import fr.epita.assistants.inventory.domain.entity.ItemEntity;

import java.util.ArrayList;
import java.util.List;

public class EntityConverter {
    public static List<ItemEntity> toEntity(List<ItemModel> itemsList) {
        List<ItemEntity> res = new ArrayList<>();

        for (ItemModel i : itemsList) {
            res.add(new ItemEntity(i.getQuantity(), i.getType()));
        }

        return res;
    }
}
