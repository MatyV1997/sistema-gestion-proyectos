package util;

import modelo.Proyecto;
import java.util.ArrayList;

public class Ordenamiento {

    public static void ordenar(ArrayList<Proyecto> lista){

        for(int i=0;i<lista.size()-1;i++){

            for(int j=0;j<lista.size()-i-1;j++){

                if(lista.get(j).getNombre().compareToIgnoreCase(lista.get(j+1).getNombre())>0){

                    Proyecto aux=lista.get(j);

                    lista.set(j, lista.get(j+1));

                    lista.set(j+1, aux);

                }

            }

        }

    }

}