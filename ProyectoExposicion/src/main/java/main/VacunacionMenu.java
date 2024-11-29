/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import CSVReader.CSVReader;
import java.util.Scanner;

public class VacunacionMenu {
    private final CSVReader csvReader;
    private final Scanner scanner;
    
    public VacunacionMenu() {
        this.csvReader = new CSVReader();
        this.scanner = new Scanner(System.in);
    }
    
    public void mostrarMenuPrincipal() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== SISTEMA DE REPORTES DE VACUNACIÓN ===");
            System.out.println("1. Reportes Estadísticos");
            System.out.println("2. Reportes Geográficos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> mostrarMenuReportesEstadisticos();
                case 2 -> mostrarMenuReportesGeograficos();
                case 3 -> {
                    salir = true;
                    System.out.println("Gracias por usar el sistema.");
                }
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    
    private void mostrarMenuReportesEstadisticos() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n=== REPORTES ESTADÍSTICOS ===");
            System.out.println("1. Perfil de Vacunación");
            System.out.println("   - Total de vacunados");
            System.out.println("   - Distribución por grupos de riesgo");
            
            System.out.println("\n2. Cobertura Demográfica");
            System.out.println("   - Cobertura por sexo");
            System.out.println("   - Cobertura por edad");
            
            System.out.println("\n3. Reporte de Dosis Aplicadas");
            System.out.println("   - Tipo de dosis");
            System.out.println("   - Avance por fecha");
            
            System.out.println("\n4. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");
            
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> generarReportePerfilVacunacion();
                case 2 -> generarReporteCoberturaDemografica();
                case 3 -> generarReporteDosis();
                case 4 -> volver = true;
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    
    private void mostrarMenuReportesGeograficos() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n=== REPORTES GEOGRÁFICOS ===");
            System.out.println("1. Por Departamento");
            System.out.println("2. Por Provincia");
            System.out.println("3. Por Distrito");
            System.out.println("4. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");
            
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> generarReporteDepartamento();
                case 2 -> generarReporteProvincia();
                case 3 -> generarReporteDistrito();
                case 4 -> volver = true;
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    
    // Métodos para generar los reportes específicos
    private void generarReportePerfilVacunacion() {
        System.out.println("\nGenerando reporte de Perfil de Vacunación...");
        // Aquí iría la lógica para generar el reporte
    }
    
    private void generarReporteCoberturaDemografica() {
        System.out.println("\nGenerando reporte de Cobertura Demográfica...");
        // Aquí iría la lógica para generar el reporte
    }
    
    private void generarReporteDosis() {
        System.out.println("\nGenerando reporte de Dosis Aplicadas...");
        // Aquí iría la lógica para generar el reporte
    }
    
    private void generarReporteDepartamento() {
        System.out.println("\nGenerando reporte por Departamento...");
        // Aquí iría la lógica para generar el reporte
    }
    
    private void generarReporteProvincia() {
        System.out.println("\nGenerando reporte por Provincia...");
        // Aquí iría la lógica para generar el reporte
    }
    
    private void generarReporteDistrito() {
        System.out.println("\nGenerando reporte por Distrito...");
        // Aquí iría la lógica para generar el reporte
    }
}

