package ProyectoExposicion.vista;

import java.util.*;

public class ReporteVista {
    
    public void mostrarPerfilVacunacion(int totalVacunados, 
                                      Map<String, Integer> distribucion, 
                                      Map<String, Double> porcentajes) {
    System.out.println("\n=== PERFIL DE VACUNACIÓN ===");
    System.out.printf("Total de Vacunados: %,d\n\n", totalVacunados);
    
    System.out.println("Distribución por Grupo de Riesgo:");
    System.out.println("--------------------------------");
    
    // Convertir los datos a una lista de entradas
    List<Map.Entry<String, Integer>> distribucionOrdenada = new ArrayList<>(distribucion.entrySet());
    
    // Ordenar la lista por la clave (nombre del grupo)
    distribucionOrdenada.sort(Map.Entry.comparingByKey());
    
    for (Map.Entry<String, Integer> entry : distribucionOrdenada) {
        String grupo = entry.getKey();
        int cantidad = entry.getValue();
        double porcentaje = porcentajes.get(grupo);
        
        // Imprimir los datos con formato alineado
        System.out.printf("%-70s: %7d personas (%6.2f%%)\n", 
                         grupo, cantidad, porcentaje);
    }
}

    public void mostrarCoberturaDemografica(Map<String, Integer> distribucionSexo,
                                          Map<String, Integer> distribucionEdad) {
        System.out.println("\n=== COBERTURA DEMOGRÁFICA ===");
        
        System.out.println("\nDistribución por Sexo:");
        System.out.println("----------------------");
        for (Map.Entry<String, Integer> entry : distribucionSexo.entrySet()) {
            System.out.printf("%s: %d personas\n", entry.getKey(), entry.getValue());
        }

        System.out.println("\nDistribución por Grupos de Edad:");
        System.out.println("------------------------------");
        for (Map.Entry<String, Integer> entry : distribucionEdad.entrySet()) {
            System.out.printf("%s: %d personas\n", entry.getKey(), entry.getValue());
        }
    }

    public void mostrarAvanceGeografico(Map<String, Integer> porDepartamento,
                                      Map<String, Integer> porProvincia,
                                      Map<String, Integer> porDistrito) {
        System.out.println("\n=== AVANCE GEOGRÁFICO ===");
        
        System.out.println("\nPor Departamento:");
        System.out.println("----------------");
        for (Map.Entry<String, Integer> entry : porDepartamento.entrySet()) {
            System.out.printf("%s: %d vacunados\n", entry.getKey(), entry.getValue());
        }
        
        System.out.println("\nPor Provincia:");
        System.out.println("-------------");
        for (Map.Entry<String, Integer> entry : porProvincia.entrySet()) {
            System.out.printf("%s: %d vacunados\n", entry.getKey(), entry.getValue());
        }
        
        System.out.println("\nPor Distrito:");
        System.out.println("------------");
        for (Map.Entry<String, Integer> entry : porDistrito.entrySet()) {
            System.out.printf("%s: %d vacunados\n", entry.getKey(), entry.getValue());
        }
    }

    public void mostrarReporteDosis(Map<String, Integer> distribucionDosis,
                                  Map<String, Integer> avanceFecha) {
        System.out.println("\n=== REPORTE DE DOSIS APLICADAS ===");
        
        System.out.println("\nDistribución por Tipo de Dosis:");
        System.out.println("------------------------------");
        for (Map.Entry<String, Integer> entry : distribucionDosis.entrySet()) {
            String nombreDosis;
            switch (entry.getKey()) {
                case "1" -> nombreDosis = "Primera Dosis";
                case "2" -> nombreDosis = "Segunda Dosis";
                case "3" -> nombreDosis = "Tercera Dosis";
                case "4" -> nombreDosis = "Primera Dosis de Refuerzo";
                case "5" -> nombreDosis = "Segunda Dosis de Refuerzo";
                case "6" -> nombreDosis = "Tercera Dosis de Refuerzo";
                default -> nombreDosis = "Dosis " + entry.getKey();
            }
            
            System.out.printf("%-25s: %d aplicaciones\n", 
                            nombreDosis, entry.getValue());
        }

        System.out.println("\nAvance por Fecha:");
        System.out.println("----------------");
        
        // Convertir el Map a una lista para ordenar las fechas
        List<Map.Entry<String, Integer>> fechasOrdenadas = new ArrayList<>(avanceFecha.entrySet());
        
        // Ordenar las fechas como números (ya que son valores numéricos)
        Collections.sort(fechasOrdenadas, (e1, e2) -> {
            try {
                int fecha1 = Integer.parseInt(e1.getKey());
                int fecha2 = Integer.parseInt(e2.getKey());
                return Integer.compare(fecha1, fecha2);
            } catch (NumberFormatException e) {
                return 0; // En caso de error, mantener el orden original
            }
        });
        
        // Mostrar las fechas ordenadas
        for (Map.Entry<String, Integer> entry : fechasOrdenadas) {
            System.out.printf("%s: %d vacunas aplicadas\n", 
                            entry.getKey(), entry.getValue());
        }
    }
}