package UI;

import javax.swing.*;
import java.awt.*;

public class RobuxWindow extends BaseWindow {
    public RobuxWindow(String title) throws HeadlessException {
        super(title);
        proceedButton.setText("Get robux");
    }
}
