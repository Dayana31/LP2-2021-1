/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.rrhh.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DAYANA
 */
public class Persona implements Serializable{
    private int idPersona; //4 bytes
    private String nombreCompleto; //60 bytes
    private String DNI; //8 bytes
    private Date fechaNacimiento;
    private int edad;
    private char genero;
    
    public Persona(){}

    public Persona(String nombreCompleto, String DNI, Date fechaNacimiento, int edad, char genero) {
        this.nombreCompleto = nombreCompleto;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.genero = genero;
    }
    
    
    public Persona(int idPersona, String nombreCompleto, String DNI) {
        this.idPersona = idPersona;
        if(nombreCompleto.length()<60){
            this.nombreCompleto = String.format("%-60s", nombreCompleto);
            //completa con espacios a la derecha del nombre
        }
        else
            this.nombreCompleto = nombreCompleto.substring(0,60);
        
        if(DNI.length()<8){
            this.DNI = String.format("%-8s", DNI);
            //completa con espacios a la derecha del dni
        }
        else
            this.DNI = DNI.substring(0,8);
        
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    
  
    
}
