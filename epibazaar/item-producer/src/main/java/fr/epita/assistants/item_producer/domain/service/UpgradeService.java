package fr.epita.assistants.item_producer.domain.service;

import fr.epita.assistants.item_producer.domain.entity.UpgradeEntity;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class UpgradeService {
    @ConfigProperty(name = "JWS_UPGRADE_COLLECT_COST") float upgradeCollectCost;
    @ConfigProperty(name = "JWS_UPGRADE_MOVE_COST") float upgradeMoveCost;
    @ConfigProperty(name = "JWS_UPGRADE_STAMINA_COST") float upgradeStaminaCost;

    public UpgradeEntity getUpgrades() {
        return new UpgradeEntity(upgradeCollectCost, upgradeMoveCost, upgradeStaminaCost);
    }
}
