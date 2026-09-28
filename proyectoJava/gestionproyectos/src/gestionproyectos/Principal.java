package gestionproyectos;

import dao.UsuarioDAO;
import modelo.Usuario;

public class Principal {

    public static void main(String[] args) {
        // Prueba la conexión con la base de datos
        ConexionBD.conectar();
        Usuario usuario = new Usuario();

            usuario.setNombre("Matias");
            usuario.setApellido("Vanella");
            usuario.setCorreo("matias@gmail.com");
            usuario.setContraseña("1234");
            usuario.setRol("Administrador");

            UsuarioDAO dao = new UsuarioDAO();

dao.insertar(usuario);

        Menu menu = new Menu();

        menu.iniciar();

    }

}
