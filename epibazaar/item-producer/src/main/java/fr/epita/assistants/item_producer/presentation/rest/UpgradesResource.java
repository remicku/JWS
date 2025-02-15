package fr.epita.assistants.item_producer.presentation.rest;

import fr.epita.assistants.common.api.response.UpgradeCostResponse;
import fr.epita.assistants.item_producer.domain.entity.MoveEntity;
import fr.epita.assistants.item_producer.domain.entity.UpgradeEntity;
import fr.epita.assistants.item_producer.domain.service.UpgradeService;
import jakarta.inject.Inject;
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
    @Inject
    UpgradeService upgradeService;

    @GET
    public Response getUpgrades() {
        UpgradeEntity res = upgradeService.getUpgrades();
        return Response.ok(new UpgradeCostResponse(res.upgradeCollectCost, res.upgradeMoveCost, res.upgradeStaminaCost)).build();
    }
}
