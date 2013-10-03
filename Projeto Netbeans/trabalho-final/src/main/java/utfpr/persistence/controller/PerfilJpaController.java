/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

//import inscricao.persistence.entity.Idioma;
import musicmate.persistence.entity.Perfil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

    public int findPerfisByNome(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
