/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.disenio.converter;

import com.skatettoo.backend.persistence.entities.Usuario;
import com.skatettoo.frontend.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author StivenDavid
 */
@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter extends AbstractConverter{

    public UsuarioConverter() {
        this.nombreMB = "usuarioManagedBean";
    }
    
}
