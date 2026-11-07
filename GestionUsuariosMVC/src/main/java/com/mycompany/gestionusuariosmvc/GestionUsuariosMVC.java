/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionusuariosmvc;

import com.mycompany.gestionusuariosmvc.controlador.UsuarioController;
import com.mycompany.gestionusuariosmvc.vista.UsuarioView;

/**
 *
 * @author Cheese
 */
public class GestionUsuariosMVC {

    public static void main(String[] args) {
        UsuarioView vista = new UsuarioView();
        UsuarioController controlador = new UsuarioController(vista);
        
        controlador.iniciar();
    }
}
