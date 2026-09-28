package dao;

import gestionproyectos.ConexionBD;
import modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // INSERTAR
    public boolean insertar(Usuario usuario) {

        String sql = "INSERT INTO usuario(nombre, apellido, correo, contrasena, rol) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getContraseña());
            ps.setString(5, usuario.getRol());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al insertar usuario: " + e.getMessage());
            return false;

        }
    }

    // LISTAR
    public List<Usuario> listar() {

        List<Usuario> lista = new ArrayList<>();

        String sql = "SELECT * FROM usuario";

        try (Connection con = ConexionBD.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Usuario u = new Usuario();

                u.setId(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setCorreo(rs.getString("correo"));
                u.setContraseña(rs.getString("contraseña"));
                u.setRol(rs.getString("rol"));

                lista.add(u);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return lista;

    }

    // BUSCAR
    public Usuario buscar(int id) {

        String sql = "SELECT * FROM usuario WHERE id_usuario=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Usuario u = new Usuario();

                u.setId(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setCorreo(rs.getString("correo"));
                u.setContraseña(rs.getString("contraseña"));
                u.setRol(rs.getString("rol"));

                return u;

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return null;

    }

    // MODIFICAR
    public boolean actualizar(Usuario usuario) {

        String sql = "UPDATE usuario SET nombre=?, apellido=?, correo=?, contraseña=?, rol=? WHERE id_usuario=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getContraseña());
            ps.setString(5, usuario.getRol());
            ps.setInt(6, usuario.getId());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

            return false;

        }

    }

    // ELIMINAR
    public boolean eliminar(int id) {

        String sql = "DELETE FROM usuario WHERE id_usuario=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

            return false;

        }

    }

}