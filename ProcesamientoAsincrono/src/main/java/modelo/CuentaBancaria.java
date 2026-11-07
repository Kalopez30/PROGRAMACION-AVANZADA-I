/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import Excepciones.SaldoInsuficienteException;

/**
 *
 * @author Cheese
 */
public class CuentaBancaria {
    private double saldo;
    public CuentaBancaria(double saldoInicial){
        this.saldo = saldoInicial;
        
    }
    
    public synchronized void retirar(double monto)throws SaldoInsuficienteException{
        if(monto > saldo){
            throw new SaldoInsuficienteException("Fondo Insuficiente para el retiro", monto - saldo);
        }
      saldo -= monto;
    }
    public double getSaldo(){ return saldo;}
}




