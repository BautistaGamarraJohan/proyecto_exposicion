package ProyectoExposicion.vista;

import java.text.DecimalFormat;
import java.util.*;

public class ReporteVista {
    private static final String LINEA = "--------------------------------------------------";
    private final DecimalFormat formatoNumero = new DecimalFormat("#,###");
    
    public void mostrarPerfilVacunacion(int totalVacunados, 
                                      Map<String, Integer> distribucionGrupos, 
                                      Map<String, Double> porcentajes,
                                      Map<String, Integer> distribucionDiresa,
                                      Map<String, Integer> distribucionClasificacion,
                                      Map<String, Integer> distribucionTipoEdad) {
        System.out.println("\n" + LINEA);
        System.out.println("               PERFIL DE VACUNACION                ");
        System.out.println(LINEA);
        
        System.out.println("\nTotal de Vacunados: " + formatoNumero.format(totalVacunados));
        
        System.out.println("\n" + LINEA);
        System.out.println("          DISTRIBUCION POR GRUPO DE RIESGO          ");
        System.out.println(LINEA + "\n");
        
        for (Map.Entry<String, Integer> entry : distribucionGrupos.entrySet()) {
            String grupo = entry.getKey();
            int cantidad = entry.getValue();
            double porcentaje = porcentajes.get(grupo);
            
            System.out.printf("%-70s: %s personas (%7.2f%%)\n", 
                            grupo, formatoNumero.format(cantidad), porcentaje);
            System.out.println();
        }

        System.out.println("\n" + LINEA);
        System.out.println("             DISTRIBUCION POR DIRESA                ");
        System.out.println(LINEA + "\n");
        
        for (Map.Entry<String, Integer> entry : distribucionDiresa.entrySet()) {
            System.out.printf("%-30s: %s personas\n", 
                            entry.getKey(), formatoNumero.format(entry.getValue()));
            System.out.println();
        }

        System.out.println("\n" + LINEA);
        System.out.println("         DISTRIBUCION POR CLASIFICACIÓN             ");
        System.out.println(LINEA + "\n");
        
        for (Map.Entry<String, Integer> entry : distribucionClasificacion.entrySet()) {
            System.out.printf("%-30s: %s personas\n", 
                            entry.getKey(), formatoNumero.format(entry.getValue()));
            System.out.println();
        }

        System.out.println("\n" + LINEA);
        System.out.println("          DISTRIBUCIÓN POR TIPO DE EDAD            ");
        System.out.println(LINEA + "\n");
        
        for (Map.Entry<String, Integer> entry : distribucionTipoEdad.entrySet()) {
            System.out.printf("%-30s: %s personas\n", 
                            entry.getKey(), formatoNumero.format(entry.getValue()));
            System.out.println();
        }
    }

    public void mostrarCoberturaDemografica(Map<String, Integer> distribucionSexo,
                                          Map<String, Integer> distribucionEdad) {
        System.out.println("\n" + LINEA);
        System.out.println("             COBERTURA DEMOGRAFICA                 ");
        System.out.println(LINEA);
        
        System.out.println("\n" + LINEA);
        System.out.println("            DISTRIBUCION POR SEXO                  ");
        System.out.println(LINEA + "\n");
        
        for (Map.Entry<String, Integer> entry : distribucionSexo.entrySet()) {
            System.out.printf("%-15s: %s personas\n", 
                            entry.getKey(), formatoNumero.format(entry.getValue()));
            System.out.println();
        }

        System.out.println("\n" + LINEA);
        System.out.println("         DISTRIBUCION POR GRUPOS DE EDAD           ");
        System.out.println(LINEA + "\n");
        
        List<Map.Entry<String, Integer>> gruposEdadOrdenados = new ArrayList<>(distribucionEdad.entrySet());
        Collections.sort(gruposEdadOrdenados, (e1, e2) -> {
            try {
                String num1 = e1.getKey().replaceAll("[^0-9].*", "");
                String num2 = e2.getKey().replaceAll("[^0-9].*", "");
                return Integer.parseInt(num1) - Integer.parseInt(num2);
            } catch (NumberFormatException e) {
                return 0;
            }
        });
        
        for (Map.Entry<String, Integer> entry : gruposEdadOrdenados) {
            System.out.printf("%-30s: %s personas\n", 
                            entry.getKey(), formatoNumero.format(entry.getValue()));
            System.out.println();
        }
    }

