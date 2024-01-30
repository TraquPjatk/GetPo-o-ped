package GetPooped;

import Utilities.GifNamesReader;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.List;
import java.util.Random;

public abstract class PopeDisplayingArt {
    private static final List<String> GIF_NAMES_LIST = GifNamesReader.getGifNamesList();
    private static final Random RANDOM = new Random();
    public final static Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private final static int SCREEN_WIDTH = SCREEN_SIZE.width;
    private final static int SCREEN_HEIGHT = SCREEN_SIZE.height;
    private static final int NUMBER_OF_POPES = 100;

    public static void display() {
        for (int i = 0; i < NUMBER_OF_POPES; i++) {
            try {
                Thread.sleep(200);
            } catch (Exception e) {
//
            }
            String gifName = GIF_NAMES_LIST.get(RANDOM.nextInt(GIF_NAMES_LIST.size()));
            createNewPopeWindow(gifName);
        }
    }

    private static void createNewPopeWindow(String gifName) {
        JWindow window = new JWindow();
        window.setAlwaysOnTop(true);
        URL gifUrl = PopeDisplayingArt.class.getResource("/" + gifName);
        JLabel gif = null;

        if (gifUrl != null) {
            gif = new JLabel(new ImageIcon(gifUrl));
            window.setSize(gif.getPreferredSize().width, gif.getPreferredSize().height);
            window.add(gif);
        }
        window.setVisible(true);

        if (gif != null) {
            Dimension dimension = randomizeLocation(PopeDisplayingArt.SCREEN_WIDTH, PopeDisplayingArt.SCREEN_HEIGHT, gif);
            window.setLocation(dimension.width, dimension.height);
        }
    }

    private static Dimension randomizeLocation(int width, int height, JLabel gif) {

        int x = RANDOM.nextInt(width - gif.getWidth());
        int y = RANDOM.nextInt(height - gif.getHeight());

        return new Dimension(x, y);
    }
}