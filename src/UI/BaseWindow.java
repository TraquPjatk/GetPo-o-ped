package UI;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BaseWindow extends JFrame {

    private static final int WINDOW_WIDTH = 550;
    private static final int WINDOW_HEIGHT = 450;
    protected JButton proceedButton;

    public BaseWindow(String title) throws HeadlessException {
        super(title);

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

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

//        leftPanel.setBackground(Color.RED);
//        middlePanel.setBackground(Color.GREEN);
//        rightPanel.setBackground(Color.BLACK);

        Dimension contentPanelDimension = new Dimension(WINDOW_WIDTH / 3 - 5, WINDOW_HEIGHT - bannerHeight);
        leftPanel.setPreferredSize(contentPanelDimension);
        middlePanel.setPreferredSize(contentPanelDimension);
        rightPanel.setPreferredSize(contentPanelDimension);

        leftPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());


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

