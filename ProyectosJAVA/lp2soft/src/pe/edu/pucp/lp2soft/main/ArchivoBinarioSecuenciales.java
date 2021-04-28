
package pe.edu.pucp.lp2soft.main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;

/**
 *
 * @author DAYANA
 */
public class ArchivoBinarioSecuenciales {
    private static String rutaArchEmpleados = "./Empleados.bin";
    public static void main(String[] args){
        //crear un objeto de tipo Empleado
        Empleado emp1= new Empleado(1, "JUAN PEREZ","15819101",
            "Vendedor", 1500.00);
        Empleado emp2= new Empleado(2, "JUAN ARENAS","12345678",
            "Contador", 1500.00);
        try{
            //escribirEmpleado(emp1);
            //escribirEmpleado(emp2);
            
            listarEmpleados();
        }catch(Exception ex){ //agarra la primera excepcion que ocurra
            System.out.println(ex.getMessage());
        }
        
    }
    
    public static void escribirEmpleado(Empleado emp) throws Exception{
        File fichero = new File(rutaArchEmpleados);
         //crear archivo binario y lo apertura en modo escritura
        //el true hace que añada info, no la sobreescriba
        ObjectOutputStream escritor;
        if(fichero.exists())
            escritor = new NoHeaderObjectOuputStream(
            new BufferedOutputStream(new FileOutputStream(fichero,true)));
        else  
            //instanciamos un objeto para escribir el Empleado
            escritor= new ObjectOutputStream
            (new BufferedOutputStream(new FileOutputStream(fichero,true)));
        
        escritor.writeObject(emp);
        escritor.close();
    
    }

    public static void listarEmpleados() throws Exception{
        //leer archivo binario y lo apertura en modo lectura
        FileInputStream archivo = new FileInputStream(rutaArchEmpleados);
        //instanciamos un objeto para leer el Empleado
        ObjectInputStream lector= new ObjectInputStream
        (new BufferedInputStream(archivo));
        while(true){
            try{
                //se castea el objeto
                Empleado emp = (Empleado)lector.readObject();
                System.out.println(emp);
            }catch(Exception ex){
                break;
            }
        }
        
        lector.close();
        archivo.close();
    }
    
    
}
