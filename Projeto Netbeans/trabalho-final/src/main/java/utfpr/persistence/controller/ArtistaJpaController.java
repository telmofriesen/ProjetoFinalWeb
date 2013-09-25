/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

//import inscricao.persistence.entity.Idioma;
import musicmate.persistence.entity.Artista;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
        
            // JPQL
            // select c from Candidato c where c.idioma = :idioma order by c.nome
            TypedQuery<Artista> q = em.createQuery("SELECT * FROM Artista", Artista.class);
            List<Artista> artistas = q.getResultList();

            return artistas;
        } finally {
            if (em != null) em.close();
        }
    }

    public int findArtistasByNome(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
