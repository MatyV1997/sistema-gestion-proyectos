package modelo;

public class Incidencia {

    private int idIncidencia;
    private String descripcion;
    private String prioridad;
    private String estado;
    private String fechaRegistro;
    private int idTarea;

    public Incidencia() {
    }

    public Incidencia(int idIncidencia, String descripcion,
            String prioridad, String estado,
            String fechaRegistro, int idTarea) {

        this.idIncidencia = idIncidencia;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.idTarea = idTarea;

    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

}
