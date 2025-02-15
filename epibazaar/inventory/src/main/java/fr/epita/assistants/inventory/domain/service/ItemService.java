package fr.epita.assistants.inventory.domain.service;

import fr.epita.assistants.common.aggregate.ResetInventoryAggregate;
import fr.epita.assistants.inventory.data.repository.ItemRepository;
import fr.epita.assistants.inventory.domain.entity.ItemEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ItemService {

    @Inject
    ItemRepository itemRepository;

    public ResetInventoryAggregate resetInventory() {
        List<ItemEntity> itemsToDelete = itemRepository.findAll().list();

        ResetInventoryAggregate aggregate = new ResetInventoryAggregate(
                itemsToDelete.stream()
                        .map(ItemEntity::toAggregate)
                        .collect(Collectors.toList())
        );

        itemRepository.deleteAll();

        return aggregate;
    }
}