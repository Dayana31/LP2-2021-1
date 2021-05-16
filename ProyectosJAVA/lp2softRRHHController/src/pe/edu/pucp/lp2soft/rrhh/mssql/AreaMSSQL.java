
package pe.edu.pucp.lp2soft.rrhh.mssql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.rrhh.config.DBManager;
import pe.edu.pucp.lp2soft.rrhh.dao.AreaDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Area;

public class AreaMSSQL implements AreaDAO{
    Connection conexion; //java.sql.Connection
    PreparedStatement pst;
    @Override
    public ArrayList<Area> listar() {
        ArrayList<Area> areas = new ArrayList<>();
        try {
            //registrar el driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //creamos la conexion
            conexion = DriverManager.getConnection(DBManager.urlMSSQL,
                   DBManager.user,DBManager.password);
            String sql="SELECT * FROM Area where Activo=1";
            pst=conexion.prepareStatement(sql);
            
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()) {
       
                Area area =new Area();
                area.setIdArea(resultSet.getInt("IdArea"));
                area.setNombre(resultSet.getString("Nombre"));
                areas.add(area); 

                
            }
            resultSet.close();
            pst.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            //esto siempre se va a ejecutar
            try{conexion.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return areas;
    }

    @Override
    public int insertar(Area area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificar(Area area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int idArea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
