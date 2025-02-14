package fr.epita.assistants.common.api.response;

import fr.epita.assistants.common.aggregate.ItemAggregate;

import java.util.List;

public class StartResponse {
    public List<List<ItemAggregate.ResourceType>> map;

    public StartResponse(List<List<ItemAggregate.ResourceType>> map) {
        this.map = map;
    }
}
