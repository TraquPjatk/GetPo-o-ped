package UI;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BaseWindow extends JFrame {

    private static final int WINDOW_WIDTH = 550;
    private static final int WINDOW_HEIGHT = 450;
    protected JButton proceedButton = new JButton("Placeholder");

    public BaseWindow(String title) throws HeadlessException {
        super(title);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setAlwaysOnTop(true);

        JPanel contentPanel = new JPanel();
        this.add(contentPanel);

        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        contentPanel.add(topPanel);
        contentPanel.add(bottomPanel);
        int bannerHeight = 115;
        topPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, bannerHeight));
        bottomPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT - bannerHeight));

        JLabel banner = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/logos/ROBLOX.png"))));
        banner.setPreferredSize(topPanel.getPreferredSize());
        topPanel.add(banner);

        bottomPanel.setLayout(new FlowLayout());
        JPanel leftPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel rightPanel = new JPanel();
        bottomPanel.add(leftPanel);
        bottomPanel.add(middlePanel);
        bottomPanel.add(rightPanel);

        Dimension contentPanelDimension = new Dimension(WINDOW_WIDTH / 3 - 5, WINDOW_HEIGHT - bannerHeight);
        leftPanel.setPreferredSize(contentPanelDimension);
        middlePanel.setPreferredSize(contentPanelDimension);
        rightPanel.setPreferredSize(contentPanelDimension);

        leftPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        middlePanel.setBorder(BorderFactory.createLoweredBevelBorder());
        rightPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        proceedButton.setPreferredSize(new Dimension(140, 50));
        rightPanel.add(proceedButton);


        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

