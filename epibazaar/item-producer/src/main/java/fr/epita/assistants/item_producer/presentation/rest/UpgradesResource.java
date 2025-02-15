package fr.epita.assistants.item_producer.presentation.rest;

import fr.epita.assistants.common.api.response.UpgradeCostResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/upgrades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UpgradesResource {
    @ConfigProperty(name = "JWS_UPGRADE_COLLECT_COST") float upgradeCollectCost;
    @ConfigProperty(name = "JWS_UPGRADE_MOVE_COST") float upgradeMoveCost;
    @ConfigProperty(name = "JWS_UPGRADE_STAMINA_COST") float upgradeStaminaCost;

    @GET
    public Response getUpgrades() {
        return Response.ok(new UpgradeCostResponse(upgradeCollectCost, upgradeMoveCost, upgradeStaminaCost)).build();
    }
}
