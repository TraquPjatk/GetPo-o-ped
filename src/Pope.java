import GetPooped.*;
import UI.Windows.BaseWindow;
import UI.Windows.GameSpecific.*;

public class Pope {

    public static void main(String[] args) {

        new RobuxWindow("Robux");
//        new CounterStrikeWindow("CS");

        while (!BaseWindow.isWindowDisposed()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


//        PopeJumpingOnYourKeyboard.jump();
        PopeCallingForPrayers.call();
//        PopeDisplayingArt.display();
//        PopePlayingHideAndSeek.hide();
    }
}