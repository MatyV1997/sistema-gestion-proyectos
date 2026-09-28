package dao;

import gestionproyectos.ConexionBD;
import modelo.Proyecto;
import java.sql.*;
import java.util.ArrayList;

public class ProyectoDAO {

    Connection con;

    public ProyectoDAO() {

        con = ConexionBD.conectar();

    }

    public boolean insertar(Proyecto p) {

        String sql = "INSERT INTO proyecto(nombre,descripcion,fecha_inicio,fecha_fin,estado) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setString(3, p.getFechaInicio());
            ps.setString(4, p.getFechaFin());
            ps.setString(5, p.getEstado());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

            return false;

        }

    }

    public ArrayList<Proyecto> listar() {

        ArrayList<Proyecto> lista = new ArrayList<>();

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM proyecto");

            while (rs.next()) {

                Proyecto p = new Proyecto();

                p.setIdProyecto(rs.getInt("id_proyecto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setFechaInicio(rs.getString("fecha_inicio"));
                p.setFechaFin(rs.getString("fecha_fin"));
                p.setEstado(rs.getString("estado"));

                lista.add(p);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return lista;

    }
    
    // BUSCAR POR ID

public Proyecto buscar(int id) {

    String sql = "SELECT * FROM proyecto WHERE id_proyecto=?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Proyecto p = new Proyecto();

            p.setIdProyecto(rs.getInt("id_proyecto"));
            p.setNombre(rs.getString("nombre"));
            p.setDescripcion(rs.getString("descripcion"));
            p.setFechaInicio(rs.getString("fecha_inicio"));
            p.setFechaFin(rs.getString("fecha_fin"));
            p.setEstado(rs.getString("estado"));

            return p;

        }

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return null;

}
    // ACTUALIZAR

public boolean actualizar(Proyecto p){

    String sql="UPDATE proyecto SET nombre=?,descripcion=?,fecha_inicio=?,fecha_fin=?,estado=? WHERE id_proyecto=?";

    try{

        PreparedStatement ps=con.prepareStatement(sql);

        ps.setString(1,p.getNombre());
        ps.setString(2,p.getDescripcion());
        ps.setString(3,p.getFechaInicio());
        ps.setString(4,p.getFechaFin());
        ps.setString(5,p.getEstado());
        ps.setInt(6,p.getIdProyecto());

        ps.executeUpdate();

        return true;

    }catch(SQLException e){

        System.out.println(e.getMessage());

        return false;

    }

}

// ELIMINAR

public boolean eliminar(int id){

    String sql="DELETE FROM proyecto WHERE id_proyecto=?";

    try{

        PreparedStatement ps=con.prepareStatement(sql);

        ps.setInt(1,id);

        ps.executeUpdate();

        return true;

    }catch(SQLException e){

        System.out.println(e.getMessage());

        return false;

    }

}

}