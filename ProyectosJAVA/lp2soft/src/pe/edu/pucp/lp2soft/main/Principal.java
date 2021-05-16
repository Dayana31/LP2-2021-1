
package pe.edu.pucp.lp2soft.main;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.lp2soft.rrhh.dao.AreaDAO;
import pe.edu.pucp.lp2soft.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Area;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;
import pe.edu.pucp.lp2soft.rrhh.mssql.AreaMSSQL;
import pe.edu.pucp.lp2soft.rrhh.mysql.AreaMySQL;
import pe.edu.pucp.lp2soft.rrhh.mysql.EmpleadoMySQL;

public class Principal {
    public static void main(String[] args){
    
        AreaDAO daoArea=new AreaMySQL();
        ArrayList<Area> areas=daoArea.listar();
        for(Area a:areas){
            System.out.println(a);
        }
        
        Empleado emp = new Empleado("Juan Arenas","11345678",
        new Date(),35,'M',"Vendedor",1500.00,areas.get(1));
                //instanciar un DAO
        EmpleadoDAO daoEmpleado = new EmpleadoMySQL();
        if(daoEmpleado.insertar(emp)==1){
            System.out.println("Se ha registrado con exito");
        }else{
            System.out.println("Ha ocurrido un error");
        }
    }
}
