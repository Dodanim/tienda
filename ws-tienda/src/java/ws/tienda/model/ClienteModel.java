/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.tienda.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import ws.tienda.entities.ClienteEntity;
import ws.tienda.utils.JpaUtil;

/**
 *
 * @author KiDo
 */
public class ClienteModel {

    public List<ClienteEntity> listarEntidad() {
//Obtengo una instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("ClienteEntity.findAll");
//El método getResultList() de la clase Query permite obtener
// la lista de resultados de una consulta de selección
            List<ClienteEntity> lista = consulta.getResultList();
            em.close();// Cerrando el EntityManager
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }

    public ClienteEntity obtenerEntidad(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
//Recupero el objeto desde la BD a través del método find
            ClienteEntity entidad = em.find(ClienteEntity.class,
                    id);
            em.close();
            return entidad;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }

    public int insertarEntidad(ClienteEntity entidad) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();//Iniciando transacción
            em.persist(entidad); //Guardando el objeto en la BD
            tran.commit();//Confirmando la transacción
            em.close();
            return 1;

        } catch (Exception e) {
            em.close();
            return 0;
        }
    }

    public int modificarEntidad(ClienteEntity entidad) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();//Iniciando transacción
            em.merge(entidad); //Actualizando el objeto en la BD
            tran.commit();//Confirmando la transacción
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }

    public int eliminarEntidad(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try {
//Recuperando el objeto a eliminar
            ClienteEntity est = em.find(ClienteEntity.class, id);
            if (est != null) {
                EntityTransaction tran = em.getTransaction();
                tran.begin();//Iniciando transacción
                em.remove(est);//Borrando la instancia
                tran.commit();//Confirmando la transacción
                filasBorradas = 1;
            }
            em.close();
            return filasBorradas;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }
}
