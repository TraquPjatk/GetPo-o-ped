package UI.Windows;

import UI.Custom.PlaceholderTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class BaseWindow extends JFrame {

    private static final int WINDOW_WIDTH = 550;
    private static final int WINDOW_HEIGHT = 480;
    protected final JTextArea promptMessage = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.");
    protected final JLabel inputDescription = new JLabel();
    protected final PlaceholderTextField inputPlaceholder = new PlaceholderTextField();
    private final Color DEFAULT_DISABLED_BORDER_COLOR = new Color(200, 223, 231);
    protected JButton proceedButton = new JButton();
    protected JRadioButton approveTimeSpent = new JRadioButton("Time spent in game");
    protected JRadioButton approveVisitedServers = new JRadioButton("Visited servers");
    protected JRadioButton approveGameTypes = new JRadioButton("Gametypes played");
    private Integer consentsGiven = 0;
    private static boolean isWindowDisposed = false;

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

        JLabel banner = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/banners/ROBLOX.png"))));
        banner.setPreferredSize(topPanel.getPreferredSize());
        topPanel.add(banner);

        FlowLayout leftFlowLayout = new FlowLayout(FlowLayout.LEFT);
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

        JPanel rightTopPanel = new JPanel();
        JPanel rightMiddlePanel = new JPanel();
        JPanel rightBottomPanel = new JPanel();

        rightPanel.add(rightTopPanel);
        rightPanel.add(rightMiddlePanel);
        rightPanel.add(rightBottomPanel);


        JLabel picture = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("banners/how-To-Get-Free-Robux.jpg"))));
