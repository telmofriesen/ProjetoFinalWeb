/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

//import inscricao.persistence.entity.Idioma;
import inscricao.persistence.entity.Estado;
import inscricao.persistence.entity.Regiao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Wilson
 */
public class EstadoJpaController extends JpaController {

    public EstadoJpaController() {
    }

    public void persist(Estado e) {
        EntityManager em = null;        
        try {
            em = getEntityManager();
            
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
            
        } finally {
            if (em != null) em.close();
        }
    }
    
    public List<Estado> getEstados(Regiao r) {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // JPQL
            // select c from Candidato c where c.idioma = :idioma order by c.nome
            TypedQuery<Estado> q = em.createQuery("SELECT e FROM Estado e WHERE e.regiao = :regiao", Estado.class);
            q.setParameter("regiao", r);
            List<Estado> estados = q.getResultList();

            return estados;
        } finally {
            if (em != null) em.close();
        }
    }
    
    public List<Estado> getEstados() {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // JPQL
            TypedQuery<Estado> q = em.createNamedQuery("Estado.findAll", Estado.class);
            List<Estado> estados = q.getResultList();

            return estados;
        } finally {
            if (em != null) em.close();
        }
    }
}
