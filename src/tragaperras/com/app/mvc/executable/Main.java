package tragaperras.com.app.mvc.executable;

import tragaperras.com.app.mvc.view.ViewDesign;

/**
 *
 * @author luiis
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Metodo para hacer visible la ventana principal desde el main y ejecutar todo el codigo por consiguiente.
         */
        java.awt.EventQueue.invokeLater(() -> {
            new ViewDesign().setVisible(true);
        });
    }
}
