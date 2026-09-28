package gestionproyectos;

import dao.ProyectoDAO;
import dao.ReporteDAO;
import dao.TareaDAO;
import dao.UsuarioDAO;
import dao.IncidenciaDAO;
import java.util.Scanner;
import java.util.ArrayList;
import modelo.Incidencia;
import modelo.Proyecto;
import modelo.Reporte;
import modelo.Tarea;
import modelo.Usuario;

public class Menu {

    Scanner sc = new Scanner(System.in);
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private ProyectoDAO proyectoDAO = new ProyectoDAO();
    private TareaDAO tareaDAO = new TareaDAO();
    private IncidenciaDAO incidenciaDAO = new IncidenciaDAO();
    private ReporteDAO reporteDAO = new ReporteDAO();
    
    public void iniciar() {

        int opcion = 0;

        do {

            try {

                System.out.println("\n==============================================");
                System.out.println(" SISTEMA DE GESTIÓN DE PROYECTOS");
                System.out.println("==============================================");
                System.out.println("1. Gestión de Usuarios");
                System.out.println("2. Gestión de Proyectos");
                System.out.println("3. Gestión de Tareas");
                System.out.println("4. Gestión de Incidencias");
                System.out.println("5. Gestión de Reportes");
                System.out.println("6. Buscar Proyecto");
                System.out.println("7. Ordenar Proyectos");
                System.out.println("8. Estadísticas");
                System.out.println("9. Acerca del Sistema");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:
                        menuUsuarios();
                        break;

                    case 2:
                        menuProyectos();
                        break;

                    case 3:
                        menuTareas();
                        break;

                    case 4:
                        menuIncidencias();
                        break;

                    case 5:
                        menuReportes();
                        break;

                    case 6:
                        buscarProyecto();
                        break;

                    case 7:
                        ordenarProyectos();
                        break;

                    case 8:
                        mostrarEstadisticas();
                        break;

                    case 9:
                        acercaDelSistema();
                        break;

                    case 0:
                        System.out.println("Gracias por utilizar el sistema.");
                        break;

                    default:
                        System.out.println("Opción inválida.");

                }

            } catch (NumberFormatException e) {

                System.out.println("Debe ingresar un número.");

            }

        } while (opcion != 0);

    }

    //================== USUARIOS ==================

    private void menuUsuarios() {

    int op = -1;

    do {

        try {

            System.out.println("\n========== GESTIÓN DE USUARIOS ==========");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Modificar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Buscar usuario");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {

                case 1 -> registrarUsuario();
                case 2 -> listarUsuarios();
                case 3 -> modificarUsuario();
                case 4 -> eliminarUsuario();
                case 5 -> buscarUsuario();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");

            }

        } catch (NumberFormatException e) {

            System.out.println("Debe ingresar un número.");

        }

    } while (op != 0);

}
    //================== PROYECTOS ==================

    private void menuProyectos() {

        int op;

        do {

            System.out.println("\n----- GESTIÓN DE PROYECTOS -----");
            System.out.println("1. Registrar proyecto");
            System.out.println("2. Listar proyectos");
            System.out.println("3. Modificar proyecto");
            System.out.println("4. Eliminar proyecto");
            System.out.println("5. Buscar proyecto");
            System.out.println("0. Volver");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {

                case 1:
                    registrarProyecto();
                    break;

                case 2:
                    listarProyectos();
                    break;

                case 3:
                    modificarProyecto();
                    break;

                case 4:
                    eliminarProyecto();
                    break;

                case 5:
                    buscarProyecto();
                    break;

            }

        } while (op != 0);

    }

    //================== TAREAS ==================

    private void menuTareas() {

        int op;

        do {

            System.out.println("\n----- GESTIÓN DE TAREAS -----");
            System.out.println("1. Registrar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Modificar tarea");
            System.out.println("4. Eliminar tarea");
            System.out.println("0. Volver");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {

                case 1:
                    registrarTarea();
                    break;

                case 2:
                    listarTareas();
                    break;

                case 3:
                    modificarTarea();
                    break;

                case 4:
                    eliminarTarea();
                    break;

            }

        } while (op != 0);

    }

    //================== INCIDENCIAS ==================

    private void menuIncidencias() {

    int op;

    do {

        System.out.println("\n----- GESTIÓN DE INCIDENCIAS -----");
        System.out.println("1. Registrar incidencia");
        System.out.println("2. Listar incidencias");
        System.out.println("3. Modificar incidencia");
        System.out.println("4. Eliminar incidencia");
        System.out.println("5. Buscar incidencia");
        System.out.println("0. Volver");

        op = Integer.parseInt(sc.nextLine());

        switch (op) {

            case 1:
                registrarIncidencia();
                break;

            case 2:
                listarIncidencias();
                break;

            case 3:
                modificarIncidencia();
                break;

            case 4:
                eliminarIncidencia();
                break;

            case 5:
                buscarIncidencia();
                break;

        }

    } while (op != 0);

}

    //================== REPORTES ==================

