package dao;

import gestionproyectos.ConexionBD;
import dao.IncidenciaDAO;
import modelo.Incidencia;
import java.sql.*;
import java.util.ArrayList;

public class IncidenciaDAO {

    Connection con;

    public IncidenciaDAO(){

        con=ConexionBD.conectar();

    }

    public boolean insertar(Incidencia i){

        String sql="INSERT INTO incidencia(descripcion,prioridad,estado,fecha_registro,id_tarea) VALUES(?,?,?,?,?)";

        try{

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1,i.getDescripcion());
            ps.setString(2,i.getPrioridad());
            ps.setString(3,i.getEstado());
            ps.setString(4,i.getFechaRegistro());
            ps.setInt(5,i.getIdTarea());

            ps.executeUpdate();

            return true;

        }catch(SQLException e){

            System.out.println(e.getMessage());

            return false;

        }

    }

    public ArrayList<Incidencia> listar(){

        ArrayList<Incidencia> lista=new ArrayList<>();

        try{

            Statement st=con.createStatement();

            ResultSet rs=st.executeQuery("SELECT * FROM incidencia");

            while(rs.next()){

                Incidencia i=new Incidencia();

                i.setIdIncidencia(rs.getInt("id_incidencia"));
                i.setDescripcion(rs.getString("descripcion"));
                i.setPrioridad(rs.getString("prioridad"));
                i.setEstado(rs.getString("estado"));
                i.setFechaRegistro(rs.getString("fecha_registro"));
                i.setIdTarea(rs.getInt("id_tarea"));

                lista.add(i);

            }

        }catch(SQLException e){

            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    // BUSCAR

public Incidencia buscar(int id){

    String sql="SELECT * FROM incidencia WHERE id_incidencia=?";

    try{

        PreparedStatement ps=con.prepareStatement(sql);

        ps.setInt(1,id);

        ResultSet rs=ps.executeQuery();

        if(rs.next()){

            Incidencia i=new Incidencia();

            i.setIdIncidencia(rs.getInt("id_incidencia"));
            i.setDescripcion(rs.getString("descripcion"));
            i.setPrioridad(rs.getString("prioridad"));
            i.setEstado(rs.getString("estado"));
            i.setFechaRegistro(rs.getString("fecha_registro"));
            i.setIdTarea(rs.getInt("id_tarea"));

            return i;

        }

    }catch(SQLException e){

        System.out.println(e.getMessage());

    }

    return null;
}

    // ACTUALIZAR

public boolean actualizar(Incidencia i){

    String sql="UPDATE incidencia SET descripcion=?, prioridad=?, estado=?, fecha_registro=?, id_tarea=? WHERE id_incidencia=?";

    try{

        PreparedStatement ps=con.prepareStatement(sql);

        ps.setString(1,i.getDescripcion());
        ps.setString(2,i.getPrioridad());
        ps.setString(3,i.getEstado());
        ps.setString(4,i.getFechaRegistro());
        ps.setInt(5,i.getIdTarea());
        ps.setInt(6,i.getIdIncidencia());

        ps.executeUpdate();

        return true;

    }catch(SQLException e){

        System.out.println(e.getMessage());

        return false;

    }

}

    public boolean eliminar(int id){

    String sql="DELETE FROM incidencia WHERE id_incidencia=?";

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