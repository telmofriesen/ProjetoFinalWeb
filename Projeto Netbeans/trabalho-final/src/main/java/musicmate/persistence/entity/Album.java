/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmate.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author johntheo
 */
@Entity
@Table(name = "album")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByCodigo", query = "SELECT a FROM Album a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Album.findByTitulo", query = "SELECT a FROM Album a WHERE a.titulo = :titulo")})
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 2147483647)
    @Column(name = "titulo")
    private String titulo;
    @OneToMany(mappedBy = "codigoAlbum")
    private Collection<Faixa> faixaCollection;
    @JoinColumn(name = "codigo_artista", referencedColumnName = "codigo")
    @ManyToOne
    private Artista codigoArtista;

    public Album() {
    }

    public Album(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlTransient
    public Collection<Faixa> getFaixaCollection() {
        return faixaCollection;
    }

    public void setFaixaCollection(Collection<Faixa> faixaCollection) {
        this.faixaCollection = faixaCollection;
    }

    public Artista getCodigoArtista() {
        return codigoArtista;
    }

    public void setCodigoArtista(Artista codigoArtista) {
        this.codigoArtista = codigoArtista;
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
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "musicmate.persistence.entity.Album[ codigo=" + codigo + " ]";
    }
    
}
