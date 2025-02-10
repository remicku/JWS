package fr.epita.assistants.presentation.rest.response;

public class ReverseResponse {
    public static String original;
    public static String reversed;

    public static String reverse(String str) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            res.append(str.charAt(i));
        }

        return res.toString();
    }
}