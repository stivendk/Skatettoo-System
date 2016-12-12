/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.disenio.controller;

import com.skatettoo.backend.persistence.entities.Disenio;
import com.skatettoo.backend.persistence.facade.DisenioFacadeLocal;
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
@Named(value = "disenioManagedBean")
@SessionScoped
public class DisenioManagedBean implements Serializable, Managedbean<Disenio> {

    private Disenio disenio;
    @EJB
    private DisenioFacadeLocal diseniofc;

    public DisenioManagedBean() {
    }

    public Disenio getDisenio() {
        return disenio;
    }

    public void setDisenio(Disenio disenio) {
        this.disenio = disenio;
    }

    @PostConstruct
    public void init() {
        disenio = new Disenio();
    }

    public void registrarDisenio() {
        diseniofc.create(disenio);
    }

    public void eliminarDisenio(Disenio disenio) {
        diseniofc.remove(disenio);
    }

    public String actualizarDisenio(Disenio dc) {
        disenio = dc;
        return "";
    }

    public String verDisenio(Disenio dc) {
        disenio = dc;
        return "/pages/disenios/disenio";
    }
    
    public String enviarCita(Disenio dc) {
        disenio = dc;
        return "/pages/disenios/solicitard";
    }

    public void modificarDisenio() {
        diseniofc.edit(disenio);
    }

    public List<Disenio> listarDisenio() {
        return diseniofc.findAll();
    }

    @Override
    public Disenio getObject(Integer i) {
        return diseniofc.find(i);
    }
}
