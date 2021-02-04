/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.tienda.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ws.tienda.entities.ClienteEntity;

/**
 *
 * @author KiDo
 */
@Stateless
public class ClienteEntityFacade extends AbstractFacade<ClienteEntity> {

    @PersistenceContext(unitName = "ws-tiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public int insertarEntidad(ClienteEntity entidad) {
        em.persist(entidad);
        return 1;
    }

    public ClienteEntityFacade() {
        super(ClienteEntity.class);
    }

}
