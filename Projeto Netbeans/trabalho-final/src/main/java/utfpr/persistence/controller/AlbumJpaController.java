/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

//import inscricao.persistence.entity.Idioma;
import java.util.List;
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
public class AlbumJpaController extends JpaController {

    public AlbumJpaController() {
    }

    public void persist(Album a) {
        EntityManager em = null;        
        try {
            em = getEntityManager();
            
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            
        } finally {
            if (em != null) em.close();
        }
    }
    
    public List<Album> findAlbuns() {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // API criterios
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Album> cq = cb.createQuery(Album.class);
            Root<Album> rt = cq.from(Album.class);
            TypedQuery<Album> q = em.createQuery(cq);
            // JPQL
            // select c from Candidato c where c.idioma = :idioma order by c.nome
            // TypedQuery<Artista> q = em.createNamedQuery("Artista.findAll", Artista.class);
            List<Album> albuns = q.getResultList();

            return albuns;
        } finally {
            if (em != null) em.close();
        }
    }

    public List<Album> findAlbunsByTitulo(String filtro) {
        EntityManager em = null;        
        try {
            em = getEntityManager();

            // API criterios
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Album> cq = cb.createQuery(Album.class);
            Root<Album> rt = cq.from(Album.class);
            cq.select(rt).where(cb.like(rt.get(Album_.titulo), "%"+filtro+"%"));
            TypedQuery<Album> q = em.createQuery(cq);
            // JPQL
            // TypedQuery<Artista> q = em.createQuery("SELECT a FROM Artista a WHERE a.nome LIKE :filtro", Artista.class);
            // q.setParameter("filtro", "%"+ filtro +"%");
            List<Album> albuns = q.getResultList();

            return albuns;
        } finally {
            if (em != null) em.close();
        }
    }
}
