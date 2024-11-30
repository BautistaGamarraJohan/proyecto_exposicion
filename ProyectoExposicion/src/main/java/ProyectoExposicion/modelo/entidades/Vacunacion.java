package ProyectoExposicion.modelo.entidades;

public class Vacunacion {
    private final String fechaCorte;
    private final String uuid;
    private final String grupoRiesgo;
    private final String edad;
    private final String sexo;
    private final String fechaVacunacion;
    private final String dosis;
    private final String fabricante;
    private final String diresa;
    private final String departamento;
    private final String provincia;
    private final String distrito;
    private final String clasificacionVacuna;
    private final String tipoEdad;

    public Vacunacion(String[] datos) {
        this.fechaCorte = datos[0];
        this.uuid = datos[1];
        this.grupoRiesgo = datos[2];
        this.edad = datos[3];
        this.sexo = datos[4];
        this.fechaVacunacion = datos[5];
        this.dosis = datos[6];
        this.fabricante = datos[7];
        this.diresa = datos[8];
        this.departamento = datos[9];
        this.provincia = datos[10];
        this.distrito = datos[11];
        this.clasificacionVacuna = datos[12];
        this.tipoEdad = datos[13];
    }

    // Getters existentes
    public String getFechaCorte() { return fechaCorte; }
    public String getGrupoRiesgo() { return grupoRiesgo; }
    public String getEdad() { return edad; }
    public String getSexo() { return sexo; }
    public String getFechaVacunacion() { return fechaVacunacion; }
    public String getDosis() { return dosis; }
    public String getDepartamento() { return departamento; }
    public String getProvincia() { return provincia; }
    public String getDistrito() { return distrito; }
    public String getUuid() { return uuid; }
    public String getDiresa() { return diresa; }
    public String getClasificacionVacuna() { return clasificacionVacuna; }
    public String getTipoEdad() { return tipoEdad; }
    // Agregar este nuevo getter
    public String getFabricante() { return fabricante; }
}