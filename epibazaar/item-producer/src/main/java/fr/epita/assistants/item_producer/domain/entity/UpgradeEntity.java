package fr.epita.assistants.item_producer.domain.entity;

public class UpgradeEntity {
    public float upgradeCollectCost;
    public float upgradeMoveCost;
    public float upgradeStaminaCost;

    public UpgradeEntity(float upgradeCollectCost, float upgradeMoveCost, float upgradeStaminaCost) {
        this.upgradeCollectCost = upgradeCollectCost;
        this.upgradeMoveCost = upgradeMoveCost;
        this.upgradeStaminaCost = upgradeStaminaCost;
    }
}