private void menuReportes() {

    int op;

    do {

        System.out.println("\n----- GESTIÓN DE REPORTES -----");
        System.out.println("1. Registrar reporte");
        System.out.println("2. Listar reportes");
        System.out.println("3. Modificar reporte");
        System.out.println("4. Eliminar reporte");
        System.out.println("5. Buscar reporte");
        System.out.println("0. Volver");

        op = Integer.parseInt(sc.nextLine());

        switch (op) {

            case 1:
                registrarReporte();
                break;

            case 2:
                listarReportes();
                break;

            case 3:
                modificarReporte();
                break;

            case 4:
                eliminarReporte();
                break;

            case 5:
                buscarReporte();
                break;

        }

    } while (op != 0);

}
    //================== MÉTODOS ==================

    private void registrarUsuario() {

    Usuario usuario = new Usuario();

    System.out.print("Nombre: ");
    usuario.setNombre(sc.nextLine());

    System.out.print("Apellido: ");
    usuario.setApellido(sc.nextLine());

    System.out.print("Correo: ");
    usuario.setCorreo(sc.nextLine());

    System.out.print("Contraseña: ");
    usuario.setContraseña(sc.nextLine());

    System.out.print("Rol: ");
    usuario.setRol(sc.nextLine());

    if (usuarioDAO.insertar(usuario)) {
        System.out.println("\nUsuario registrado correctamente.");
    } else {
        System.out.println("\nError al registrar usuario.");
    }
}
    
    private void listarUsuarios() {

    for (Usuario u : usuarioDAO.listar()) {

        System.out.println("--------------------------------");
        System.out.println("ID: " + u.getId());
        System.out.println("Nombre: " + u.getNombre());
        System.out.println("Apellido: " + u.getApellido());
        System.out.println("Correo: " + u.getCorreo());
        System.out.println("Rol: " + u.getRol());

    }

}
    private void buscarUsuario() {

    System.out.print("\nIngrese ID del usuario: ");

    int id = Integer.parseInt(sc.nextLine());

    Usuario usuario = usuarioDAO.buscar(id);

    if (usuario == null) {

        System.out.println("Usuario no encontrado.");

        return;

    }

    System.out.println("--------------------------------");

    System.out.println("ID: " + usuario.getId());
    System.out.println("Nombre: " + usuario.getNombre());
    System.out.println("Apellido: " + usuario.getApellido());
    System.out.println("Correo: " + usuario.getCorreo());
    System.out.println("Rol: " + usuario.getRol());

}
    
    private void eliminarUsuario() {

    System.out.print("\nIngrese el ID del usuario: ");

    int id = Integer.parseInt(sc.nextLine());

    if (usuarioDAO.eliminar(id)) {

        System.out.println("Usuario eliminado correctamente.");

    } else {

        System.out.println("No se pudo eliminar.");

    }

}
    
    private void modificarUsuario() {

    System.out.print("\nIngrese el ID del usuario a modificar: ");

    int id = Integer.parseInt(sc.nextLine());

    Usuario usuario = usuarioDAO.buscar(id);

    if (usuario == null) {

        System.out.println("Usuario no encontrado.");

        return;

    }

    System.out.println("Nuevo nombre:");
    usuario.setNombre(sc.nextLine());

    System.out.println("Nuevo apellido:");
    usuario.setApellido(sc.nextLine());

    System.out.println("Nuevo correo:");
    usuario.setCorreo(sc.nextLine());

    System.out.println("Nueva contraseña:");
    usuario.setContraseña(sc.nextLine());

    System.out.println("Nuevo rol:");
    usuario.setRol(sc.nextLine());

    if (usuarioDAO.actualizar(usuario)) {

        System.out.println("Usuario actualizado correctamente.");

    } else {

        System.out.println("Error al actualizar.");

    }

}
    
    private void registrarProyecto() {

    Proyecto p = new Proyecto();

    System.out.println("\n===== REGISTRAR PROYECTO =====");

    System.out.print("Nombre: ");
    p.setNombre(sc.nextLine());

    System.out.print("Descripción: ");
    p.setDescripcion(sc.nextLine());

    System.out.print("Fecha de inicio (AAAA-MM-DD): ");
    p.setFechaInicio(sc.nextLine());

    System.out.print("Fecha de fin (AAAA-MM-DD): ");
    p.setFechaFin(sc.nextLine());

    System.out.print("Estado: ");
    p.setEstado(sc.nextLine());

    if (proyectoDAO.insertar(p)) {

        System.out.println("\nProyecto registrado correctamente.");

    } else {

        System.out.println("\nError al registrar proyecto.");

    }

}    
    
    private void listarProyectos() {

    ArrayList<Proyecto> lista = proyectoDAO.listar();

    if (lista.isEmpty()) {

        System.out.println("\nNo existen proyectos registrados.");

        return;

    }

    System.out.println("\n========== LISTA DE PROYECTOS ==========");

    for (Proyecto p : lista) {

        System.out.println("----------------------------------------");
        System.out.println("ID: " + p.getIdProyecto());
        System.out.println("Nombre: " + p.getNombre());
        System.out.println("Descripción: " + p.getDescripcion());
        System.out.println("Fecha Inicio: " + p.getFechaInicio());
        System.out.println("Fecha Fin: " + p.getFechaFin());
        System.out.println("Estado: " + p.getEstado());

    }

}
    
    private void buscarProyecto() {

    System.out.print("\nIngrese el ID del proyecto: ");

    int id = Integer.parseInt(sc.nextLine());

    Proyecto p = proyectoDAO.buscar(id);

    if (p == null) {

        System.out.println("Proyecto no encontrado.");

        return;

    }

    System.out.println("\n========== PROYECTO ==========");

    System.out.println("ID: " + p.getIdProyecto());
    System.out.println("Nombre: " + p.getNombre());
    System.out.println("Descripción: " + p.getDescripcion());
    System.out.println("Fecha Inicio: " + p.getFechaInicio());
    System.out.println("Fecha Fin: " + p.getFechaFin());
    System.out.println("Estado: " + p.getEstado());

}
    
    private void modificarProyecto() {

    System.out.print("\nIngrese el ID del proyecto a modificar: ");

    int id = Integer.parseInt(sc.nextLine());

    Proyecto p = proyectoDAO.buscar(id);

    if (p == null) {

        System.out.println("Proyecto no encontrado.");

        return;

    }

    System.out.print("Nuevo nombre: ");
    p.setNombre(sc.nextLine());

    System.out.print("Nueva descripción: ");
    p.setDescripcion(sc.nextLine());

    System.out.print("Nueva fecha de inicio (AAAA-MM-DD): ");
    p.setFechaInicio(sc.nextLine());

    System.out.print("Nueva fecha de fin (AAAA-MM-DD): ");
    p.setFechaFin(sc.nextLine());

    System.out.print("Nuevo estado: ");
    p.setEstado(sc.nextLine());

    if (proyectoDAO.actualizar(p)) {

        System.out.println("Proyecto actualizado correctamente.");

    } else {

        System.out.println("Error al actualizar el proyecto.");

    }

}
    
    private void eliminarProyecto() {

    System.out.print("\nIngrese el ID del proyecto a eliminar: ");

    int id = Integer.parseInt(sc.nextLine());

    System.out.print("¿Está seguro? (S/N): ");

    String respuesta = sc.nextLine();

    if (respuesta.equalsIgnoreCase("S")) {

        if (proyectoDAO.eliminar(id)) {

            System.out.println("Proyecto eliminado correctamente.");

        } else {

            System.out.println("Error al eliminar el proyecto.");

        }

    } else {

        System.out.println("Operación cancelada.");

    }

}
   
    private void registrarTarea() {

    Tarea t = new Tarea();

    System.out.println("\n===== REGISTRAR TAREA =====");

    System.out.print("Título: ");
    t.setTitulo(sc.nextLine());

    System.out.print("Descripción: ");
    t.setDescripcion(sc.nextLine());

    System.out.print("Prioridad: ");
    t.setPrioridad(sc.nextLine());

    System.out.print("Estado: ");
    t.setEstado(sc.nextLine());

    if (tareaDAO.insertar(t)) {

        System.out.println("\nTarea registrada correctamente.");

    } else {

        System.out.println("\nError al registrar la tarea.");

    }

}
       
    private void listarTareas() {

    ArrayList<Tarea> lista = tareaDAO.listar();

    if (lista.isEmpty()) {

        System.out.println("\nNo hay tareas registradas.");

        return;

    }

    System.out.println("\n========== LISTA DE TAREAS ==========");

    for (Tarea t : lista) {

        System.out.println("-----------------------------------");
        System.out.println("ID: " + t.getIdTarea());
        System.out.println("Título: " + t.getTitulo());
        System.out.println("Descripción: " + t.getDescripcion());
        System.out.println("Prioridad: " + t.getPrioridad());
        System.out.println("Estado: " + t.getEstado());

    }

}
    
    private void modificarTarea() {

    System.out.print("\nIngrese el ID de la tarea: ");

    int id = Integer.parseInt(sc.nextLine());

    Tarea t = tareaDAO.buscar(id);

    if (t == null) {

        System.out.println("Tarea no encontrada.");

        return;

    }

    System.out.print("Nuevo título: ");
    t.setTitulo(sc.nextLine());

    System.out.print("Nueva descripción: ");
    t.setDescripcion(sc.nextLine());

    System.out.print("Nueva prioridad: ");
    t.setPrioridad(sc.nextLine());

    System.out.print("Nuevo estado: ");
    t.setEstado(sc.nextLine());

    if (tareaDAO.actualizar(t)) {

        System.out.println("Tarea actualizada correctamente.");

    } else {

        System.out.println("Error al actualizar.");

    }

}
    
    private void eliminarTarea() {

    System.out.print("\nIngrese el ID de la tarea: ");

    int id = Integer.parseInt(sc.nextLine());

    System.out.print("¿Está seguro? (S/N): ");

    String respuesta = sc.nextLine();

    if (respuesta.equalsIgnoreCase("S")) {

        if (tareaDAO.eliminar(id)) {

            System.out.println("Tarea eliminada correctamente.");

        } else {

            System.out.println("Error al eliminar.");

        }

    } else {

        System.out.println("Operación cancelada.");

    }

}
 
    private void registrarIncidencia() {

    Incidencia i = new Incidencia();

    System.out.println("\n===== REGISTRAR INCIDENCIA =====");

    System.out.print("Descripción: ");
    i.setDescripcion(sc.nextLine());

    System.out.print("Prioridad: ");
    i.setPrioridad(sc.nextLine());

    System.out.print("Estado: ");
    i.setEstado(sc.nextLine());

    System.out.print("Fecha de registro (AAAA-MM-DD): ");
    i.setFechaRegistro(sc.nextLine());

    System.out.print("ID de la tarea: ");
    i.setIdTarea(Integer.parseInt(sc.nextLine()));

    if (incidenciaDAO.insertar(i)) {

        System.out.println("\nIncidencia registrada correctamente.");

    } else {

        System.out.println("\nError al registrar la incidencia.");

    }

}

    private void listarIncidencias() {

    ArrayList<Incidencia> lista = incidenciaDAO.listar();

    if (lista.isEmpty()) {

        System.out.println("\nNo existen incidencias.");

        return;

    }

    System.out.println("\n========== INCIDENCIAS ==========");

    for (Incidencia i : lista) {

        System.out.println("--------------------------------");
        System.out.println("ID: " + i.getIdIncidencia());
        System.out.println("Descripción: " + i.getDescripcion());
        System.out.println("Prioridad: " + i.getPrioridad());
        System.out.println("Estado: " + i.getEstado());
        System.out.println("Fecha: " + i.getFechaRegistro());
        System.out.println("ID Tarea: " + i.getIdTarea());

    }

}
    
    private void modificarIncidencia() {

    System.out.print("\nIngrese el ID de la incidencia: ");

    int id = Integer.parseInt(sc.nextLine());

    Incidencia i = incidenciaDAO.buscar(id);

    if (i == null) {

        System.out.println("Incidencia no encontrada.");

        return;

    }

    System.out.print("Nueva descripción: ");
    i.setDescripcion(sc.nextLine());

    System.out.print("Nueva prioridad: ");
    i.setPrioridad(sc.nextLine());

    System.out.print("Nuevo estado: ");
    i.setEstado(sc.nextLine());

    System.out.print("Nueva fecha (AAAA-MM-DD): ");
    i.setFechaRegistro(sc.nextLine());

    System.out.print("Nuevo ID de tarea: ");
    i.setIdTarea(Integer.parseInt(sc.nextLine()));

    if (incidenciaDAO.actualizar(i)) {

        System.out.println("Incidencia actualizada correctamente.");

    } else {

        System.out.println("Error al actualizar.");

    }

}
 
    private void eliminarIncidencia() {

    System.out.print("\nIngrese el ID de la incidencia: ");

    int id = Integer.parseInt(sc.nextLine());

    System.out.print("¿Está seguro? (S/N): ");

    String respuesta = sc.nextLine();

    if (respuesta.equalsIgnoreCase("S")) {

        if (incidenciaDAO.eliminar(id)) {

            System.out.println("Incidencia eliminada correctamente.");

        } else {

            System.out.println("Error al eliminar.");

        }

    } else {

        System.out.println("Operación cancelada.");

    }

}
    
    private void buscarIncidencia() {

    System.out.print("\nIngrese el ID de la incidencia: ");

    int id = Integer.parseInt(sc.nextLine());

    Incidencia i = incidenciaDAO.buscar(id);

    if (i == null) {

        System.out.println("Incidencia no encontrada.");

        return;

    }

    System.out.println("--------------------------------");
    System.out.println("ID: " + i.getIdIncidencia());
    System.out.println("Descripción: " + i.getDescripcion());
    System.out.println("Prioridad: " + i.getPrioridad());
    System.out.println("Estado: " + i.getEstado());
    System.out.println("Fecha: " + i.getFechaRegistro());
    System.out.println("ID Tarea: " + i.getIdTarea());

}
    
    private void registrarReporte() {

    Reporte r = new Reporte();

    System.out.println("\n===== REGISTRAR REPORTE =====");

    System.out.print("Fecha de generación (AAAA-MM-DD): ");
    r.setFechaGeneracion(sc.nextLine());

    System.out.print("Tipo: ");
    r.setTipo(sc.nextLine());

    System.out.print("Descripción: ");
    r.setDescripcion(sc.nextLine());

    System.out.print("ID del proyecto: ");
    r.setIdProyecto(Integer.parseInt(sc.nextLine()));

    if (reporteDAO.insertar(r)) {

        System.out.println("\nReporte registrado correctamente.");

    } else {

        System.out.println("\nError al registrar el reporte.");

    }

}
    
    private void listarReportes() {

    ArrayList<Reporte> lista = reporteDAO.listar();

    if(lista.isEmpty()){

        System.out.println("\nNo existen reportes.");

        return;

    }

    System.out.println("\n========== REPORTES ==========");

    for(Reporte r : lista){

        System.out.println("--------------------------------");
        System.out.println("ID: " + r.getIdReporte());
        System.out.println("Fecha: " + r.getFechaGeneracion());
        System.out.println("Tipo: " + r.getTipo());
        System.out.println("Descripción: " + r.getDescripcion());
        System.out.println("ID Proyecto: " + r.getIdProyecto());

    }

}
    
    private void buscarReporte() {

    System.out.print("\nIngrese el ID del reporte: ");

    int id = Integer.parseInt(sc.nextLine());

    Reporte r = reporteDAO.buscar(id);

    if(r == null){

        System.out.println("Reporte no encontrado.");

        return;

    }

    System.out.println("--------------------------------");
    System.out.println("ID: " + r.getIdReporte());
    System.out.println("Fecha: " + r.getFechaGeneracion());
    System.out.println("Tipo: " + r.getTipo());
    System.out.println("Descripción: " + r.getDescripcion());
    System.out.println("ID Proyecto: " + r.getIdProyecto());

}
    
    private void modificarReporte() {

    System.out.print("\nIngrese el ID del reporte: ");

    int id = Integer.parseInt(sc.nextLine());

    Reporte r = reporteDAO.buscar(id);

    if(r == null){

        System.out.println("Reporte no encontrado.");

        return;

    }

    System.out.print("Nueva fecha (AAAA-MM-DD): ");
    r.setFechaGeneracion(sc.nextLine());

    System.out.print("Nuevo tipo: ");
    r.setTipo(sc.nextLine());

    System.out.print("Nueva descripción: ");
    r.setDescripcion(sc.nextLine());

    System.out.print("Nuevo ID del proyecto: ");
    r.setIdProyecto(Integer.parseInt(sc.nextLine()));

    if(reporteDAO.actualizar(r)){

        System.out.println("Reporte actualizado correctamente.");

    }else{

        System.out.println("Error al actualizar.");

    }

}
    
    private void eliminarReporte() {

    System.out.print("\nIngrese el ID del reporte: ");

    int id = Integer.parseInt(sc.nextLine());

    System.out.print("¿Está seguro? (S/N): ");

    String respuesta = sc.nextLine();

    if(respuesta.equalsIgnoreCase("S")){

        if(reporteDAO.eliminar(id)){

            System.out.println("Reporte eliminado correctamente.");

        }else{

            System.out.println("Error al eliminar.");

        }

    }else{

        System.out.println("Operación cancelada.");

    }
}
    
    private void ordenarProyectos() {

        System.out.println("\nOrdenando proyectos...");

    }

    private void mostrarEstadisticas() {

        System.out.println("\nEstadísticas del sistema.");

    }

    private void acercaDelSistema() {

        System.out.println("\nSistema desarrollado en Java");
        System.out.println("Base de datos MySQL");
        System.out.println("Programación Orientada a Objetos");
        System.out.println("Trabajo Práctico - Seminario de Práctica Informática");

    }

}