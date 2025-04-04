package tragaperras.com.app.mvc.controller;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Clase Threads que extiende de Thread para manejar la animación de un slot machine.
 */
public class Threads extends Thread {
    private final JLabel label; // Etiqueta donde se mostrará la imagen
    private final int duracion; // Duración de la animación en milisegundos

    /**
     * Mapa que asocia nombres de imágenes con sus rutas.
     */
    private static final Map<String, String> images = new HashMap<>();
    static {
        images.put("SANDIA", "/tragaperras/com/app/images/sandia.png");
        images.put("BAR", "/tragaperras/com/app/images/bar.png");
        images.put("CEREZAS", "/tragaperras/com/app/images/cerezas.png");
        images.put("CORAZON", "/tragaperras/com/app/images/corazon.png");
        images.put("DIAMANTE", "/tragaperras/com/app/images/diamante.png");
        images.put("HERRADURA", "/tragaperras/com/app/images/herradura.png");
        images.put("LIMON", "/tragaperras/com/app/images/limon.png");
        images.put("SIETE", "/tragaperras/com/app/images/siete.png");
    }

    private final Random random = new Random(); // Generador de números aleatorios
    private String lastKey = ""; // Última clave seleccionada del diccionario

    /**
     * Constructor de la clase Threads.
     * 
     * @param label JLabel donde se mostrarán las imágenes.
     * @param duracion Duración de la animación en milisegundos.
     */
    public Threads(JLabel label, int duracion) {
        this.label = label;
        this.duracion = duracion;
    }

    /**
     * Método run que controla la animación del slot machine.
     */
    @Override
    public void run() {
        long tiempoFinal = System.currentTimeMillis() + duracion;

        while (System.currentTimeMillis() < tiempoFinal) {
            if (Thread.currentThread().isInterrupted()) {
                return; 
            }

            // Obtener una clave aleatoria del diccionario
            Object[] keys = images.keySet().toArray();
            lastKey = (String) keys[random.nextInt(keys.length)];
            String imagePath = images.get(lastKey);

            // Actualizar el JLabel con la imagen correspondiente
            ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
            label.setIcon(icon);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    /**
     * Método para obtener la última clave seleccionada del diccionario.
     * 
     * @return Última clave usada para la imagen.
     */
    public String getLastKey() {
        return lastKey;
    }
}