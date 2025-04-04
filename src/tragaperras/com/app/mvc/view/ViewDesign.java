/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tragaperras.com.app.mvc.view;
import tragaperras.com.app.mvc.controller.Threads;
import tragaperras.com.app.mvc.controller.Betting;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author luiis
 */
public class ViewDesign extends javax.swing.JFrame {
    
        private Threads hilo1, hilo2, hilo3; // Instancias de la clase Threads
        private Betting betting; // Instancia de la clase Betting

    
    /**
     * Creates new form viewdesign
     */
    public ViewDesign() {
        initComponents();
        setLocationRelativeTo(null);
        betting = new Betting(50, mostrarSaldo); // Inicializa Betting con saldo de 50

    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBase = new javax.swing.JPanel();
        apuesta = new javax.swing.JFormattedTextField();
        leverAction = new javax.swing.JButton();
        Carrete1 = new javax.swing.JLabel();
        Carrete2 = new javax.swing.JLabel();
        Carrete3 = new javax.swing.JLabel();
        enviarApuesta = new javax.swing.JButton();
        mostrarSaldo = new javax.swing.JLabel();
        imgFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBase.setBackground(new java.awt.Color(255, 255, 255));
        panelBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        apuesta.setText("Introduzca su apuesta...");
        apuesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apuestaMouseClicked(evt);
            }
        });
        panelBase.add(apuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 370, 40));

        leverAction.setOpaque(true);
        leverAction.setContentAreaFilled(false);
        leverAction.setBorderPainted(false);
        leverAction.setFocusPainted(false);
        leverAction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leverActionMouseClicked(evt);
            }
        });
        panelBase.add(leverAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 60, 120));

        Carrete1.setBackground(new java.awt.Color(255, 255, 255));
        Carrete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tragaperras/com/app/images/cerezas.png"))); // NOI18N
        panelBase.add(Carrete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 90, 80));

        Carrete2.setBackground(new java.awt.Color(255, 255, 255));
        Carrete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tragaperras/com/app/images/cerezas.png"))); // NOI18N
        panelBase.add(Carrete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 90, 80));

        Carrete3.setBackground(new java.awt.Color(255, 255, 255));
        Carrete3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tragaperras/com/app/images/cerezas.png"))); // NOI18N
        panelBase.add(Carrete3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 90, 80));

        enviarApuesta.setText("Enviar");
        enviarApuesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enviarApuestaMouseClicked(evt);
            }
        });
        panelBase.add(enviarApuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, -1, 40));

        mostrarSaldo.setForeground(new java.awt.Color(255, 255, 255));
        panelBase.add(mostrarSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 40));

        imgFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tragaperras/com/app/images/bgtp.png"))); // NOI18N
        panelBase.add(imgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 500));

        getContentPane().add(panelBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void leverActionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leverActionMouseClicked
       // Cambia el fondo al presionar el botón
   imgFondo.setIcon(new ImageIcon(getClass().getResource("/tragaperras/com/app/images/bgtpaction.png")));

    if (hilo1 != null && hilo1.isAlive()) hilo1.interrupt();
    if (hilo2 != null && hilo2.isAlive()) hilo2.interrupt();
    if (hilo3 != null && hilo3.isAlive()) hilo3.interrupt();

    hilo1 = new Threads(Carrete1, 1500);
    hilo2 = new Threads(Carrete2, 1800);
    hilo3 = new Threads(Carrete3, 2100);

    hilo1.start();
    hilo2.start();
    hilo3.start();

    Timer timer = new Timer(2100, new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            imgFondo.setIcon(new ImageIcon(getClass().getResource("/tragaperras/com/app/images/bgtp.png")));

            // Obtener la clave de la última imagen de cada carrete
            String key1 = hilo1.getLastKey();
            String key2 = hilo2.getLastKey();
            String key3 = hilo3.getLastKey();

            System.out.println("Carrete 1: " + key1);
            System.out.println("Carrete 2: " + key2);
            System.out.println("Carrete 3: " + key3);

            // Evaluar el resultado y mostrarlo en consola
            if (key1.equals(key2) && key2.equals(key3)) {
                System.out.println("JACKPOT! Los tres carretes son iguales: " + key1);
            } else if (key1.equals(key2) || key1.equals(key3) || key2.equals(key3)) {
                System.out.println("Ganaste! Hay dos imagenes iguales.");
            } else {
                System.out.println("Sigue intentando. Todas son diferentes.");
            }
        }
    });
    timer.setRepeats(false);
    timer.start();
    }//GEN-LAST:event_leverActionMouseClicked

    private void enviarApuestaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enviarApuestaMouseClicked
       try {
            int cantidad = Integer.parseInt(apuesta.getText().trim());
            betting.placeBet(cantidad);
        } catch (NumberFormatException e) {
            mostrarSaldo.setText("Apuesta inválida");
        }
    }//GEN-LAST:event_enviarApuestaMouseClicked

    private void apuestaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apuestaMouseClicked
         String defaultText = "Introduzca su apuesta...";
        if (apuesta.getText().equals(defaultText)){
            apuesta.setText("");
        }
    }//GEN-LAST:event_apuestaMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Carrete1;
    private javax.swing.JLabel Carrete2;
    private javax.swing.JLabel Carrete3;
    private javax.swing.JFormattedTextField apuesta;
    private javax.swing.JButton enviarApuesta;
    private javax.swing.JLabel imgFondo;
    private javax.swing.JButton leverAction;
    private javax.swing.JLabel mostrarSaldo;
    private javax.swing.JPanel panelBase;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelative(Object oject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
