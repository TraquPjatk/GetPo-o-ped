package GetPooped;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public abstract class PopeCallingForPrayers {
    public static void call() {

        Map<String, Integer> prayerDurationMap = new HashMap<>();
        prayerDurationMap.put("zarp.wav", 13000);
        prayerDurationMap.put("zydeuszpozdrawia.wav", 8000);

        String[] prayerNamesArray = new String[]{"zarp.wav", "zydeuszpozdrawia.wav"};

        new Thread(() -> {
        while (true) {
            int prayerNumber = (int) (Math.random() * 2);
            Integer prayerDuration = prayerDurationMap.get(prayerNamesArray[prayerNumber]);


            try {
                callPrayer(prayerNamesArray[prayerNumber]);
                Thread.sleep(prayerDuration);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }}).start();


//        callPrayer(prayerNamesArray[(int) (Math.random() * 2)]);

    }

    private static void callPrayer(String prayerName) {
        try {
            InputStream is = PopeCallingForPrayers.class.getClassLoader().getResourceAsStream(prayerName);
            if (is == null) {
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            //
        }
    }
}
