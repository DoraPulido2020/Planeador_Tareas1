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
public class Usuario {
    private Long usuario_id;
    private String usuario_nombre;
    private String usuario_apellido;
    private String usuario;
    private String password;
    private Integer grupo_usuarios_id;
    private String grupo_usuarios_nombre;
    private String usuario_correo;

    public Long getUsuario_id() {
        return usuario_id;
    }

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

    public Integer getGrupo_usuarios_id() {
        return grupo_usuarios_id;
    }

    public String getGrupo_usuarios_nombre() {
        return grupo_usuarios_nombre;
    }

    public String getUsuario_correo() {
        return usuario_correo;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
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

    public void setGrupo_usuarios_id(Integer grupo_usuarios_id) {
        this.grupo_usuarios_id = grupo_usuarios_id;
    }

    public void setGrupo_usuarios_nombre(String grupo_usuarios_nombre) {
        this.grupo_usuarios_nombre = grupo_usuarios_nombre;
    }

    public void setUsuario_correo(String usuario_correo) {
        this.usuario_correo = usuario_correo;
    }
   
   

    @Override
    public String toString() {
        return this.usuario_nombre +""+
                this.usuario_apellido+""+
                this.usuario+""+
                this.password+""+
                this.grupo_usuarios_nombre+""+
                this.usuario_correo;
    }
    
}
