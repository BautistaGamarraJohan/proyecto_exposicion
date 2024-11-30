package ProyectoExposicion.modelo.dao;

import ProyectoExposicion.modelo.entidades.Vacunacion;
import java.io.*;
import java.util.*;

public class VacunacionDAO {
    private final List<Vacunacion> vacunaciones;
    private final String rutaArchivo;

    public VacunacionDAO(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.vacunaciones = new ArrayList<>();
        cargarDatos();
    }

    private void cargarDatos() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Saltar la cabecera
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                vacunaciones.add(new Vacunacion(datos));
            }
        } catch (IOException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
        }
    }

    // Métodos para el Perfil de Vacunación
    public int getTotalVacunados() {
        return vacunaciones.size();
    }

    public Map<String, Integer> getDistribucionPorGrupoRiesgo() {
        Map<String, Integer> distribucion = new HashMap<>();
        for (Vacunacion v : vacunaciones) {
            distribucion.merge(v.getGrupoRiesgo(), 1, Integer::sum);
        }
        return distribucion;
    }

    public Map<String, Integer> getCoberturaPorSexo() {
        Map<String, Integer> distribucion = new HashMap<>();
        for (Vacunacion v : vacunaciones) {
            distribucion.merge(v.getSexo(), 1, Integer::sum);
        }
        return distribucion;
    }

    public Map<String, Integer> getCoberturaPorGruposEdad() {
        Map<String, Integer> distribucion = new HashMap<>();
        for (Vacunacion v : vacunaciones) {
            distribucion.merge(v.getEdad(), 1, Integer::sum);
        }
        return distribucion;
    }
    
    public Map<String, Integer> getVacunacionPorDepartamento() {
        Map<String, Integer> distribucion = new HashMap<>();
        for (Vacunacion v : vacunaciones) {
            distribucion.merge(v.getDepartamento(), 1, Integer::sum);
        }
        return distribucion;
    }

    public Map<String, Integer> getVacunacionPorProvincia() {
        Map<String, Integer> distribucion = new HashMap<>();
        for (Vacunacion v : vacunaciones) {
            distribucion.merge(v.getProvincia(), 1, Integer::sum);
        }
        return distribucion;
    }

    public Map<String, Integer> getVacunacionPorDistrito() {
        Map<String, Integer> distribucion = new HashMap<>();
        for (Vacunacion v : vacunaciones) {
            distribucion.merge(v.getDistrito(), 1, Integer::sum);
        }
        return distribucion;
    }

    public Map<String, Integer> getDistribucionPorDosis() {
        Map<String, Integer> distribucion = new HashMap<>();
        for (Vacunacion v : vacunaciones) {
            distribucion.merge(v.getDosis(), 1, Integer::sum);
        }
        return distribucion;
    }

    public Map<String, Integer> getAvancePorFecha() {
        Map<String, Integer> distribucion = new TreeMap<>();
        for (Vacunacion v : vacunaciones) {
            distribucion.merge(v.getFechaVacunacion(), 1, Integer::sum);
        }
        return distribucion;
    }

    public Map<String, Double> calcularPorcentajes(Map<String, Integer> datos) {
        Map<String, Double> porcentajes = new HashMap<>();
        int total = datos.values().stream().mapToInt(Integer::intValue).sum();
        
        for (Map.Entry<String, Integer> entry : datos.entrySet()) {
            double porcentaje = (entry.getValue() * 100.0) / total;
            porcentajes.put(entry.getKey(), porcentaje);  // Usamos getKey() en lugar de getValue()
        }
        
        return porcentajes;
    }
    public Map<String, Integer> getDistribucionPorFabricante() {
        Map<String, Integer> distribucion = new HashMap<>();
        for (Vacunacion v : vacunaciones) {
            distribucion.merge(v.getFabricante(), 1, Integer::sum);
        }
        return distribucion;
    }
    
    public Map<String, Integer> getDistribucionPorDiresa() {
        Map<String, Integer> distribucion = new HashMap<>();
        for (Vacunacion v : vacunaciones) {
            distribucion.merge(v.getDiresa(), 1, Integer::sum);
        }
        return distribucion;
    }

    public Map<String, Integer> getDistribucionPorClasificacion() {
        Map<String, Integer> distribucion = new HashMap<>();
        for (Vacunacion v : vacunaciones) {
            distribucion.merge(v.getClasificacionVacuna(), 1, Integer::sum);
        }
        return distribucion;
    }

    public Map<String, Integer> getDistribucionPorTipoEdad() {
        Map<String, Integer> distribucion = new HashMap<>();
        for (Vacunacion v : vacunaciones) {
            distribucion.merge(v.getTipoEdad(), 1, Integer::sum);
        }
        return distribucion;
    }
}