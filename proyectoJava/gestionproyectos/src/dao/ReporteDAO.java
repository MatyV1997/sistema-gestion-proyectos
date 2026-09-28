package dao;

import gestionproyectos.ConexionBD;
import modelo.Reporte;
import java.sql.*;
import java.util.ArrayList;

public class ReporteDAO {

    Connection con;

    public ReporteDAO(){

        con=ConexionBD.conectar();

    }

    public boolean insertar(Reporte r){

        String sql="INSERT INTO reporte(fecha_generacion,tipo,descripcion,id_proyecto) VALUES(?,?,?,?)";

        try{

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1,r.getFechaGeneracion());
            ps.setString(2,r.getTipo());
            ps.setString(3,r.getDescripcion());
            ps.setInt(4,r.getIdProyecto());

            ps.executeUpdate();

            return true;

        }catch(SQLException e){

            System.out.println(e.getMessage());

            return false;

        }

    }

    public ArrayList<Reporte> listar(){

        ArrayList<Reporte> lista=new ArrayList<>();

        try{

            Statement st=con.createStatement();

            ResultSet rs=st.executeQuery("SELECT * FROM reporte");

            while(rs.next()){

                Reporte r=new Reporte();

                r.setIdReporte(rs.getInt("id_reporte"));
                r.setFechaGeneracion(rs.getString("fecha_generacion"));
                r.setTipo(rs.getString("tipo"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setIdProyecto(rs.getInt("id_proyecto"));

                lista.add(r);

            }

        }catch(SQLException e){

            System.out.println(e.getMessage());

        }

        return lista;
}
    // BUSCAR

public Reporte buscar(int id){

    String sql = "SELECT * FROM reporte WHERE id_reporte=?";

    try{

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){

            Reporte r = new Reporte();

            r.setIdReporte(rs.getInt("id_reporte"));
            r.setFechaGeneracion(rs.getString("fecha_generacion"));
            r.setTipo(rs.getString("tipo"));
            r.setDescripcion(rs.getString("descripcion"));
            r.setIdProyecto(rs.getInt("id_proyecto"));

            return r;

        }

    }catch(SQLException e){

        System.out.println(e.getMessage());

    }

    return null;

}
  
    // ACTUALIZAR

public boolean actualizar(Reporte r){

    String sql = "UPDATE reporte SET fecha_generacion=?, tipo=?, descripcion=?, id_proyecto=? WHERE id_reporte=?";

    try{

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, r.getFechaGeneracion());
        ps.setString(2, r.getTipo());
        ps.setString(3, r.getDescripcion());
        ps.setInt(4, r.getIdProyecto());
        ps.setInt(5, r.getIdReporte());

        ps.executeUpdate();

        return true;

    }catch(SQLException e){

        System.out.println(e.getMessage());

        return false;

    }

}

    public boolean eliminar(int id){

    String sql="DELETE FROM reporte WHERE id_reporte=?";

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