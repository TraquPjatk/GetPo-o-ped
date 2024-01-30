package UI;

import javax.swing.*;
import java.awt.*;

public class BaseWindow extends JFrame {

    private static final int WINDOW_WIDTH = 550;
    private static final int WINDOW_HEIGHT = 450;
    protected JButton proceedButton;

    public BaseWindow() throws HeadlessException {
        this.setAlwaysOnTop(true);

        JPanel contentPanel = new JPanel();
        this.add(contentPanel);

        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        JPanel topPanel = new JPanel();
        contentPanel.add(topPanel);
        JPanel bottomPanel = new JPanel();
        contentPanel.add(bottomPanel);
        topPanel.setBackground(Color.BLACK);
        bottomPanel.setBackground(Color.RED);
        int bannerHeight = 115;
        topPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, bannerHeight));
        bottomPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT - bannerHeight));


        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);







//TODO remove enything below while pushing into production ↓
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(2137);
    }
}