    public void mostrarAvanceGeografico(Map<String, Integer> porDepartamento,
                                      Map<String, Integer> porProvincia,
                                      Map<String, Integer> porDistrito) {
        System.out.println("\n" + LINEA);
        System.out.println("              AVANCE GEOGRAFICO                    ");
        System.out.println(LINEA);
        
        System.out.println("\n" + LINEA);
        System.out.println("            VACUNACION POR DEPARTAMENTO            ");
        System.out.println(LINEA + "\n");
        
        for (Map.Entry<String, Integer> entry : porDepartamento.entrySet()) {
            System.out.printf("%-30s: %s vacunados\n",
                            entry.getKey(), formatoNumero.format(entry.getValue()));
            System.out.println();
        }
        
        System.out.println("\n" + LINEA);
        System.out.println("            VACUNACION POR PROVINCIA               ");
        System.out.println(LINEA + "\n");
        
        for (Map.Entry<String, Integer> entry : porProvincia.entrySet()) {
            System.out.printf("%-30s: %s vacunados\n",
                            entry.getKey(), formatoNumero.format(entry.getValue()));
            System.out.println();
        }
        
        System.out.println("\n" + LINEA);
        System.out.println("            VACUNACION POR DISTRITO                ");
        System.out.println(LINEA + "\n");
        
        for (Map.Entry<String, Integer> entry : porDistrito.entrySet()) {
            System.out.printf("%-30s: %s vacunados\n",
                            entry.getKey(), formatoNumero.format(entry.getValue()));
            System.out.println();
        }
    }

    public void mostrarReporteDosis(Map<String, Integer> distribucionDosis,
                                  Map<String, Integer> avanceFecha,
                                  Map<String, Integer> distribucionFabricante) {
        System.out.println("\n" + LINEA);
        System.out.println("            REPORTE DE DOSIS APLICADAS             ");
        System.out.println(LINEA);
        
        System.out.println("\nDistribucion por Tipo de Dosis:");
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
            
            System.out.printf("%-25s: %s aplicaciones\n", 
                            nombreDosis, formatoNumero.format(entry.getValue()));
            System.out.println();
        }

        System.out.println("\n" + LINEA);
        System.out.println("          DISTRIBUCION POR FABRICANTE              ");
        System.out.println(LINEA + "\n");
        
        for (Map.Entry<String, Integer> entry : distribucionFabricante.entrySet()) {
            System.out.printf("%-20s: %s aplicaciones\n",
                            entry.getKey(), formatoNumero.format(entry.getValue()));
            System.out.println();
        }

        System.out.println("\n" + LINEA);
        System.out.println("              AVANCE POR FECHA                     ");
        System.out.println(LINEA + "\n");
        
        List<Map.Entry<String, Integer>> fechasOrdenadas = new ArrayList<>(avanceFecha.entrySet());
        Collections.sort(fechasOrdenadas, (e1, e2) -> {
            try {
                int fecha1 = Integer.parseInt(e1.getKey());
                int fecha2 = Integer.parseInt(e2.getKey());
                return Integer.compare(fecha1, fecha2);
            } catch (NumberFormatException e) {
                return 0;
            }
        });
        
        for (Map.Entry<String, Integer> entry : fechasOrdenadas) {
            System.out.printf("%s: %s vacunas aplicadas\n", 
                            entry.getKey(), formatoNumero.format(entry.getValue()));
            System.out.println();
        }
    }
}