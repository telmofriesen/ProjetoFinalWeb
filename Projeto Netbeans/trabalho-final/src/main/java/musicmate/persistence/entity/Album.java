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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author telmo
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 2147483647)
    @Column(name = "titulo")
    private String titulo;
    @JoinColumn(name = "codigo_usuario", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Usuario codigoUsuario;
    @JoinColumn(name = "codigo_artista", referencedColumnName = "codigo")
    @ManyToOne
    private Artista codigoArtista;
    @OneToMany(mappedBy = "codigoAlbum")
    private Collection<Faixa> faixaCollection;

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

    public Usuario getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Usuario codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Artista getCodigoArtista() {
        return codigoArtista;
    }

    public void setCodigoArtista(Artista codigoArtista) {
        this.codigoArtista = codigoArtista;
    }

    @XmlTransient
    public Collection<Faixa> getFaixaCollection() {
        return faixaCollection;
    }

    public void setFaixaCollection(Collection<Faixa> faixaCollection) {
        this.faixaCollection = faixaCollection;
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
