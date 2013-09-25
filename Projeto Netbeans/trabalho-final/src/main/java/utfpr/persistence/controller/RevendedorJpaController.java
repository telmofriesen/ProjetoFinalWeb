/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

//import inscricao.persistence.entity.Idioma;
import inscricao.persistence.entity.Estado;
import inscricao.persistence.entity.Revendedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Wilson
 */
public class RevendedorJpaController extends JpaController {

    public RevendedorJpaController() {
    }

    public void persist(Revendedor r) {
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
    
    public List<Revendedor> getRevendedores() {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // JPQL
            TypedQuery<Revendedor> q = em.createNamedQuery("Revendedor.findAll", Revendedor.class);
            List<Revendedor> regioes = q.getResultList();

            return regioes;
        } finally {
            if (em != null) em.close();
        }
    }
    
    public List<Revendedor> getRevendedores(String filtro) {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // JPQL
            TypedQuery<Revendedor> q = em.createQuery("SELECT r FROM Revendedor r WHERE r.cnpj = :filtroCnpj OR r.nomeFantasia LIKE :filtro OR r.cidade LIKE :filtro OR r.estadoDeAtuacao.descricao LIKE :filtro", Revendedor.class);
            try {
                q.setParameter("filtroCnpj", Long.parseLong(filtro));
            } catch (NumberFormatException e) {
                q.setParameter("filtroCnpj", new Long(-1));
            }
            q.setParameter("filtro", "%"+ filtro +"%");
            List<Revendedor> regioes = q.getResultList();

            return regioes;
        } finally {
            if (em != null) em.close();
        }
    }
    
    public boolean exists(Long cnpj) {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // JPQL
            TypedQuery<Revendedor> q = em.createQuery("SELECT r FROM Revendedor r WHERE r.cnpj = :cnpj", Revendedor.class);
            q.setParameter("cnpj", cnpj);
            return q.getResultList().size() > 0;

        } finally {
            if (em != null) em.close();
        }
    }
}
