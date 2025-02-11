package fr.epita.assistants.presentation.rest;

import fr.epita.assistants.presentation.rest.request.ReverseRequest;
import fr.epita.assistants.presentation.rest.response.HelloResponse;
import fr.epita.assistants.presentation.rest.response.ReverseResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Endpoints {

    @GET
    @Path("/hello/{name}")
    public Response helloResponse(@PathParam("name") String name) {
        if (name == null || name.isEmpty())
            return Response.status(Response.Status.BAD_REQUEST).build();

        HelloResponse res = new HelloResponse("hello " + name);
        return Response.ok(res).build();
    }

    @POST
    @Path("/reverse")
    public Response reverseResponse(ReverseRequest str) {
        if (str == null || str.content == null || str.content.isEmpty())
            return Response.status(Response.Status.BAD_REQUEST).build();
        String rev = new StringBuilder(str.content).reverse().toString();
        ReverseResponse res = new ReverseResponse(str.content, rev);
        return Response.ok(res).build();
    }
}
