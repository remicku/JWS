package fr.epita.assistants.presentation.rest.response;

public class ReverseResponse {
    public String original;
    public String reversed;

    public ReverseResponse(String original, String reversed) {
        this.original = original;
        this.reversed = reversed;
    }
}