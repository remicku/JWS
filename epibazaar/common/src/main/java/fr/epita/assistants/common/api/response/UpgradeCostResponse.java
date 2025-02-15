package fr.epita.assistants.common.api.response;

public class UpgradeCostResponse {
    public float upgradeCollectCost;
    public float upgradeMoveCost;
    public float upgradeStaminaCost;

    public UpgradeCostResponse(float upgradeCollectCost, float upgradeMoveCost, float upgradeStaminaCost) {
        this.upgradeCollectCost = upgradeCollectCost;
        this.upgradeMoveCost = upgradeMoveCost;
        this.upgradeStaminaCost = upgradeStaminaCost;
    }

}
