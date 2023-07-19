package UI;

import javax.sound.sampled.*;

import static javax.sound.sampled.AudioSystem.getAudioInputStream;

public class PlayAudio {
    public PlayAudio() {
        try {
            // Apri il file MP3 come stream audio
            AudioInputStream audioInputStream = getAudioInputStream(PlayAudio.class.getResourceAsStream("regoleGioco.mp3"));

            // Ottieni il formato audio del file
            AudioFormat format = audioInputStream.getFormat();

            // Crea una clip audio
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip) AudioSystem.getLine(info);

            // Apri il clip audio e inizia la riproduzione
            clip.open(audioInputStream);
            clip.start();

            // Attendi la fine della riproduzione
            while (!clip.isRunning()) {
                Thread.sleep(10);
            }
            while (clip.isRunning()) {
                Thread.sleep(10);
            }

            // Chiudi il clip audio e lo stream audio
            clip.close();
            audioInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}