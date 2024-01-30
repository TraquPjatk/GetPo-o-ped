package UI;

import javax.swing.*;
import java.awt.*;

public class RobuxWindow extends BaseWindow {
    public RobuxWindow(String title) throws HeadlessException {
        super(title);
        proceedButton.setText("Get robux");
        System.out.println("test");
        //TODO remove enything below while pushing into production ↓
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(2137);
    }
}
