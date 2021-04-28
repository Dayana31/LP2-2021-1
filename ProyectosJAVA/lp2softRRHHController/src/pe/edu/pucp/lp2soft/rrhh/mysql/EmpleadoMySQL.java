
package pe.edu.pucp.lp2soft.rrhh.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.rrhh.config.DBManager;
import pe.edu.pucp.lp2soft.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;
import java.util.Date;
public class EmpleadoMySQL implements EmpleadoDAO{
    Connection con; //java.sql.Connection
    Statement st; //java.sql.Statement
    
    @Override
    public ArrayList<Empleado> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(Empleado empleado) {
        int resultado=0;
        try{
            //registrar el driver
           Class.forName("com.mysql.cj.jdbc.Driver");
           //creamos la conexion
           con = DriverManager.getConnection(DBManager.url,
                   DBManager.user,DBManager.password);
           //creamos un statement para ejecutar una instruccion
           st = con.createStatement();
           SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
           //instruccion sql
           //las comillas simples van cuando se manda string, si es 
           //entero no va comillas simples
           String instruccionSQL = "INSERT INTO persona(nombre_completo,"
                   + "DNI,fecha_nacimiento,edad,genero) VALUES("
                   + "'"+ empleado.getNombreCompleto() + "','" +
                   empleado.getDNI()+ "','"+formato.format(empleado.getFechaNacimiento())+
                   "'," + empleado.getEdad()+ ",'" + empleado.getGenero()+
                            "')";
           //en caso funcione devuelve 1, caso contrario es 0
           resultado = st.executeUpdate(instruccionSQL);
           
           //es importante cerrar la conexion
           con.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return resultado;
    }

    @Override
    public int modificar(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int idEmpleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
