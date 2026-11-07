/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Cheese
 */
public class RepositorioGenerico<T> {
    private List<T> listaElementos = new ArrayList<>();
    private Map<String, T> mapaElementos = new HashMap<>();
    private Stack<T> historialOperaciones = new Stack<>();
    
    public void agregar(String clave, T elemento){
        listaElementos.add(elemento);
        mapaElementos.put(clave, elemento);
        historialOperaciones.push(elemento);
    
    }
    
    public List<T> obtenerTodos(){
        return Collections.unmodifiableList(listaElementos);
    }
    
    public T buscarPorClave(String clave){
        return mapaElementos.get(clave);
    }
    
    public T deshacerUltimo(){
        if(!historialOperaciones.isEmpty()){
            T ultimo = historialOperaciones.pop();
            listaElementos.remove(ultimo);
            return ultimo;
        }
        return null;
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
