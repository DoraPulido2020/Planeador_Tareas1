/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author Dora
 */
public class Proyecto {
    private Long proyecto_id;
    private String proyecto_nombre;
    private String proyecto_descripcion;
    private Date fecha_inicio;
    private Date fecha_fin;

    public Long getProyecto_id() {
        return proyecto_id;
    }


    public String getProyecto_nombre() {
        return proyecto_nombre;
    }

    public String getProyecto_descripcion() {
        return proyecto_descripcion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setProyecto_id(Long proyecto_id) {
        this.proyecto_id = proyecto_id;
    }


    public void setProyecto_nombre(String proyecto_nombre) {
        this.proyecto_nombre = proyecto_nombre;
    }

    public void setProyecto_descripcion(String proyecto_descripcion) {
        this.proyecto_descripcion = proyecto_descripcion;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
  
    
  

    @Override
    public String toString() {
        return this.proyecto_nombre+""+
                this.proyecto_descripcion+""+
                this.fecha_inicio+""+
                this.fecha_fin;
    }
    
}
