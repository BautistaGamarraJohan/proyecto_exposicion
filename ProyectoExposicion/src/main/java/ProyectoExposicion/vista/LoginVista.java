package ProyectoExposicion.vista;

import java.util.Scanner;

public class LoginVista {
    private final Scanner scanner;

    public LoginVista() {
        scanner = new Scanner(System.in);
    }

    public String[] mostrarLogin() {
        System.out.println("\n=== SISTEMA DE VACUNACION - INICIO DE SESION ===");
        System.out.print("Usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Contrasena: ");
        String contraseña = scanner.nextLine();
        
        return new String[]{nombreUsuario, contraseña};
    }

    public void mostrarError() {
        System.out.println("Error: Usuario o contrasena incorrectos");
        System.out.println("Por favor, intente nuevamente");
    }

    public void mostrarExito() {
        System.out.println("Inicio de sesion exitoso!");
    }
}