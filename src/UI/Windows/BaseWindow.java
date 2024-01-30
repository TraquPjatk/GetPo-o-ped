package UI.Windows;

import UI.Custom.PlaceholderTextField;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BaseWindow extends JFrame {

    private static final int WINDOW_WIDTH = 550;
    private static final int WINDOW_HEIGHT = 480;
    protected final JTextArea promptMessage = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.");
    protected final JLabel inputDescription = new JLabel();
    protected final PlaceholderTextField inputPlaceholder = new PlaceholderTextField();
    protected JButton proceedButton = new JButton();
    protected JRadioButton approveTimeSpent = new JRadioButton("Time spent in game");
    protected JRadioButton approveVisitedServers = new JRadioButton("Visited servers");
    protected JRadioButton approveGameTypes = new JRadioButton("Gametypes played");

    public BaseWindow(String title) throws HeadlessException {
        super(title);

        this.setResizable(false);
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

        Dimension contentPanelDimension = new Dimension(WINDOW_WIDTH / 3 - 5, WINDOW_HEIGHT - bannerHeight - 8);
        leftPanel.setPreferredSize(contentPanelDimension);
        middlePanel.setPreferredSize(contentPanelDimension);
        rightPanel.setPreferredSize(contentPanelDimension);

        leftPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        middlePanel.setBorder(BorderFactory.createLoweredBevelBorder());
        rightPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        rightPanel.add(Box.createVerticalStrut(500));

        proceedButton.setPreferredSize(new Dimension(140, 25));
        rightPanel.add(proceedButton);
        proceedButton.setFocusable(false);

        proceedButton.addActionListener(e -> this.dispose());

        promptMessage.setPreferredSize(new Dimension(leftPanel.getPreferredSize().width - 3, leftPanel.getPreferredSize().height));
        promptMessage.setLineWrap(true);
        promptMessage.setWrapStyleWord(true);
        promptMessage.setEditable(false);
        promptMessage.setFocusable(false);
        promptMessage.setBackground(new Color(238, 238, 238, 255));
        leftPanel.add(promptMessage);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));

        JPanel midTopPanel = new JPanel();
        JPanel midRadioBtnPanel = new JPanel();
        JPanel midBottomPanel = new JPanel();

        middlePanel.add(midTopPanel);
        middlePanel.add(midRadioBtnPanel);
        middlePanel.add(midBottomPanel);

        midTopPanel.setLayout(new BoxLayout(midTopPanel, BoxLayout.Y_AXIS));
        FlowLayout leftFlowLayout = new FlowLayout(FlowLayout.LEFT);
        midRadioBtnPanel.setLayout(leftFlowLayout);
        midBottomPanel.setLayout(leftFlowLayout);

        JTextArea agreementText = new JTextArea("By selecting you consent \nto what follows:");
        agreementText.setBorder(BorderFactory.createSoftBevelBorder(0));
        agreementText.setFocusable(false);
        agreementText.setEditable(false);
        agreementText.setLineWrap(true);
        agreementText.setWrapStyleWord(true);
        agreementText.setMaximumSize(new Dimension(middlePanel.getPreferredSize().width,36));
        agreementText.setBackground(new Color(238, 238, 238, 255));
        midTopPanel.add(agreementText);

        midRadioBtnPanel.add(approveTimeSpent);
        midRadioBtnPanel.add(approveGameTypes);
        midRadioBtnPanel.add(approveVisitedServers);

        PlaceholderTextField nameInput = inputPlaceholder;
        nameInput.setDisabledTextColor(Color.BLUE);
        nameInput.setPreferredSize(new Dimension(middlePanel.getPreferredSize().width - 12, 21));


        midBottomPanel.add(inputDescription);
        midBottomPanel.add(nameInput);

        approveTimeSpent.setFocusable(false);
        approveGameTypes.setFocusable(false);
        approveVisitedServers.setFocusable(false);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.requestFocusInWindow();
    }
}

