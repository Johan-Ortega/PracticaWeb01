
package org.uv.practicaweb01;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.uv.practicaweb01.DAO.ConexionDB;
import org.uv.practicaweb01.DAO.DAOEmpleado;
import org.uv.practicaweb01.DAO.Empleado;

public class PracticaWeb01 {

    public static void main(String[] args) {
        /*ConexionDB con = ConexionDB.getInstance();
        
        String sql = "insert into empleado(clave, nombre, direccion, telefono)" + 
        "values ('2', 'Alexis', 'av1', '2717498938')";
        
        boolean res = con.execute(sql);
        
        if (res){
            Logger.getLogger("Principal").log(Level.INFO, "Se guardo");
        }else{
            Logger.getLogger("Principal").log(Level.WARNING, "Error ");
        }
        */
        //Modificar**************************************
        
        Empleado empleado =  new Empleado();
        DAOEmpleado dao = new DAOEmpleado();
        
        empleado.setClave(2);
        empleado.setNombre("Alvarez");
        empleado.setDireccion("av3");
        empleado.setTelefono("22271");
        
        //boolean resM = dao.modificar(empleado);
        
        
        boolean res = dao.guardar(empleado);
        
        
        if (res){
            Logger.getLogger("Principal").log(Level.INFO, "SE GUARDO");
        }else{
            Logger.getLogger("Principal").log(Level.WARNING, "ERROR ");
        }
        
        empleado = dao.buscarById(2);
        System.out.println("Nombre: " + empleado.getNombre());
        
        //boolean result = dao.eliminar(2);
        
        List<Empleado> lstEmpleado = dao.BuscarTodos();
        for(Empleado empleado1 : lstEmpleado){
            System.out.println("Nombre: " + empleado1.getNombre());
        }
            
    }
}
 