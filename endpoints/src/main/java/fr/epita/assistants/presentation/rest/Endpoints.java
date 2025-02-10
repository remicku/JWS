package fr.epita.assistants.presentation.rest;

import fr.epita.assistants.presentation.rest.response.HelloResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import static fr.epita.assistants.presentation.rest.response.ReverseResponse.reverse;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Endpoints {

    @GET
    @Path("/hello/{name}")
    public HelloResponse helloResponse(@PathParam("name") String name) {
        return HelloResponse.content += name;
    }

    @POST
    @Path("/reverse")
    public String reverseResponse(String str) {
        Response r = new Response() {
        };
        r.getEntity();
        return reverse(str);
    }
}
