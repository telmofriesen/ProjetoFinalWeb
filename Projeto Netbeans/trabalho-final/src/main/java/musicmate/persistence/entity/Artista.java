/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmate.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author telmo
 */
@Entity
@Table(name="artista")
@NamedQueries({
    @NamedQuery(name = "Artista.findAll", query = "SELECT e FROM Artista e")})
public class Artista implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    
    public Artista() {
    }

    public Artista(Integer codigo) {
        this.codigo = codigo;
    }

    public Artista(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artista)) {
            return false;
        }
        Artista other = (Artista) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "musicmatepersistence.entity.Artista[ codigo=" + codigo + " ]";
    }
}
