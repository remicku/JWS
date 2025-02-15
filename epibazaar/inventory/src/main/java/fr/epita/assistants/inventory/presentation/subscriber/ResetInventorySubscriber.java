package fr.epita.assistants.inventory.presentation.subscriber;

import fr.epita.assistants.common.aggregate.ResetInventoryAggregate;
import fr.epita.assistants.common.command.ResetInventoryCommand;
import fr.epita.assistants.inventory.domain.service.ItemService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class ResetInventorySubscriber {

    @Inject
    ItemService inventoryService;

    @Incoming("reset-inventory-command")
    @Outgoing("reset-inventory-aggregate")
    public ResetInventoryAggregate processResetInventory(ResetInventoryCommand command) {
        return inventoryService.resetInventory();
    }
}
