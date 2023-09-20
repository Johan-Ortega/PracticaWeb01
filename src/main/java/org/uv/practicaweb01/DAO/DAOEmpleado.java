
package org.uv.practicaweb01.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAOEmpleado {
    
    private ConexionDB con;
    
    public DAOEmpleado(){
        con = ConexionDB.getInstance();
    }
    
    
    public boolean guardar(Empleado empleado){
        String sql = "insert into empleado (clave, nombre, direccion, telefono) " + 
                "values('"+empleado.getClave()+"','"+empleado.getNombre()+
                "','"+empleado.getDireccion()+"','"+empleado.getTelefono()+"')";
        return con.execute(sql);
    }
    
    public boolean eliminar(int id){
        String sql = "delete from empleado where clave = '" + id + "'";
        return con.execute(sql);
    }
    
    public boolean modificar(Empleado empleado){
        String sql = "update empleado set nombre ='"+empleado.getNombre()+
                "', direccion ='"+empleado.getDireccion()+"', telefono = '"+empleado.getTelefono()+"' where clave = '"+empleado.getClave()+"'";
        return con.execute(sql);
    }
    
    public Empleado buscarById(int id){
        try {
            String sql = "Select * from empleado where clave = '" + id + "'";
            Empleado empleado = new Empleado();
            ResultSet reg = con.query(sql);
            if (reg.next()) {
                empleado.setClave(reg.getInt("clave"));
                empleado.setNombre(reg.getString("nombre"));
                empleado.setDireccion(reg.getString("direccion"));
                empleado.setTelefono(reg.getString("telefono"));
                return empleado;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Empleado> BuscarTodos(){
        try {
            String sql = "Select * from empleado";
            List<Empleado> lstEmpleado = new ArrayList<>();
                
            ResultSet reg = con.query(sql);
            while (reg.next()) {
                Empleado empleado = new Empleado();
                empleado.setClave(reg.getInt("clave"));
                empleado.setNombre(reg.getString("nombre"));
                empleado.setDireccion(reg.getString("direccion"));
                empleado.setTelefono(reg.getString("telefono"));
                lstEmpleado.add(empleado);
            }
            return lstEmpleado;

        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
