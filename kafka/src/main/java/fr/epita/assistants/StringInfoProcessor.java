package fr.epita.assistants;

import fr.epita.assistants.utils.StringInfo;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class StringInfoProcessor {

    @Broadcast
    Emitter<StringInfo> emitter;

    private int nbVowels(String str) {
        return (int) str.chars()
                .filter(c -> Character.isLetter(c) && "aeiouyAEIOUY".indexOf(c) != -1)
                .count();
    }

    private int nbConsonants(String str) {
        return (int) str.chars()
                .filter(c -> Character.isLetter(c) && "aeiouyAEIOUY".indexOf(c) == -1)
                .count();
    }

    private boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    @Incoming("string-info-command")
    @Outgoing("string-info-aggregate")
    @Broadcast
    public StringInfo process(String word) {
        System.out.println("Command received, processing...");

        int nbVowels = nbVowels(word);
        int nbConsonants = nbConsonants(word);
        boolean isPalindrome = isPalindrome(word);

        StringInfo result = new StringInfo(word, nbVowels, nbConsonants, isPalindrome);
        System.out.println("Sending the aggregate...");
        //System.out.println(result);
        return result;
    }
}