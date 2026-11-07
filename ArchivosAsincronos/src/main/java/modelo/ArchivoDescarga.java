/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Excepciones.TiempoExcedidoException;
import controlador.DescargaController;

/**
 *
 * @author Cheese
 */
public class ArchivoDescarga implements Runnable {
    private String nombreArchivo;
    private int tiempoMaximoSegundos;
    private DescargaController controlador;
    
    public ArchivoDescarga(String nombreArchivo, int tiempoMaximoSegundos, DescargaController controlador) {
       this.nombreArchivo = nombreArchivo;
       this.tiempoMaximoSegundos = tiempoMaximoSegundos;
       this.controlador = controlador;
    }
     
  
    public void run() {
        try {
            
            int tiempoTotalDescarga = 8; 

            for (int segundoActual = 1; segundoActual <= tiempoTotalDescarga; segundoActual++) {
                Thread.sleep(1000); 

                
                if (segundoActual > tiempoMaximoSegundos) {
                    throw new TiempoExcedidoException("Hubo un error: Se excedió el tiempo límite de " + tiempoMaximoSegundos + " segundos.");
                }

           
                int porcentaje = (segundoActual * 100) / tiempoTotalDescarga;
                controlador.actualizarProgresoDesdeHilo(porcentaje, "Descargando " + nombreArchivo + "... (" + segundoActual + "s)");
            }

            
            controlador.finalizarDescargaConExito();

        } catch (TiempoExcedidoException e) {
            controlador.notificarErrorDesdeHilo(e.getMessage());
        } catch (InterruptedException e) {
            controlador.notificarErrorDesdeHilo("Descarga interrumpida.");
        }
    }
     
     
     
}
