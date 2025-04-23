package univerisdadProgramacion;

import javax.sound.sampled.*;
import java.io.InputStream;
import java.io.BufferedInputStream;

class ReproductorSonido {
    public static void reproducir(String rutaRelativa) {
        try {
            InputStream audioSrc = ReproductorSonido.class.getResourceAsStream(rutaRelativa);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("No se pudo reproducir el sonido: " + rutaRelativa);
            e.printStackTrace();
        }
    }
}
