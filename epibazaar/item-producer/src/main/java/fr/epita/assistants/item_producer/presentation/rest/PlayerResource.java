package fr.epita.assistants.item_producer.presentation.rest;

import fr.epita.assistants.common.api.response.PlayerResponse;
import fr.epita.assistants.item_producer.data.model.PlayerModel;
import fr.epita.assistants.item_producer.domain.service.PlayerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayerResource {
    @Inject
    PlayerService playerService;

    @GET
    public Response getPlayer() {
        try {
            PlayerModel player = playerService.getPlayerData();
            PlayerResponse.PlayerData res = new PlayerResponse.PlayerData(player.getPosX(), player.getPosY(), player.getLastMove(),
                    player.getLastCollect(), player.getMoveSpeedMultiplier(), player.getStaminaMultiplier(),
                    player.getCollectRateMultiplier());

            return Response.ok(new PlayerResponse(res)).build();
        }
        catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
