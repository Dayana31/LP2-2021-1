/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pe.lp2soft.gestclientes.model;
import pe.edu.pucp.lp2soft.rrhh.model.Persona;

/**
 *
 * @author DAYANA
 */
public class Cliente extends Persona {
    private Categoria categoria;

    public Cliente(int idPersona, String nombreCompleto, String DNI,
            Categoria categoria) {
        super(idPersona, nombreCompleto, DNI);
        this.categoria = categoria;
    }

    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}
