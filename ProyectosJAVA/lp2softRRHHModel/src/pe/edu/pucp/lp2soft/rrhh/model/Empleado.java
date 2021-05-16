/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.rrhh.model;

import java.io.Serializable; //esto se tiene que poner para escribir en 
import java.util.Date;
                                //el archivo binario

/**
 *
 * @author DAYANA
 */
public class Empleado extends Persona implements Serializable {
    private String cargo; //25 bytes
    private double sueldo; //8 bytes
    private Area area;
    private boolean activo;
    
    public Empleado(){}

    public Empleado(String nombreCompleto, String DNI, Date fechaNacimiento, int edad, char genero,String cargo, double sueldo, Area area) {
        super(nombreCompleto, DNI, fechaNacimiento, edad, genero);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.area = area;
    }
    
    
    public Empleado(int idPersona, String nombreCompleto, String DNI,
            String cargo, double sueldo) {
        super(idPersona, nombreCompleto, DNI);
        
        if(nombreCompleto.length()<25){
            this.cargo = String.format("%-25s", cargo);
            //completa con espacios a la derecha del nombre
        }
        else
            this.cargo = cargo.substring(0,25);
        
        
        this.sueldo = sueldo;
    }

    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return getIdPersona() + " " + getNombreCompleto() + " "+ cargo;
    }
    
    
}
