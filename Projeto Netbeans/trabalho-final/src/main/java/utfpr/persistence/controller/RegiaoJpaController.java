/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

//import inscricao.persistence.entity.Idioma;
import inscricao.persistence.entity.Estado;
import inscricao.persistence.entity.Regiao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Wilson
 */
public class RegiaoJpaController extends JpaController {

    public RegiaoJpaController() {
    }

    public void persist(Regiao r) {
        EntityManager em = null;        
        try {
            em = getEntityManager();
            
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
            
        } finally {
            if (em != null) em.close();
        }
    }
    
    public List<Regiao> getRegioes() {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // JPQL
            TypedQuery<Regiao> q = em.createNamedQuery("Regiao.findAll", Regiao.class);
            List<Regiao> regioes = q.getResultList();

            return regioes;
        } finally {
            if (em != null) em.close();
        }
    }
}
