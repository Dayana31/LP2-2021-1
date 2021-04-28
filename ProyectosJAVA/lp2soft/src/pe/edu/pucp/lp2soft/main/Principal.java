
package pe.edu.pucp.lp2soft.main;

import java.util.Date;
import pe.edu.pucp.lp2soft.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Area;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;
import pe.edu.pucp.lp2soft.rrhh.mysql.EmpleadoMySQL;

public class Principal {
    public static void main(String[] args){
        Empleado emp = new Empleado("Juan Arenas","12345678",
        new Date(),35,'M',"Vendedor",1500.00,new Area(1,"Ventas"));
    
        //instanciar un DAO
        EmpleadoDAO daoEmpleado = new EmpleadoMySQL();
        daoEmpleado.insertar(emp);
    }
}
