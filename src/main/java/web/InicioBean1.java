/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;



/**
 *
 * @author Dora
 */
@ManagedBean
@SessionScoped
public class InicioBean1 {
    
   public String Ingresar (){
       return "proyectos";
   }
   
}
