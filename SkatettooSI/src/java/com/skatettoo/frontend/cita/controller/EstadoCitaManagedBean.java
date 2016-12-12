/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.cita.controller;

import com.skatettoo.backend.persistence.entities.EstadoCita;
import com.skatettoo.backend.persistence.facade.EstadoCitaFacadeLocal;
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
@Named(value = "estadoCitaManagedBean")
@SessionScoped
public class EstadoCitaManagedBean implements Serializable, Managedbean <EstadoCita> {

    private EstadoCita estadc;
    @EJB
    private EstadoCitaFacadeLocal estadcfc;

    public EstadoCitaManagedBean() {
    }

    public EstadoCita getEstadc() {
        return estadc;
    }

    public void setEstadc(EstadoCita estadc) {
        this.estadc = estadc;
    }
    
    @PostConstruct
    public void init(){
        estadc = new EstadoCita();
    }
    public List<EstadoCita> listarEstado(){
        return estadcfc.findAll();
    }
    @Override
    public EstadoCita getObject(Integer i) {
        return estadcfc.find(i);
    }
}
