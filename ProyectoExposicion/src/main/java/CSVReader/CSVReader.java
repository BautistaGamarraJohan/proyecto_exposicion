package CSVReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CSVReader {
    private static final int REGISTROS_POR_PAGINA = 15;
    
    public void leerCSV(String nombreArchivo) {
        try {
            Scanner scanner = new Scanner(System.in);
            int totalLineas = contarLineas(nombreArchivo) - 1; // -1 para excluir la cabecera
            int totalPaginas = (int) Math.ceil((double) totalLineas / REGISTROS_POR_PAGINA);
            
            System.out.println("\nTotal de registros: " + totalLineas);
            System.out.println("Total de páginas: " + totalPaginas);
            
            int paginaActual = 1;
            boolean continuar = true;
            
            while (continuar) {
                mostrarPagina(nombreArchivo, paginaActual);
                System.out.println("\nPagina " + paginaActual + " de " + totalPaginas);
                System.out.println("\nOpciones:");
                System.out.println("1. Siguiente pagina");
                System.out.println("2. Página anterior");
                System.out.println("3. Ir a página especifica");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        if (paginaActual < totalPaginas) paginaActual++;
                        break;
                    case 2:
                        if (paginaActual > 1) paginaActual--;
                        break;
                    case 3:
                        System.out.print("Ingrese número de página (1-" + totalPaginas + "): ");
                        int nuevaPagina = scanner.nextInt();
                        if (nuevaPagina >= 1 && nuevaPagina <= totalPaginas) {
                            paginaActual = nuevaPagina;
                        }
                        break;
                    case 4:
                        continuar = false;
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    private int contarLineas(String nombreArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            return (int) br.lines().count();
        }
    }
    
    private void mostrarPagina(String nombreArchivo, int pagina) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            boolean primeraLinea = true;
            int lineasSaltadas = (pagina - 1) * REGISTROS_POR_PAGINA;
            int lineasMostradas = 0;
            
            // Mostrar encabezados
            if ((linea = br.readLine()) != null) {
                String[] encabezados = linea.split(";");
                System.out.println("\n=== REGISTRO DE VACUNACION COVID-19 PERU ===\n");
                mostrarLineaFormateada(encabezados);
                System.out.println("=".repeat(190));
            }
            
            // Saltar líneas hasta la página deseada
            for (int i = 0; i < lineasSaltadas; i++) {
                br.readLine();
            }
            
            // Mostrar líneas de la página actual
            while ((linea = br.readLine()) != null && lineasMostradas < REGISTROS_POR_PAGINA) {
                String[] datos = linea.split(";");
                mostrarLineaFormateada(datos);
                System.out.println("-".repeat(190));
                lineasMostradas++;
            }
        }
    }
    
    private void mostrarLineaFormateada(String[] datos) {
        StringBuilder lineaFormateada = new StringBuilder();
        int[] anchos = {10, 8, 20, 5, 10, 10, 6, 10, 15, 15, 15, 20, 20, 10};
        
        for (int i = 0; i < datos.length && i < anchos.length; i++) {
            String dato = datos[i].trim();
            if (dato.isEmpty()) {
                dato = "-";
            }
            if (dato.length() > anchos[i]) {
                dato = dato.substring(0, anchos[i] - 3) + "...";
            }
            lineaFormateada.append(String.format("%-" + anchos[i] + "s | ", dato));
        }
        System.out.println(lineaFormateada.toString());
    }
}