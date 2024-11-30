package ProyectoExposicion.vista;

import java.util.Scanner;

public class LoginVista {
    private final Scanner scanner;

    public LoginVista() {
        scanner = new Scanner(System.in);
    }

    public String[] mostrarLogin() {
        System.out.println("\n=== SISTEMA DE VACUNACIÓN - INICIO DE SESIÓN ===");
        System.out.print("Usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();
        
        return new String[]{nombreUsuario, contraseña};
    }

    public void mostrarError() {
        System.out.println("Error: Usuario o contraseña incorrectos");
        System.out.println("Por favor, intente nuevamente");
    }

    public void mostrarExito() {
        System.out.println("¡Inicio de sesión exitoso!");
    }
}