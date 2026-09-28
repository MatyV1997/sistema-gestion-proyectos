package modelo;

public class Reporte {

    private int idReporte;
    private String fechaGeneracion;
    private String tipo;
    private String descripcion;
    private int idProyecto;

    public Reporte() {
    }

    public Reporte(int idReporte,
            String fechaGeneracion,
            String tipo,
            String descripcion,
            int idProyecto) {

        this.idReporte = idReporte;
        this.fechaGeneracion = fechaGeneracion;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.idProyecto = idProyecto;

    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

}