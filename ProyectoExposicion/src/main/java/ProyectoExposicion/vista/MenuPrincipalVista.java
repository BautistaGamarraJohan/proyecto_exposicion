package ProyectoExposicion.vista;

import java.util.Scanner;

public class MenuPrincipalVista {
    private final Scanner scanner;

    public MenuPrincipalVista() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal() {
        System.out.println("\n=== MENU PRINCIPAL - SISTEMA DE VACUNACION ===");
        System.out.println("1. Perfil de Vacunacion");
        System.out.println("2. Cobertura Demografica");
        System.out.println("3. Avance Geografico");
        System.out.println("4. Reporte de Dosis Aplicadas");
        System.out.println("5. Cerrar Sesion");
        System.out.print("\nSeleccione una opcion: ");
        return scanner.nextInt();
    }

    public void mostrarMensajeError() {
        System.out.println("\nOpción no valida. Por favor, intente nuevamente.");
    }
}