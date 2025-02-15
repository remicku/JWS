package fr.epita.assistants.item_producer.presentation.rest;

import fr.epita.assistants.common.api.response.ItemsResponse;
import fr.epita.assistants.item_producer.data.model.ItemModel;
import fr.epita.assistants.item_producer.domain.service.ItemService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {
    @Inject
    ItemService itemService;

    @GET
    public Response getResources() {
        List<ItemsResponse.ItemData> res = new ArrayList<>();
        List<ItemModel> itemList = itemService.getItemResources();

        for (ItemModel i : itemList) {
            res.add(new ItemsResponse.ItemData(i.getId(), i.getQuantity(), i.getType()));
        }

        return Response.ok(new ItemsResponse(res)).build();
    }
}
