/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.VentanaContacto;

/**
 *
 * @author Cheese
 */
public class MainContacto {
      public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaContacto ventana = new VentanaContacto();
                ventana.setVisible(true);
            }
        });
    }
}
