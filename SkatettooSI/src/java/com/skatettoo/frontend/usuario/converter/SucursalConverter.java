/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.usuario.converter;

import com.skatettoo.backend.persistence.entities.Sucursal;
import com.skatettoo.frontend.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author StivenDavid
 */
@FacesConverter(forClass = Sucursal.class)
public class SucursalConverter extends AbstractConverter{

    public SucursalConverter() {
        this.nombreMB = "sucursalManagedBean";
    }
    
    
}
