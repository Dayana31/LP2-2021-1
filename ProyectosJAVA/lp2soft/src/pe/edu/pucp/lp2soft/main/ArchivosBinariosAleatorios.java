
package pe.edu.pucp.lp2soft.main;

import java.io.RandomAccessFile;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;

/**
 *
 * @author DAYANA
 */
public class ArchivosBinariosAleatorios { 
    //primero se define el tamaño del registro
    //por cada escritura UTF se suma 2 bytes
    private static final int tamanhoRegEmpleados=111; //105 + 6 
    //dat es para archivos aleatorios
    private static String rutaArchEmpleados = "./Empleados.dat";
    public static void main(String[] args)throws Exception{
        Empleado emp1 = new Empleado(1,"Juan Arenas","13848920","Contador",
        1800.00);
        Empleado emp2 = new Empleado(2,"Karla Cordova","1122920","Vendedora",
        2000.00);
        //escribirEmpleado(emp1);
        //escribirEmpleado(emp2);
        imprimirEmpleado(1);
    }
    
    public static void imprimirEmpleado(int i)throws Exception{
        RandomAccessFile raf = new RandomAccessFile(
        rutaArchEmpleados,"rw"); //solo se puede abrir asi como lectura y escritura
        //poner esto es lo correcto, para que se posicione 
        //al final de cada escritura
        long posicion = i *tamanhoRegEmpleados;
        raf.seek(posicion);
        Empleado emp = new Empleado();
        emp.setIdPersona(raf.readInt());
        emp.setNombreCompleto(raf.readUTF().trim()); //trim quita espacion es blanco a la derecha
        emp.setDNI(raf.readUTF().trim());
        emp.setCargo(raf.readUTF().trim());
        emp.setSueldo(raf.readDouble());

        raf.close();
        System.out.println(emp);
    }
     
    public static void escribirEmpleado(Empleado emp)throws Exception{
        RandomAccessFile raf = new RandomAccessFile(
        rutaArchEmpleados,"rw"); //solo se puede abrir asi como lectura y escritura
        //poner esto es lo correcto, para que se posicione 
        //al final de cada escritura
        raf.seek(raf.length());
        raf.writeInt(emp.getIdPersona());
        raf.writeUTF(emp.getNombreCompleto());
        raf.writeUTF(emp.getDNI());
        raf.writeUTF(emp.getCargo());
        raf.writeDouble(emp.getSueldo());
        System.out.println(raf.length());
        raf.close();
    }
}
