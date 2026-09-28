package util;

import modelo.Proyecto;
import java.util.ArrayList;

public class Busqueda {

    public static Proyecto buscarProyecto(ArrayList<Proyecto> lista, int id){

        for(Proyecto p : lista){

            if(p.getIdProyecto()==id){

                return p;

            }

        }

        return null;

    }

}