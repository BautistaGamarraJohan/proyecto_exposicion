package ProyectoExposicion.vista;

import java.util.Scanner;

public class MenuPrincipalVista {
    private final Scanner scanner;

    public MenuPrincipalVista() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal() {
        System.out.println("\n=== MENÚ PRINCIPAL - SISTEMA DE VACUNACIÓN ===");
        System.out.println("1. Perfil de Vacunación");
        System.out.println("2. Cobertura Demográfica");
        System.out.println("3. Avance Geográfico");
        System.out.println("4. Reporte de Dosis Aplicadas");
        System.out.println("5. Cerrar Sesión");
        System.out.print("\nSeleccione una opción: ");
        return scanner.nextInt();
    }

    public void mostrarMensajeError() {
        System.out.println("\nOpción no válida. Por favor, intente nuevamente.");
    }
}