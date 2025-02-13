package fr.epita.assistants.item_producer.converter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Formater {
    public Stream<String> streamContent;
    /**
     * Initializer.
     *
     * @param srcPath Source file path.
     */
    public Formater(String srcPath) {
        try {
            this.streamContent = Files.lines(Paths.get(srcPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Use the streamContent to replace `wordToReplace` with "miaou". Don't forget
     * to add the line number beforehand for each line. Store the new
     * result directly in the streamContent field.
     *
     * @param wordToReplace The word to replace
     */
    public void replaceByMiaou(String wordToReplace) {
        var line_count = new Object(){ int value = 1; };
        this.streamContent = this.streamContent.map(line-> line_count.value++ + " " + line.replaceAll(wordToReplace, ";"));
    }

    /**
     * Use the streamContent to write the content into the destination file.
     *
     * @param destPath Destination file path.
     */
    public void toFile(String destPath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(destPath))) {
            this.streamContent.forEach(line -> {
                try {
                    bw.write(line);
                    bw.write("\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates an instance of MyKitten and calls the above methods to do it
     * straightforwardly.
     *
     * @param srcPath       Source file path
     * @param destPath      Destination file path
     * @param wordToReplace Word to replace
     */
    public static void miaou(String srcPath, String destPath,
                             String wordToReplace) {
        Formater kit = new Formater(srcPath);
        kit.replaceByMiaou(wordToReplace);
        kit.toFile(destPath);
        //TODO replace toFile with toDatabase
    }
}