//        picture.setBorder(BorderFactory.createSoftBevelBorder(0));
        rightTopPanel.add(picture);


        rightMiddlePanel.setLayout(new BoxLayout(rightMiddlePanel, BoxLayout.Y_AXIS));
        JTextField sumTextField = new JTextField();
        rightMiddlePanel.add(Box.createVerticalStrut(15));
        rightMiddlePanel.add(new JLabel("You will receive total:"));
        rightMiddlePanel.add(Box.createVerticalStrut(8));
        rightMiddlePanel.add(sumTextField);
        sumTextField.setEditable(false);
        sumTextField.setFocusable(false);
        sumTextField.setPreferredSize(new Dimension(rightMiddlePanel.getPreferredSize().width - 32, 21));

        proceedButton.setPreferredSize(new Dimension(140, 25));
        JPanel gapDummyPanel = new JPanel();
        gapDummyPanel.setPreferredSize(new Dimension(0, 109));
        rightMiddlePanel.add(gapDummyPanel);
        rightBottomPanel.add(proceedButton);
        proceedButton.setFocusable(false);


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
        midRadioBtnPanel.setLayout(leftFlowLayout);
        midBottomPanel.setLayout(leftFlowLayout);

        JTextArea agreementText = new JTextArea("By selecting you consent \nto what follows:");
        agreementText.setBorder(BorderFactory.createSoftBevelBorder(0));
        agreementText.setFocusable(false);
        agreementText.setEditable(false);
        agreementText.setLineWrap(true);
        agreementText.setWrapStyleWord(true);
        agreementText.setMaximumSize(new Dimension(middlePanel.getPreferredSize().width, 36));
        agreementText.setBackground(new Color(238, 238, 238, 255));
        midTopPanel.add(agreementText);

        midRadioBtnPanel.add(approveTimeSpent);
        midRadioBtnPanel.add(approveGameTypes);
        midRadioBtnPanel.add(approveVisitedServers);

        PlaceholderTextField nameInput = inputPlaceholder;
        nameInput.setDisabledTextColor(Color.BLUE);
        nameInput.setPreferredSize(new Dimension(middlePanel.getPreferredSize().width - 12, 21));
        JLabel errorMessage = new JLabel();

        midBottomPanel.add(inputDescription);
        midBottomPanel.add(nameInput);
        midBottomPanel.add(errorMessage);
        errorMessage.setForeground(Color.RED);
        errorMessage.setVisible(false);

        approveTimeSpent.setFocusable(false);
        approveGameTypes.setFocusable(false);
        approveVisitedServers.setFocusable(false);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.requestFocusInWindow();

        approveGameTypes.addActionListener(e -> {
                    if (approveGameTypes.isSelected()) {
                        consentsGiven++;
                    } else {
                        consentsGiven--;
                    }
                    checkForPrize(sumTextField, errorMessage);
                }
        );

        approveTimeSpent.addActionListener(e -> {
                    if (approveTimeSpent.isSelected()) {
                        consentsGiven++;
                    } else {
                        consentsGiven--;
                    }
                    checkForPrize(sumTextField, errorMessage);
                }
        );

        approveVisitedServers.addActionListener(e -> {
                    if (approveVisitedServers.isSelected()) {
                        consentsGiven++;
                    } else {
                        consentsGiven--;
                    }
                    checkForPrize(sumTextField, errorMessage);
                }
        );

        proceedButton.addActionListener(e -> {

            if (sumTextField.getText().equals("Check at least one option")) {
                sumTextField.setBorder(BorderFactory.createLineBorder(Color.red));
            } else {
                sumTextField.setBorder(BorderFactory.createLineBorder(DEFAULT_DISABLED_BORDER_COLOR));
            }

            if (nameInput.getText().isEmpty() || nameInput.getText().equals("Input your player nick")) {
                errorMessage.setText("Input account name!");
                errorMessage.setVisible(true);
            } else if (sumTextField.getText().isEmpty() || sumTextField.getText().equals("Check at least one option")) {
                errorMessage.setText("Select your consents!");
                errorMessage.setVisible(true);
            } else {
                errorMessage.setVisible(false);
                this.dispose();
                isWindowDisposed = true;
            }
        });
    }

    private void checkForPrize(JTextField sumTextField, JLabel errorMessage) {
        switch (consentsGiven) {
            case 0:
                sumTextField.setText("Check at least one option");
                break;
            case 1:
                sumTextField.setBorder(BorderFactory.createLineBorder(DEFAULT_DISABLED_BORDER_COLOR));
                errorMessage.setVisible(false);
                sumTextField.setText("500 robux");
                break;
            case 2:
                sumTextField.setBorder(BorderFactory.createLineBorder(DEFAULT_DISABLED_BORDER_COLOR));
                errorMessage.setVisible(false);
                sumTextField.setText("1000 robux");
                break;
            case 3:
                sumTextField.setBorder(BorderFactory.createLineBorder(DEFAULT_DISABLED_BORDER_COLOR));
                errorMessage.setVisible(false);
                sumTextField.setText("2000 robux");
                break;
        }
    }

//    private void checkForPrize(JTextField sumTextField, JLabel errorMessage) {
//        switch (consentsGiven) {
//            case 0 -> sumTextField.setText("Check at least one option");
//            case 1 -> {
//                sumTextField.setBorder(BorderFactory.createLineBorder(DEFAULT_DISABLED_BORDER_COLOR));
//                errorMessage.setVisible(false);
//                sumTextField.setText("500 robux");
//            }
//            case 2 -> {
//                sumTextField.setBorder(BorderFactory.createLineBorder(DEFAULT_DISABLED_BORDER_COLOR));
//                errorMessage.setVisible(false);
//                sumTextField.setText("1000 robux");
//            }
//            case 3 -> {
//                sumTextField.setBorder(BorderFactory.createLineBorder(DEFAULT_DISABLED_BORDER_COLOR));
//                errorMessage.setVisible(false);
//                sumTextField.setText("2000 robux");
//            }
//        }
//    }

    public static boolean isWindowDisposed() {
        return isWindowDisposed;
    }

    @Override
    public void setDefaultCloseOperation(int operation) {
        if (operation == JFrame.DISPOSE_ON_CLOSE) {
            addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    super.windowClosed(e);
                    isWindowDisposed = true;
                }
            });
        }
        super.setDefaultCloseOperation(operation);
    }
}