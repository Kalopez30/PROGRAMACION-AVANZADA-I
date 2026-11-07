/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

/**
 *
 * @author Cheese
 */
public class DescargaForm extends JFrame{
    
    
    public JTextField txtArchivo;
    public JTextField txtTiempo;
    public JButton btnDescargar;
    public JProgressBar barritaProgreso;
    public JLabel lblEstado;
    
    public DescargaForm() {
        setTitle("Descarga Asíncrona Simplificada");
        setSize(500, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));
    
    // este viene siendo el texto para el archivo
    JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new JLabel("Archivo:"));
        txtArchivo = new JTextField("DescargandoPrueba.zip", 15);
        p1.add(txtArchivo);
        add(p1);
       
        
    // texto para el tiempo
    JPanel p2 = new JPanel(new FlowLayout());
        p2.add(new JLabel("Tiempo Límite (en segundos):"));
        txtTiempo = new JTextField("5", 5);
        p2.add(txtTiempo);
        add(p2);
        
        
    //botones
    
     btnDescargar = new JButton("Iniciar Descarga");
     add(btnDescargar);
     
     barritaProgreso = new JProgressBar(0, 100);
     barritaProgreso.setStringPainted(true);
     add(barritaProgreso);
     
     // el estado del archivo
     
     lblEstado = new JLabel("Estado: Esperando...", JLabel.CENTER);
     add(lblEstado);
     
     
        
    }
    
    public void configurarBoton(ActionListener listener) {
        btnDescargar.addActionListener(listener);
    }
}
