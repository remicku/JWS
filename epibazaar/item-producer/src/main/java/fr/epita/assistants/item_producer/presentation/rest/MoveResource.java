package fr.epita.assistants.item_producer.presentation.rest;

import fr.epita.assistants.common.api.request.MoveRequest;
import fr.epita.assistants.common.api.response.MoveResponse;
import fr.epita.assistants.common.utils.ErrorInfo;
import fr.epita.assistants.item_producer.domain.entity.MoveEntity;
import fr.epita.assistants.item_producer.domain.service.MoveService;
import fr.epita.assistants.item_producer.errors.StartError;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/move")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MoveResource {
    @Inject
    MoveService moveService;

    @POST
    public Response move(MoveRequest request) {
        try {
            MoveEntity newPos = moveService.movePlayer(request.direction);
            return Response.ok(new MoveResponse(newPos.posX, newPos.posY)).build();
        }
        catch (ArithmeticException e) {
            return Response.status(Response.Status.TOO_MANY_REQUESTS).entity(new ErrorInfo("Too Fast")).build();
        }
        catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorInfo("Impossible to move")).build();
        }
    }
}
