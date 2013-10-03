/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

//import inscricao.persistence.entity.Idioma;
import musicmate.persistence.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

    public int findUsuarioByNome(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
