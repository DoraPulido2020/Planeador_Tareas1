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
    private String fecha_entrega;
    private String fecha_asignacion;
    private Prioridad prioridad_tarea;
    private Integer activo;
    private Integer proyecto_id;
    private String proyecto_nombre;
    private Integer usuario_id;
    private String usuario_nombre;

    public Tarea() {
    }

    public Tarea(Long tarea_id, String tarea_nombre, String tarea_descripcion, String fecha_entrega, String fecha_asignacion, Prioridad prioridad_tarea, Integer activo, Integer proyecto_id, String proyecto_nombre, Integer usuario_id, String usuario_nombre) {
        this.tarea_id = tarea_id;
        this.tarea_nombre = tarea_nombre;
        this.tarea_descripcion = tarea_descripcion;
        this.fecha_entrega = fecha_entrega;
        this.fecha_asignacion = fecha_asignacion;
        this.prioridad_tarea = prioridad_tarea;
        this.activo = activo;
        this.proyecto_id = proyecto_id;
        this.proyecto_nombre = proyecto_nombre;
        this.usuario_id = usuario_id;
        this.usuario_nombre = usuario_nombre;
    }

    public Long getTarea_id() {
        return tarea_id;
    }

    public void setTarea_id(Long tarea_id) {
        this.tarea_id = tarea_id;
    }

    public String getTarea_nombre() {
        return tarea_nombre;
    }

    public void setTarea_nombre(String tarea_nombre) {
        this.tarea_nombre = tarea_nombre;
    }

    public String getTarea_descripcion() {
        return tarea_descripcion;
    }

    public void setTarea_descripcion(String tarea_descripcion) {
        this.tarea_descripcion = tarea_descripcion;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(String fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    public Prioridad getPrioridad_tarea() {
        return prioridad_tarea;
    }

    public void setPrioridad_tarea(Prioridad prioridad_tarea) {
        this.prioridad_tarea = prioridad_tarea;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public Integer getProyecto_id() {
        return proyecto_id;
    }

    public void setProyecto_id(Integer proyecto_id) {
        this.proyecto_id = proyecto_id;
    }

    public String getProyecto_nombre() {
        return proyecto_nombre;
    }

    public void setProyecto_nombre(String proyecto_nombre) {
        this.proyecto_nombre = proyecto_nombre;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    @Override
    public String toString() {
        return "Tarea{" + "tarea_id=" + tarea_id + ", tarea_nombre=" + tarea_nombre + ", tarea_descripcion=" + tarea_descripcion + ", fecha_entrega=" + fecha_entrega + ", fecha_asignacion=" + fecha_asignacion + ", prioridad_tarea=" + prioridad_tarea + ", activo=" + activo + ", proyecto_id=" + proyecto_id + ", proyecto_nombre=" + proyecto_nombre + ", usuario_id=" + usuario_id + ", usuario_nombre=" + usuario_nombre + '}';
    }
}
