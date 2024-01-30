package SupportingProgrammes;

import java.io.*;
import java.util.Objects;

public class GifFetcher {

    private static final String GIF_NAMES_FILE_PATH = "resources/gifNames";

    public static void main(String[] args) {
        File gifNamesFile = new File(GIF_NAMES_FILE_PATH);

        try (BufferedWriter clearWriter = new BufferedWriter(new FileWriter(gifNamesFile, false))) {
            System.out.println("File " + GIF_NAMES_FILE_PATH + " cleared.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("resources");
        File[] resourceFiles = file.listFiles();

        for (int i = 0; i < Objects.requireNonNull(resourceFiles).length; i++) {
            File resourceFile = resourceFiles[i];

            if (resourceFile.isFile() && resourceFile.getName().endsWith(".gif")) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(GIF_NAMES_FILE_PATH, true))) {
                    writer.write(resourceFile.getName());

                    if (i < resourceFiles.length - 1) {
                        writer.write("\n");
                    }

                    System.out.println("Data saved for: " + resourceFile.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}