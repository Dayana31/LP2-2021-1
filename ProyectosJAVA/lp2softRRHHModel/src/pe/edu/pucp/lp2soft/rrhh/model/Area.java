/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.rrhh.model;
import java.util.ArrayList;

/**
 *
 * @author DAYANA
 */
public class Area {
    private int idArea;
    private String nombre;
    private boolean activo;
    
    private ArrayList<Empleado> empleados;

    public Area(int idArea, String nombre) {
        this.idArea = idArea;
        this.nombre = nombre;
     
    }

    public Area() {
        
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

 
    @Override
    public String toString() {
        return  idArea + " - " + nombre;
    }
    
    
}
