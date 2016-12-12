/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.usuario.controller;

import com.skatettoo.backend.persistence.entities.Usuario;
import com.skatettoo.backend.persistence.facade.UsuarioFacadeLocal;
import com.skatettoo.frontend.util.Managedbean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author StivenDavid
 */
@Named(value = "usuarioManagedBean")
@SessionScoped
public class UsuarioManagedBean implements Serializable, Managedbean <Usuario> {

    private Usuario usuario;
    @EJB
    private UsuarioFacadeLocal usuariofc;

    public UsuarioManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public String registrarUsuario() {
        usuariofc.create(usuario);
        return "/pages/usuario/inicio";
    }

    public void eliminarUsuario(Usuario u) {
        usuariofc.remove(u);
    }

    public void modificarUsuario() {
        usuariofc.edit(usuario);
    }

    public String actualizarUsuario(Usuario us) {
        usuario = us;
        return "";
    }

    public List<Usuario> listarUsuario() {
        return usuariofc.findAll();
    }

    @Override
    public Usuario getObject(Integer i) {
        return usuariofc.find(i);
    }
}
