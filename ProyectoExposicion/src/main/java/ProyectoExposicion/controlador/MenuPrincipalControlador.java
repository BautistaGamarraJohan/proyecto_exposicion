package ProyectoExposicion.controlador;

import ProyectoExposicion.vista.MenuPrincipalVista;
import ProyectoExposicion.vista.ReporteVista;
import ProyectoExposicion.modelo.dao.VacunacionDAO;
import java.util.Map;

public class MenuPrincipalControlador {
    private final MenuPrincipalVista menuVista;
    private final ReporteVista reporteVista;
    private final VacunacionDAO vacunacionDAO;

    public MenuPrincipalControlador() {
        this.menuVista = new MenuPrincipalVista();
        this.reporteVista = new ReporteVista();
        this.vacunacionDAO = new VacunacionDAO("F:\\exposicionlunes\\Proyecto\\vacuna\\vacunas_covid.csv");
    }

    public void iniciarMenu() {
        boolean salir = false;
        
        while (!salir) {
            int opcion = menuVista.mostrarMenuPrincipal();
            
            switch (opcion) {
                case 1:
                    generarPerfilVacunacion();
                    break;
                case 2:
                    generarCoberturaDemografica();
                    break;
                case 3:
                    generarAvanceGeografico();
                    break;
                case 4:
                    generarReporteDosis();
                    break;
                case 5:
                    salir = true;
                    System.out.println("\nCerrando sesion...");
                    break;
                default:
                    menuVista.mostrarMensajeError();
            }
        }
    }

    private void generarPerfilVacunacion() {
        int totalVacunados = vacunacionDAO.getTotalVacunados();
        Map<String, Integer> distribucionGrupos = vacunacionDAO.getDistribucionPorGrupoRiesgo();
        Map<String, Double> porcentajesGrupos = vacunacionDAO.calcularPorcentajes(distribucionGrupos);
        Map<String, Integer> distribucionDiresa = vacunacionDAO.getDistribucionPorDiresa();
        Map<String, Integer> distribucionClasificacion = vacunacionDAO.getDistribucionPorClasificacion();
        Map<String, Integer> distribucionTipoEdad = vacunacionDAO.getDistribucionPorTipoEdad();
        
        reporteVista.mostrarPerfilVacunacion(
            totalVacunados, 
            distribucionGrupos, 
            porcentajesGrupos,
            distribucionDiresa,
            distribucionClasificacion,
            distribucionTipoEdad
        );
    }

    private void generarCoberturaDemografica() {
        Map<String, Integer> distribucionSexo = vacunacionDAO.getCoberturaPorSexo();
        Map<String, Integer> distribucionEdad = vacunacionDAO.getCoberturaPorGruposEdad();
        reporteVista.mostrarCoberturaDemografica(distribucionSexo, distribucionEdad);
    }

    private void generarAvanceGeografico() {
        Map<String, Integer> porDepartamento = vacunacionDAO.getVacunacionPorDepartamento();
        Map<String, Integer> porProvincia = vacunacionDAO.getVacunacionPorProvincia();
        Map<String, Integer> porDistrito = vacunacionDAO.getVacunacionPorDistrito();
        reporteVista.mostrarAvanceGeografico(porDepartamento, porProvincia, porDistrito);
    }

    private void generarReporteDosis() {
        Map<String, Integer> distribucionDosis = vacunacionDAO.getDistribucionPorDosis();
        Map<String, Integer> avanceFecha = vacunacionDAO.getAvancePorFecha();
        Map<String, Integer> distribucionFabricante = vacunacionDAO.getDistribucionPorFabricante();
        reporteVista.mostrarReporteDosis(distribucionDosis, avanceFecha, distribucionFabricante);
    }
}