/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.ArchivoDescarga;
import vista.DescargaForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Cheese
 */
public class DescargaController implements ActionListener {
    
    private final DescargaForm vista;

    public DescargaController(DescargaForm vista) {
        this.vista = vista;
        this.vista.configurarBoton(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String archivo = vista.txtArchivo.getText();
        int tiempoLimite;

        try {
            tiempoLimite = Integer.parseInt(vista.txtTiempo.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Ingrese un número válido para el tiempo.");
            return;
        }

        vista.btnDescargar.setEnabled(false);

        ArchivoDescarga tarea = new ArchivoDescarga(archivo, tiempoLimite, this);
        Thread hilo = new Thread((Runnable) tarea);
        hilo.start(); 
    }

    public void actualizarProgresoDesdeHilo(int porcentaje, String textoEstado) {
        SwingUtilities.invokeLater(() -> {
            vista.barritaProgreso.setValue(porcentaje);
            vista.lblEstado.setText(textoEstado);
        });
    }

    public void finalizarDescargaConExito() {
        SwingUtilities.invokeLater(() -> {
            vista.btnDescargar.setEnabled(true);
            vista.lblEstado.setText("¡Descarga completa!");
            JOptionPane.showMessageDialog(vista, "El archivo se descargó correctamente!!! :D");
        });
    }

    public void notificarErrorDesdeHilo(String mensajeError) {
        SwingUtilities.invokeLater(() -> {
            vista.btnDescargar.setEnabled(true);
            vista.barritaProgreso.setValue(0);
            vista.lblEstado.setText(mensajeError);
            JOptionPane.showMessageDialog(vista, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
        });
    }

    // para arrancar el programaaa
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DescargaForm vistaForm = new DescargaForm();
            new DescargaController(vistaForm);
            vistaForm.setVisible(true);
        });
    }
    
}
