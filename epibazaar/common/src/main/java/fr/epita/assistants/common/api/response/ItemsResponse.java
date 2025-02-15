package fr.epita.assistants.common.api.response;

import fr.epita.assistants.common.aggregate.ItemAggregate;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class ItemsResponse {
    @Getter
    @AllArgsConstructor
    public static class ItemData {
        int id;
        float quantity;
        ItemAggregate.ResourceType type;
    }
    public List<ItemData> itemsResponse;

    public ItemsResponse(List<ItemData> itemsResponse) {
        this.itemsResponse = itemsResponse;
    }
}
