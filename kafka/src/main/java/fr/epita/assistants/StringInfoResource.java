package fr.epita.assistants;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Path("/send")
public class StringInfoResource {
    @Inject
    @Channel("string-info-command")
    @Broadcast
    Emitter<String> emitter;

    @POST
    @Broadcast
    public void send(String word) {
        System.out.println("Sending a command: " + word);
        emitter.send(word);
    }
}
