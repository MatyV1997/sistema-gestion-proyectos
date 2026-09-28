package dao;

import gestionproyectos.ConexionBD;
import modelo.Tarea;
import java.sql.*;
import java.util.ArrayList;

public class TareaDAO {

    Connection con;

    public TareaDAO() {
        con = ConexionBD.conectar();
    }

    public boolean insertar(Tarea t){

        String sql="INSERT INTO tarea(titulo,descripcion,prioridad,estado) VALUES(?,?,?,?)";

        try{

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1,t.getTitulo());
            ps.setString(2,t.getDescripcion());
            ps.setString(3,t.getPrioridad());
            ps.setString(4,t.getEstado());

            ps.executeUpdate();

            return true;

        }catch(SQLException e){

            System.out.println(e.getMessage());

            return false;

        }

    }

    public ArrayList<Tarea> listar(){

        ArrayList<Tarea> lista=new ArrayList<>();

        try{

            Statement st=con.createStatement();

            ResultSet rs=st.executeQuery("SELECT * FROM tarea");

            while(rs.next()){

                Tarea t=new Tarea();

                t.setIdTarea(rs.getInt("id_tarea"));
                t.setTitulo(rs.getString("titulo"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setPrioridad(rs.getString("prioridad"));
                t.setEstado(rs.getString("estado"));

                lista.add(t);

            }

        }catch(SQLException e){

            System.out.println(e.getMessage());

        }

        return lista;
    }
    
    // BUSCAR

public Tarea buscar(int id) {

    String sql = "SELECT * FROM tarea WHERE id_tarea=?";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Tarea t = new Tarea();

            t.setIdTarea(rs.getInt("id_tarea"));
            t.setTitulo(rs.getString("titulo"));
            t.setDescripcion(rs.getString("descripcion"));
            t.setPrioridad(rs.getString("prioridad"));
            t.setEstado(rs.getString("estado"));

            return t;

        }

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return null;

}
    
    public boolean actualizar(Tarea t){

    String sql="UPDATE tarea SET titulo=?,descripcion=?,prioridad=?,estado=? WHERE id_tarea=?";

    try{

        PreparedStatement ps=con.prepareStatement(sql);

        ps.setString(1,t.getTitulo());
        ps.setString(2,t.getDescripcion());
        ps.setString(3,t.getPrioridad());
        ps.setString(4,t.getEstado());
        ps.setInt(5,t.getIdTarea());

        ps.executeUpdate();

        return true;

    }catch(SQLException e){

        System.out.println(e.getMessage());

        return false;

    }

}

public boolean eliminar(int id){

    String sql="DELETE FROM tarea WHERE id_tarea=?";

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