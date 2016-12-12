/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.usuario.controller;

import com.skatettoo.backend.persistence.entities.EstadoUsuario;
import com.skatettoo.backend.persistence.facade.EstadoUsuarioFacadeLocal;
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
@Named(value = "estadoUsuarioManagedBean")
@SessionScoped
public class EstadoUsuarioManagedBean implements Serializable, Managedbean <EstadoUsuario> {

    private EstadoUsuario estad;
    @EJB
    private EstadoUsuarioFacadeLocal estadfc;

    public EstadoUsuarioManagedBean() {
    }

    public EstadoUsuario getEstad() {
        return estad;
    }

    public void setEstad(EstadoUsuario estad) {
        this.estad = estad;
    }

    @PostConstruct
    public void init() {
        estad = new EstadoUsuario();
    }

    public List<EstadoUsuario> listarEstadoU() {
        return estadfc.findAll();
    }

    @Override
    public EstadoUsuario getObject(Integer i) {
        return estadfc.find(i);
    }
}
