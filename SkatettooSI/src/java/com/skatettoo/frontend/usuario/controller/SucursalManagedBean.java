/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.usuario.controller;

import com.skatettoo.backend.persistence.entities.Sucursal;
import com.skatettoo.backend.persistence.facade.SucursalFacadeLocal;
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
@Named(value = "sucursalManagedBean")
@SessionScoped
public class SucursalManagedBean implements Serializable, Managedbean <Sucursal> {

    private Sucursal sucu;
    @EJB
    private SucursalFacadeLocal sucufc;

    public SucursalManagedBean() {
    }

    public Sucursal getSucu() {
        return sucu;
    }

    public void setSucu(Sucursal sucu) {
        this.sucu = sucu;
    }

    @PostConstruct
    public void init() {
        sucu = new Sucursal();
    }

    public void registrarSucursal() {
        sucufc.create(sucu);
    }

    public void eliminarSucursal(Sucursal sc) {
        sucufc.remove(sc);
    }

    public void modificarSucursal() {
        sucufc.edit(sucu);
    }

    public String actualizarSucursal(Sucursal s) {
        sucu = s;
        return "/pages/usuario/tatuador/csucursal_1";
    }

    public String verSucursal(Sucursal s) {
        sucu = s;
        return "/pages/disenios/sucurv";
    }

    public List<Sucursal> listarSucursal() {
        return sucufc.findAll();
    }

    @Override
    public Sucursal getObject(Integer i) {
        return sucufc.find(i);
    }
}
