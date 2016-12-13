/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.usuario.controller;

import com.skatettoo.backend.persistence.entities.Usuario;
import com.skatettoo.backend.persistence.facade.UsuarioFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author StivenDavid
 */
@Named
@SessionScoped
public class LoginManagedBean implements Serializable {

    private Usuario usuario;
    @EJB
    private UsuarioFacadeLocal usuariofc;
    
    public LoginManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSesion(Usuario us){
        String redir = null;
        try {
            if (usuariofc.iniciarSesion(usuario)!=null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
            redir = "/pages/usuario/inicio?faces-redirect=true";
            }else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
        return redir;
    }
    
    public void cerrarSesion (){
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
