package fr.epita.assistants.inventory.data.repository;

import fr.epita.assistants.inventory.domain.entity.ItemEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemRepository implements PanacheRepository<ItemEntity> {
}
