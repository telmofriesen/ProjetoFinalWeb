/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

//import inscricao.persistence.entity.Idioma;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import musicmate.persistence.entity.*;

/**
 *
 * @author Wilson
 */
public class PerfilJpaController extends JpaController {

    public PerfilJpaController() {
    }

    public void persist(Perfil e) {
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
    
    public List<Perfil> findPerfis() {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // JPQL
            // select c from Candidato c where c.idioma = :idioma order by c.nome
            TypedQuery<Perfil> q = em.createQuery("SELECT * FROM perfil", Perfil.class);
            List<Perfil> perfis = q.getResultList();

            return perfis;
        } finally {
            if (em != null) em.close();
        }
    }
}
