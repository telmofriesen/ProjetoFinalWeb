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
public class FaixaJpaController extends JpaController {

    public FaixaJpaController() {
    }

    public void persist(Faixa f) {
        EntityManager em = null;        
        try {
            em = getEntityManager();
            
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            
        } finally {
            if (em != null) em.close();
        }
    }
    
    public ArrayList<Faixa> findFaixas() {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // JPQL
            // select c from Candidato c where c.idioma = :idioma order by c.nome
            TypedQuery<Faixa> q = em.createQuery("SELECT * FROM faixa", Faixa.class);
            ArrayList<Faixa> faixas = (ArrayList<Faixa>) q.getResultList();

            return faixas;
        } finally {
            if (em != null) em.close();
        }
    }

    public ArrayList<Faixa> findFaixasByTitulo(String filtro) {
        EntityManager em = null;        
        try {
            em = getEntityManager();

            // API criterios
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Faixa> cq = cb.createQuery(Faixa.class);
            Root<Faixa> rt = cq.from(Faixa.class);
            cq.select(rt).where(cb.like(rt.get(Faixa_.titulo), "%"+filtro+"%"));
            TypedQuery<Faixa> q = em.createQuery(cq);
            // JPQL
            // TypedQuery<Artista> q = em.createQuery("SELECT a FROM Artista a WHERE a.nome LIKE :filtro", Artista.class);
            // q.setParameter("filtro", "%"+ filtro +"%");
            ArrayList<Faixa> faixas = (ArrayList<Faixa>) q.getResultList();

            return faixas;
        } finally {
            if (em != null) em.close();
        }
    }
    
    public ArrayList<Faixa> findFaixasByAlbum(int filtro) {
        EntityManager em = null;        
        try {
            em = getEntityManager();

            // API criterios
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Faixa> cq = cb.createQuery(Faixa.class);
            Root<Faixa> rt = cq.from(Faixa.class);
            //cq.select(rt).where(cb.like(rt.get(Faixa_.titulo), "%"+filtro+"%"));
            //TypedQuery<Faixa> q = em.createQuery(cq);
            // JPQL
             TypedQuery<Faixa> q = em.createQuery("SELECT f FROM Faixa f WHERE f.codigo_album =:filtro", Faixa.class);
             q.setParameter("filtro", filtro);
            ArrayList<Faixa> faixas = (ArrayList<Faixa>) q.getResultList();

            return faixas;
        } finally {
            if (em != null) em.close();
        }
    }
}
