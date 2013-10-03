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
public class UsuarioJpaController extends JpaController {

    public UsuarioJpaController() {
    }

    public void persist(Usuario u) {
        EntityManager em = null;        
        try {
            em = getEntityManager();
            
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            
        } finally {
            if (em != null) em.close();
        }
    }
    
    public Usuario getUsuarioByEmail(String email) {
        EntityManager em = null;        
        try {
            em = getEntityManager();

            // API criterios
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(rt).where(cb.equal(rt.get(Usuario_.email), email));
            TypedQuery<Usuario> q = em.createQuery(cq);
            Usuario usuario = q.getSingleResult();

            return usuario;
        } finally {
            if (em != null) em.close();
        }
    }
    
    public List<Usuario> findUsuarios() {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // JPQL
            // select c from Candidato c where c.idioma = :idioma order by c.nome
            TypedQuery<Usuario> q = em.createQuery("SELECT * FROM usuario", Usuario.class);
            List<Usuario> usuarios = q.getResultList();

            return usuarios;
        } finally {
            if (em != null) em.close();
        }
    }

    public ArrayList<Usuario> findUsuarioByNome(String filtro) {
        EntityManager em = null;        
        try {
            em = getEntityManager();

            // API criterios
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(rt).where(cb.like(rt.get(Usuario_.nome), "%"+filtro+"%"));
            TypedQuery<Usuario> q = em.createQuery(cq);
            // JPQL
            // TypedQuery<Artista> q = em.createQuery("SELECT a FROM Artista a WHERE a.nome LIKE :filtro", Artista.class);
            // q.setParameter("filtro", "%"+ filtro +"%");
            ArrayList<Usuario> usuarios = (ArrayList<Usuario>) q.getResultList();

            return usuarios;
        } finally {
            if (em != null) em.close();
        }
    }
}
