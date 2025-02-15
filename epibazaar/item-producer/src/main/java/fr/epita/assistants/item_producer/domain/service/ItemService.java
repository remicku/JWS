package fr.epita.assistants.item_producer.domain.service;

import fr.epita.assistants.common.api.response.ItemsResponse;
import fr.epita.assistants.item_producer.data.model.ItemModel;
import fr.epita.assistants.item_producer.data.repository.ItemRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ItemService {
    @Inject
    ItemRepository itemRepository;

    public List<ItemModel> getItemResources() {
        return  itemRepository.findAll().list();
    }
}
