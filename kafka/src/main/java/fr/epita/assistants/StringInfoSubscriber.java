package fr.epita.assistants;

import fr.epita.assistants.utils.StringInfo;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class StringInfoSubscriber {

    @Incoming("string-info-aggregate")
    @Broadcast
    public void consume(StringInfo stringInfo) {
        System.out.println(stringInfo.toString());
    }
}