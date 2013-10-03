/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

//import inscricao.persistence.entity.Idioma;
import musicmate.persistence.entity.Faixa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
    
    public List<Faixa> findFaixas() {
        EntityManager em = null;        
        try {
            em = getEntityManager();
        
            // JPQL
            // select c from Candidato c where c.idioma = :idioma order by c.nome
            TypedQuery<Faixa> q = em.createQuery("SELECT * FROM faixa", Faixa.class);
            List<Faixa> faixas = q.getResultList();

            return faixas;
        } finally {
            if (em != null) em.close();
        }
    }

    public int findFaixasByNome(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
