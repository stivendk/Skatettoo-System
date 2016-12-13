/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.backend.persistence.facade;

import com.skatettoo.backend.persistence.entities.Cita;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author StivenDavid
 */
@Stateless
public class CitaFacade extends AbstractFacade<Cita> implements CitaFacadeLocal {

    @PersistenceContext(unitName = "SkatettooSIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitaFacade() {
        super(Cita.class);
    }

    @Override
    public List<Object[]> reporteCita() {
        Query query = em.createNativeQuery("SELECT u.nombre, u.apellido, us.nombre, us.apellido, d.nombre_disenio, s.nombre, s.direccion, c.fecha_hora FROM Usuario u INNER JOIN Citas c on u.id_usuario=c.id_usuario INNER JOIN disenios d on c.id_disenio=d.id_disenio INNER JOIN usuario us on d.id_usuario=us.id_usuario INNER JOIN usuario_sucursal x on us.id_usuario=x.id_usuario INNER JOIN sucursales s on x.id_sucursal=s.id_sucursal");
        return query.getResultList();
    }

}
