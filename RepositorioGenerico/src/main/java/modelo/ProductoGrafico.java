/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;



/**
 *
 * @author Cheese
 */
public class ProductoGrafico {
    private String nombre;
    private double valorVentas;

    public ProductoGrafico(String nombre, double valorVentas) {
        this.nombre = nombre;
        this.valorVentas = valorVentas;
    }

public String getNombre(){
    return nombre;
}    

public double getValorVentas(){
    return valorVentas;
}
    
}
