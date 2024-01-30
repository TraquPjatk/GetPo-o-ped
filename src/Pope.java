import GetPooped.PopeCallingForPrayers;
import GetPooped.PopeDisplayingArt;
import GetPooped.PopeJumpingOnYourKeyboard;
import GetPooped.PopePlayingHideAndSeek;
import UI.Windows.GameSpecific.RobuxWindow;

public class Pope {
    public static void main(String[] args) {

        new RobuxWindow("Robux");




        PopeJumpingOnYourKeyboard.jump();
        PopeCallingForPrayers.call();
        PopeDisplayingArt.display();
        PopePlayingHideAndSeek.hide();

    }
}