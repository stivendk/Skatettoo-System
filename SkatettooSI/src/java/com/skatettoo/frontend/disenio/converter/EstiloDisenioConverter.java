/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.disenio.converter;

import com.skatettoo.backend.persistence.entities.EstiloDisenio;
import com.skatettoo.frontend.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author StivenDavid
 */
@FacesConverter(forClass = EstiloDisenio.class)
public class EstiloDisenioConverter extends AbstractConverter{

    public EstiloDisenioConverter() {
        this.nombreMB = "estiloDisenioManagedBean";
    }
    
}
