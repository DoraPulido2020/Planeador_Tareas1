/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.Tarea;
import dto.Prioridad;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logica.OperTarea;

/**
 *
 * @author Dora
 */
@ManagedBean
@SessionScoped
public class manejadorBean3 {

    private String tarea_nombre;
    private String tarea_descripcion;
    private String fecha_entrega;
    private String fecha_asignacion;
    private Integer prioridad;
    private Integer activo;
    /*private Integer proyecto_id;*/
    private String proyecto_nombre;
    /*private Integer usuario_id;*/
    private String usuario_nombre;
    private String mensaje;

    public String getTarea_nombre() {
        return tarea_nombre;
    }

    public String getTarea_descripcion() {
        return tarea_descripcion;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public String getFecha_asignacion() {
        return fecha_asignacion;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public Integer getActivo() {
        return activo;
    }

    public String getProyecto_nombre() {
        return proyecto_nombre;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setTarea_nombre(String tarea_nombre) {
        this.tarea_nombre = tarea_nombre;
    }

    public void setTarea_descripcion(String tarea_descripcion) {
        this.tarea_descripcion = tarea_descripcion;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public void setFecha_asignacion(String fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public void setProyecto_nombre(String proyecto_nombre) {
        this.proyecto_nombre = proyecto_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    private List<Tarea> tareas1;

    public List<Tarea> getTareas1() {
        return tareas1;
    }

    public void setTareas1(List<Tarea> tareas1) {
        this.tareas1 = tareas1;
    }

    public manejadorBean3() {
        consultar();
    }

    public void guardar() {
        OperTarea oper = new OperTarea();
        Tarea e = new Tarea();
        e.setTarea_nombre(this.tarea_nombre);
        e.setTarea_descripcion(this.tarea_descripcion);
        e.setFecha_entrega(this.fecha_entrega);
        e.setFecha_asignacion(this.fecha_asignacion);
        if (this.prioridad == 1) {
            e.setPrioridad_tarea(Prioridad.ALTA);
        }
        if (this.prioridad == 2) {
            e.setPrioridad_tarea(Prioridad.MEDIA);
        }
        if (this.prioridad == 3) {
            e.setPrioridad_tarea(Prioridad.BAJA);
        }
        e.setActivo(1);
        e.setProyecto_nombre(this.proyecto_nombre);
        e.setUsuario_nombre(this.usuario_nombre);
        System.out.println("Tarea " + e);
        this.mensaje = "Se almacenó";
        System.out.println();
        if (oper.insertar(e) > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Almacenó la Tarea"));
            consultar();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente en el almacenamiento, intente mas tarde "));
        }

    }

    private void consultar() {
        OperTarea oper = new OperTarea();
        this.tareas1 = oper.consultar();
        System.out.println(this.tareas1.size());
    }

}
