/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

//import inscricao.persistence.entity.Idioma;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import musicmate.persistence.entity.*;


/**
 *
 * @author Wilson
 */
public class ArtistaJpaController extends JpaController {

    public ArtistaJpaController() {
    }

    public void persist(Artista e) {
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
    
    public List<Artista> findArtistas() {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // API criterios
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Artista> cq = cb.createQuery(Artista.class);
            Root<Artista> rt = cq.from(Artista.class);
            //TypedQuery<Artista> q = em.createQuery(cq);
            // JPQL
            // select c from Candidato c where c.idioma = :idioma order by c.nome
            TypedQuery<Artista> q = em.createNamedQuery("Artista.findAll", Artista.class);
            List<Artista> artistas = q.getResultList();

            return artistas;
        } finally {
            if (em != null) em.close();
        }
    }
    
    public int proxId(){
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // API criterios
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Artista> cq = cb.createQuery(Artista.class);
            Root<Artista> rt = cq.from(Artista.class);
            //TypedQuery<Artista> q = em.createQuery(cq);
            // JPQL
            // select c from Candidato c where c.idioma = :idioma order by c.nome
            TypedQuery<Artista> q = em.createNamedQuery("Artista.findAll", Artista.class);
            List<Artista> artistas = q.getResultList();

            int id = 0;
            for(Artista a : artistas){
                if(a.getCodigo() > id){
                    id = a.getCodigo();
                }
            }
            return id+1;
        } finally {
            if (em != null) em.close();
        }
    }

    public ArrayList<Artista> findArtistasByNome(String filtro) {
        EntityManager em = null;        
        try {
            em = getEntityManager();

            // API criterios
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Artista> cq = cb.createQuery(Artista.class);
            EntityType<Artista> type = em.getMetamodel().entity(Artista.class);
            Root<Artista> rt = cq.from(Artista.class);            
            
            cq.select(rt).where(cb.like(cb.lower(rt.get(type.getDeclaredSingularAttribute("nome", String.class))), "%" + filtro.toLowerCase() + "%"));
            
            TypedQuery<Artista> q = em.createQuery(cq);
            // JPQL
            // TypedQuery<Artista> q = em.createQuery("SELECT a FROM Artista a WHERE a.nome LIKE :filtro", Artista.class);
            // q.setParameter("filtro", "%"+ filtro +"%");
            ArrayList<Artista> artistas = (ArrayList<Artista>) q.getResultList();

            return artistas;
        } finally {
            if (em != null) em.close();
        }
    }
}
