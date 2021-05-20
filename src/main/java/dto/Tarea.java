/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author Dora
 */
public class Tarea {
    private Long tarea_id;
    private String tarea_nombre;
    private String tarea_descripcion;
    private Date fecha_entrega;
    private Date fecha_asignacion;
    private Prioridad prioridad_tarea;
    private Integer activo;
    private Integer proyecto_id;
    private String proyecto_nombre;
    private Integer usuario_id;
    private String usuario_nombre;

    public Long getTarea_id() {
        return tarea_id;
    }

    public String getTarea_nombre() {
        return tarea_nombre;
    }

    public String getTarea_descripcion() {
        return tarea_descripcion;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public Date getFecha_asignacion() {
        return fecha_asignacion;
    }

    public Prioridad getPrioridad_tarea() {
        return prioridad_tarea;
    }

    public Integer getActivo() {
        return activo;
    }

    public Integer getProyecto_id() {
        return proyecto_id;
    }

    public String getProyecto_nombre() {
        return proyecto_nombre;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setTarea_id(Long tarea_id) {
        this.tarea_id = tarea_id;
    }

    public void setTarea_nombre(String tarea_nombre) {
        this.tarea_nombre = tarea_nombre;
    }

    public void setTarea_descripcion(String tarea_descripcion) {
        this.tarea_descripcion = tarea_descripcion;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public void setFecha_asignacion(Date fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    public void setPrioridad_tarea(Prioridad prioridad_tarea) {
        this.prioridad_tarea = prioridad_tarea;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public void setProyecto_id(Integer proyecto_id) {
        this.proyecto_id = proyecto_id;
    }

    public void setProyecto_nombre(String proyecto_nombre) {
        this.proyecto_nombre = proyecto_nombre;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }
    
   
    

   

    @Override
    public String toString() {
        return this.tarea_nombre +""+
                this.tarea_descripcion+""+
                this.fecha_entrega+""+
                this.fecha_asignacion+""+
                this.prioridad_tarea.getNombre()+""+
                this.activo +""+
                this.proyecto_nombre+""+
                this.usuario_nombre;
    }
    
}
