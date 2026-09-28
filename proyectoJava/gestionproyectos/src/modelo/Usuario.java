package modelo;

public class Usuario extends Persona {

    private String contraseña;
    private String rol;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, String correo,
            String contraseña, String rol) {

        super(id, nombre, apellido, correo);

        this.contraseña = contraseña;
        this.rol = rol;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("Usuario: " + nombre + " " + apellido);

    }

}