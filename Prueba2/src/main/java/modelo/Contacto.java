/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Cheese
 */
public class Contacto {
    private String nombre;
    private String numero;
    
    public Contacto(String nombre, String numero){
        this.nombre = nombre;
        this.numero = numero;
    
    }
    
    public String getNombre(){
    return nombre;
}    
    
    public String getNumero(){
    return numero;
    }
    
    public void setNombre(String nombre){
    this.nombre = nombre;
    }
    
    public void setNumero(String numero){
    this.numero = numero;
    }
}

