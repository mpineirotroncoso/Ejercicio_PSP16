package controller;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicaHilo extends Thread {
    private String rutaArchivo;

    public MusicaHilo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void run() {
        try {
            File archivo = new File(rutaArchivo);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Reproducir en bucle

            // Ejecutar solo cuando este en movimiento
            while (!Thread.interrupted() && AscensorController.enMovimiento()) {
                Thread.sleep(1000);
            }
            clip.stop();
            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}