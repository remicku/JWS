package fr.epita.assistants.common.api.response;

public class UpgradeCostResponse {
    public Float upgradeCollectCost;
    public Float upgradeMoveCost;
    public Float upgradeStaminaCost;

    public UpgradeCostResponse(float upgradeCollectCost, float upgradeMoveCost, float upgradeStaminaCost) {
        this.upgradeCollectCost = upgradeCollectCost;
        this.upgradeMoveCost = upgradeMoveCost;
        this.upgradeStaminaCost = upgradeStaminaCost;
    }

}
