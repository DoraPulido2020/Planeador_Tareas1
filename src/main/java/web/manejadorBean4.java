/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.Proyecto;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logica.OperProyecto;

/**
 *
 * @author Dora
 */
@ManagedBean
@SessionScoped
public class manejadorBean4 {

    private String proyecto_nombre;
    private String proyecto_descripcion;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String mensaje;
    private List<Proyecto> proyectos1;

    

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

    public String getMensaje() {
        return mensaje;
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

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setProyecto1(List<Proyecto> proyecto1) {
        this.proyectos1 = proyecto1;
    }
    
    public List<Proyecto> getProyecto1() {
        return proyectos1;
    }
    
    
    public manejadorBean4() {
    consultar();
    }
    

    public void guardar() {
        OperProyecto oper = new OperProyecto();
        Proyecto e = new Proyecto();
        e.setProyecto_nombre(this.proyecto_nombre);
        e.setProyecto_descripcion(this.proyecto_descripcion);
        e.setFecha_inicio(this.fecha_inicio);
        e.setFecha_fin(this.fecha_fin);
        System.out.println("Proyecto " + e);
        this.mensaje = "Se almacenó";
        System.out.println();
        if (oper.insertar(e) > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Almacenó el proyecto"));
            consultar();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente en el almacenamiento, intente mas tarde "));
        }
    }

    private void consultar() {
        OperProyecto oper = new OperProyecto();
        this.proyectos1 = oper.consultar();
        System.out.println(this.proyectos1.size());
    }

}
