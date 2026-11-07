/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import modelo.ProductoGrafico;
import javax.swing.*;
import java.awt.*;
import java.util.List;
/**
 *
 * @author Cheese
 */
public class CanvasGrafico2D extends JPanel {
    private List<ProductoGrafico> datos;
    
    public void setDatos(List<ProductoGrafico> datos){
        this.datos = datos;
        repaint(); 
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(datos == null || datos.isEmpty() )return;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = 50;
        int anchoBarra = 40;
        double maxVenta = datos.stream().mapToDouble(ProductoGrafico::getValorVentas).max().orElse(1.0);
   
        for(ProductoGrafico prod : datos){
            int altoBarra = (int)((prod.getValorVentas()/maxVenta)*150);
            int y = 220 - altoBarra;
            
            g2d.setColor(new Color(41, 128, 185));
            g2d.fillRect(x, y, anchoBarra, altoBarra);
            g2d.drawString(prod.getNombre(), x, 240);
            g2d.drawString("S" + prod.getValorVentas(), x, y -5);
            
            x += 70;
        }
    }
}
