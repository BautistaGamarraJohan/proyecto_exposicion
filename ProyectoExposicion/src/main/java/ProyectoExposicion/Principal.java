package ProyectoExposicion;

import ProyectoExposicion.controlador.LoginControlador;
import ProyectoExposicion.controlador.MenuPrincipalControlador;

public class Principal {
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando sistema de vacunación...");
            LoginControlador loginControlador = new LoginControlador();
            
            if (loginControlador.iniciarSesion()) {
                MenuPrincipalControlador menuControlador = new MenuPrincipalControlador();
                menuControlador.iniciarMenu();
            }
        } catch (Exception e) {
            System.out.println("Error al iniciar el sistema: " + e.getMessage());
            e.printStackTrace();
        }
    }
}