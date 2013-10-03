/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmate.persistence.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author telmo
 */
@Entity
@Table(name = "perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByPapel", query = "SELECT p FROM Perfil p WHERE p.perfilPK.papel = :papel"),
    @NamedQuery(name = "Perfil.findByEmail", query = "SELECT p FROM Perfil p WHERE p.perfilPK.email = :email")})
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilPK perfilPK;
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Perfil() {
    }

    public Perfil(PerfilPK perfilPK) {
        this.perfilPK = perfilPK;
    }

    public Perfil(String papel, String email) {
        this.perfilPK = new PerfilPK(papel, email);
    }

    public PerfilPK getPerfilPK() {
        return perfilPK;
    }

    public void setPerfilPK(PerfilPK perfilPK) {
        this.perfilPK = perfilPK;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilPK != null ? perfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.perfilPK == null && other.perfilPK != null) || (this.perfilPK != null && !this.perfilPK.equals(other.perfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "musicmate.persistence.entity.Perfil[ perfilPK=" + perfilPK + " ]";
    }
    
}
