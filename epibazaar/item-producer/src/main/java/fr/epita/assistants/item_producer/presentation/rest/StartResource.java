package fr.epita.assistants.item_producer.presentation.rest;

import fr.epita.assistants.common.aggregate.ItemAggregate;
import fr.epita.assistants.common.api.request.StartRequest;
import fr.epita.assistants.common.api.response.StartResponse;
import fr.epita.assistants.item_producer.domain.service.StartService;
import fr.epita.assistants.item_producer.errors.StartError;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import jakarta.inject.Inject;

import java.util.List;

@Path("/start")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StartResource {
    @Inject
    StartService startService;

    @POST
    public Response start(StartRequest request) {
        try {
            if (request == null || request.mapPath == null || request.mapPath.isEmpty())
                return Response.status(Response.Status.BAD_REQUEST).entity(new StartError("Invalid path")).build();

            List<List<ItemAggregate.ResourceType>> map = startService.startGame(request.getMapPath());
            //StartResponse res = startService.startGame(request.getMapPath());
            return Response.ok(new StartResponse(map)).build();
        }
        catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new StartError("Invalid path")).build();
        }
    }
}
