/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dto.Usuario;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logica.OperUsuario;

/**
 *
 * @author Dora
 */
@ManagedBean
@SessionScoped
public class manejadorBean5 {

    private String usuario_nombre;
    private String usuario_apellido;
    private String usuario;
    private String password;
    private String grupo_usuarios_nombre;
    private String usuario_correo;
    private String mensaje;
    private List<Usuario> usuarios1;

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public String getUsuario_apellido() {
        return usuario_apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getGrupo_usuarios_nombre() {
        return grupo_usuarios_nombre;
    }

    public String getUsuario_correo() {
        return usuario_correo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public List<Usuario> getUsuarios1() {
        return usuarios1;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public void setUsuario_apellido(String usuario_apellido) {
        this.usuario_apellido = usuario_apellido;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGrupo_usuarios_nombre(String grupo_usuarios_nombre) {
        this.grupo_usuarios_nombre = grupo_usuarios_nombre;
    }

    public void setUsuario_correo(String usuario_correo) {
        this.usuario_correo = usuario_correo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setUsuarios1(List<Usuario> usuarios1) {
        this.usuarios1 = usuarios1;
    }


    public manejadorBean5() {
        consultar();
    }

    public void guardar() {
        OperUsuario oper = new OperUsuario();
        Usuario e = new Usuario();
        e.setUsuario_nombre(this.usuario_nombre);
        e.setUsuario_apellido(this.usuario_apellido);
        e.setUsuario(this.usuario);
        e.setPassword(this.password);
        e.setGrupo_usuarios_nombre(this.grupo_usuarios_nombre);
        e.setUsuario_correo(this.usuario_correo);
        System.out.println("Usuario " + e);
        this.mensaje = "Se almacenó";
        System.out.println();
        if (oper.insertar(e) > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Almacenó Usuario"));
            consultar();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente en el almacenamiento, intente mas tarde "));
        }

    }

    private void consultar() {
        OperUsuario oper = new OperUsuario();
        this.usuarios1 = oper.consultar();
        System.out.println(this.usuarios1.size());
    }

}
