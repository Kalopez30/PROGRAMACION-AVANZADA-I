/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionusuariosmvc.controlador;
import com.mycompany.gestionusuariosmvc.modelo.Usuario;
import com.mycompany.gestionusuariosmvc.vista.UsuarioView;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Cheese
 */
public class UsuarioController {
    private List<Usuario> baseDatosSimulada;
    private UsuarioView vista;
    private int contadorId;

    public UsuarioController(UsuarioView vista) {
        this.baseDatosSimulada = new ArrayList<>();
        this.vista = vista;
        this.contadorId = 1;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1 -> crearUsuario();
                case 2 -> listarUsuarios();
                case 3 -> actualizarUsuario();
                case 4 -> eliminarUsuario();
                case 5 -> vista.mostrarMensaje("Saliendo del programa...");
                default -> vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    // CRUD - Create
    private void crearUsuario() {
        String nombre = vista.pedirTexto("Ingrese el nombre del usuario: ");
        String email = vista.pedirTexto("Ingrese el email del usuario: ");

        Usuario nuevoUsuario = new Usuario(contadorId++, nombre, email);
        baseDatosSimulada.add(nuevoUsuario);
        vista.mostrarMensaje("Usuario creado exitosamente con ID: " + nuevoUsuario.getId());
    }

    // CRUD - Read
    private void listarUsuarios() {
        vista.mostrarListaUsuarios(baseDatosSimulada);
    }

    // CRUD - Update
    private void actualizarUsuario() {
        int id = vista.pedirEntero("Ingrese el ID del usuario a actualizar: ");
        Usuario usuario = buscarPorId(id);

        if (usuario != null) {
            String nuevoNombre = vista.pedirTexto("Ingrese el nuevo nombre: ");
            String nuevoEmail = vista.pedirTexto("Ingrese el nuevo email: ");

            usuario.setNombre(nuevoNombre);
            usuario.setEmail(nuevoEmail);
            vista.mostrarMensaje("Usuario actualizado correctamente.");
        } else {
            vista.mostrarMensaje("Error: No se encontró ningún usuario con el ID especificado.");
        }
    }

    // CRUD - Delete
    private void eliminarUsuario() {
        int id = vista.pedirEntero("Ingrese el ID del usuario a eliminar: ");
        Usuario usuario = buscarPorId(id);

        if (usuario != null) {
            baseDatosSimulada.remove(usuario);
            vista.mostrarMensaje("Usuario eliminado correctamente.");
        } else {
            vista.mostrarMensaje("Error: No se encontró ningún usuario con el ID especificado.");
        }
    }

    private Usuario buscarPorId(int id) {
        for (Usuario u : baseDatosSimulada) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
}
