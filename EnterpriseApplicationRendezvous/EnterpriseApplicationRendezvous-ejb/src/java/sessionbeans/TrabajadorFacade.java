/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Trabajador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Aileen
 */
@Stateless
public class TrabajadorFacade extends AbstractFacade<Trabajador> implements TrabajadorFacadeLocal {
    @PersistenceContext(unitName = "EnterpriseApplicationRendezvous-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrabajadorFacade() {
        super(Trabajador.class);
    }

    @Override
    public List<Trabajador> buscarPorNombre(String nombre) {
        Query query;
        query=em.createNamedQuery("Trabajador.findByNombreTrab").setParameter("nombreTrab", this);
        return query.getResultList();
    }

    @Override
    public List<Trabajador> buscarPorApellido(String apellido) {
        Query query;
        query=em.createNamedQuery("Trabajador.findByApellidoPatTrab").setParameter("apellidoPatTrab", this);
        return query.getResultList();
    }

}
