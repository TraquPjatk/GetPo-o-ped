package Utilities;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GifNamesReader {

    public static List<String> getGifNamesList() {
        List<String> gifNamesList = new ArrayList<>();
        try (InputStream inputStream = GifNamesReader.class.getResourceAsStream("/gifNames");
             InputStreamReader inputStreamReader = new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                gifNamesList.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return gifNamesList;
    }
}
